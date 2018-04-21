package cn.jyuyang.tms.controller;

import cn.jyuyang.tms.dto.ResponseBean;
import cn.jyuyang.tms.entity.StoreSticket;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.fileStore.QiNiu;
import cn.jyuyang.tms.service.StoreService;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private QiNiu qiNiu;


    @GetMapping("/new")
    public String newStore(Model model){
        //获取七牛文件上传token

        String upToken = qiNiu.getUploadToken();
        model.addAttribute("upToken",upToken);
        return "store/new";
    }


    @PostMapping("/new")
    public String newStore(StoreSticket storeSticket){
        System.out.println(storeSticket+"----------------------------------------s");
        storeService.saveStoreSticket(storeSticket);
        return "redirect:/store/home";
    }

    @GetMapping("/home")
    public String home(@RequestParam(name = "p",required = false,defaultValue = "1") Integer pageNo,
                       @RequestParam(required = false,defaultValue = "") String name,
                       @RequestParam(required = false,defaultValue = "") String mobile,
                       @RequestParam(required = false,defaultValue = "") String storename,
                       @RequestParam(required = false,defaultValue = "") String address,
                       Model model){

        Map<String,Object> queryParam = Maps.newHashMap();
        queryParam.put("managerName",name);
        queryParam.put("managerMobile",mobile);
        queryParam.put("storeName",storename);
        queryParam.put("ticketStoreAddress",address);
        PageInfo<StoreSticket> sticketPageInfo = storeService.selectByPageInfo(pageNo,queryParam);
        model.addAttribute("sticketPageInfo",sticketPageInfo);
        return "store/home";
    }

    @GetMapping("/{id:\\d+}/edit")
    public String edit(@PathVariable Integer id,Model model){
        StoreSticket storeSticket = storeService.selectStoreStricketById(id);
        model.addAttribute("storeSticket",storeSticket);
        return "store/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    public String edit(@PathVariable Integer id, StoreSticket storeSticket){
        storeService.updateStoreSticket(id,storeSticket);
        return "redirect:/store/home";
    }

    @GetMapping("/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean del(@PathVariable Integer id){
        try {
            storeService.delStoreSticketById(id);
            return ResponseBean.success();
        }catch (ServiceException ex){
            return ResponseBean.error(ex.getMessage());
        }

    }

}
