package cn.jyuyang.tms.file;

import org.apache.commons.io.IOUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FastDFSUtil {
    public static void main(String[] args) throws IOException, MyException {
        Properties properties = new Properties();
        properties.setProperty(ClientGlobal.PROP_KEY_TRACKER_SERVERS,"192.168.137.166:22122");
        ClientGlobal.initByProperties(properties);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer=trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);

        String fileName = "E:/images/2.jpg";
        String extName = "jpg";
        InputStream inputStream = new FileInputStream(fileName);

        String[] strs = storageClient.upload_file(IOUtils.toByteArray(inputStream),extName,null);

        for(String str:strs) {
            System.out.println(str);
        }




    }
}
