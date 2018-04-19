package cn.jyuyang.tms.controller;

import cn.jyuyang.tms.entity.StoreSticket;
import cn.jyuyang.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/manage/store")
public class StoreController {
    @Autowired
    private StoreService storeService;
    @GetMapping("/new")
    public String newStore(){
        return "manage/store/new";
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

        return "redirect:/manage/store/new";
    }
}
