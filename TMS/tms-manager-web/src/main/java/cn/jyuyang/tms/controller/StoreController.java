package cn.jyuyang.tms.controller;

import cn.jyuyang.tms.entity.StoreSticket;
import cn.jyuyang.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;
    @GetMapping("/new")
    public String newStore(){
        return "store/new";
    }


    @PostMapping("/new")
    public String newStore(StoreSticket storeSticket,
                           MultipartFile businessPhoto,
                           MultipartFile cardBefore,
                           MultipartFile cardAfter,
                           RedirectAttributes redirectAttributes){

        storeSticket.setBusinessLicensePhoto(businessPhoto.getOriginalFilename());
        storeSticket.setManagerCardAfter(cardAfter.getOriginalFilename());
        storeSticket.setManagerCardBefore(cardBefore.getOriginalFilename());

        try {

            businessPhoto.transferTo(new File("d:/temp/photo/"+businessPhoto.getOriginalFilename()));
            cardBefore.transferTo(new File("d:/temp/photo/"+cardBefore.getOriginalFilename()));
            cardAfter.transferTo(new File("d:/temp/photo/"+cardAfter.getOriginalFilename()));

            storeService.saveStoreSticket(storeSticket);

        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message","请选择文件");
        }

        return "redirect:/store/home";
    }

    @GetMapping("/home")
    public String home(StoreSticket storeSticket,Model model){

        List<StoreSticket> storeSticketList = storeService.selectAllStoreStricket();
        model.addAttribute("storeSticketList",storeSticketList);
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


}
