package cn.jyuyang.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
@RequestMapping("/file")
public class UploadController {
    @GetMapping("/upload")
    public String upload(@RequestHeader(name="User-Agent") String userAgent, HttpServletRequest req, HttpServletResponse resp, HttpSession session){
        System.out.println(userAgent);
        Cookie cookie = new Cookie("level","svip");
        cookie.setDomain("localhost");
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60*60*24);
        resp.addCookie(cookie);

        return "file/upload";
    }
    @PostMapping("/upload")
    public String upload(@CookieValue(name="level")String res, MultipartFile photo, String name, RedirectAttributes redirectAttributes) throws IOException {

        if(!photo.isEmpty()) {
            System.out.println("level:" + res);
            System.out.println(name);
            System.out.println(photo.getOriginalFilename());
            System.out.println(FileUtils.byteCountToDisplaySize(photo.getSize()));

           /* InputStream inputStream = photo.getInputStream();
            OutputStream outputStream = new FileOutputStream(new File("D:/upload/"+photo.getOriginalFilename()));
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
            inputStream.close();
            outputStream.close();*/
            photo.transferTo(new File("x:/upload/" + photo.getOriginalFilename()));
        }else{
            System.out.println("请选择文件");
            redirectAttributes.addFlashAttribute("message","请选择文件");
        }
        return "redirect:/file/upload";
    }

}
