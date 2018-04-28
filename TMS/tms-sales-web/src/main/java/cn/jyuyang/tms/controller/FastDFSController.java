package cn.jyuyang.tms.controller;

import cn.jyuyang.tms.dto.ResponseBean;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.file.FastDFSUtil;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
@RequestMapping("/file")
public class FastDFSController {

    @Autowired
    private FastDFSUtil fastDFSUtil;
    @PostMapping("/upload")
    @ResponseBody
    public ResponseBean upload(MultipartFile file){
        if(!file.isEmpty()){
            try{
                InputStream inputStream = file.getInputStream();
                String fileName = file.getOriginalFilename();
                String extName =fileName.substring(fileName.lastIndexOf(".")+1);

                String fileId= fastDFSUtil.uploadFile(inputStream,extName);
                return ResponseBean.success(fileId);

            }catch (IOException ex){
                ex.printStackTrace();
                return ResponseBean.error("上传异常");
            }
        }else{
            return ResponseBean.error("请上传文件");
        }
    }

    @GetMapping("/down")
    public void downloadFile(String fileId, HttpServletResponse response) throws IOException {
        byte[] bytes = fastDFSUtil.downloadFile(fileId);
        if(bytes != null ) {
            OutputStream outputStream = response.getOutputStream();

            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        }
    }
}
