package cn.jyuyang.tms.file;

import org.apache.commons.io.IOUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Map;
import java.util.Properties;
@Component
public class FastDFSUtil {

    @Value("${fastdfs.tracker.server}")
    private String trackerServerAddr;

    public String uploadFile(InputStream inputStream, String extName) {
        return uploadFile(inputStream, extName, null);
    }

    /**
     * 上传文件
     *
     * @param inputStream
     * @param extName
     * @return
     */
    public String uploadFile(InputStream inputStream, String extName, Map<String, String> param) {
        try {
            StorageClient storageClient = getStorageClient();

            NameValuePair[] nameValuePairs = null;
            if (param != null) {
                nameValuePairs = new NameValuePair[param.size()];
                int i = 0;
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    NameValuePair nameValuePair = new NameValuePair();
                    nameValuePair.setName(entry.getKey());
                    nameValuePair.setValue(entry.getValue());

                    nameValuePairs[i] = nameValuePair;
                    i++;
                }
            }

            String[] strs = storageClient.upload_file(IOUtils.toByteArray(inputStream), extName, nameValuePairs);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : strs) {
                stringBuffer.append(str).append("/");
            }
            return stringBuffer.toString().substring(0,stringBuffer.toString().lastIndexOf("/"));
        } catch (IOException | MyException ex) {
            throw new RuntimeException("上传文件异常！", ex);
        }


    }

    /**
     * 下载文件
     * @param fileId
     * @return
     */
    public byte[] downloadFile(String fileId) {
        try {
            StorageClient storageClient = getStorageClient();

            String groupName = fileId.substring(0,fileId.indexOf("/"));
            String filePath = fileId.substring(fileId.indexOf("/")+1);
            return  storageClient.download_file(groupName,filePath);
        } catch (IOException | MyException ex) {
            throw new RuntimeException("上传文件异常！", ex);
        }
    }


    private StorageClient getStorageClient() throws IOException, MyException {
        Properties properties = new Properties();

        //指定Tracker服务器的地址
        properties.setProperty(ClientGlobal.PROP_KEY_TRACKER_SERVERS,trackerServerAddr);

        ClientGlobal.initByProperties(properties);

        //创建tracker客户端
        TrackerClient trackerClient = new TrackerClient();
        //根据客户端获取Tracker服务器对象
        TrackerServer trackerServer = trackerClient.getConnection();

        StorageServer storageServer = null;
        return new StorageClient(trackerServer, storageServer);
    }
    public void deleteFile(String fileId) {
        try {
            StorageClient storageClient = getStorageClient();

            String groupName = fileId.substring(0,fileId.indexOf("/"));
            String filePath = fileId.substring(fileId.indexOf("/")+1);

            storageClient.delete_file(groupName,filePath);
        } catch (IOException | MyException ex) {
            throw new RuntimeException("FastDFS删除文件异常:" + fileId);
        }

    }


    public static void main(String[] args) throws IOException, MyException {
        FastDFSUtil fastDFSUtil = new FastDFSUtil();

        String fileID = "group1/M00/00/00/wKiJplrj_42AeZ0NAABK7nrsjd0079.jpg";
        byte[] res = fastDFSUtil.downloadFile(fileID);
        FileOutputStream fileOutputStream = new FileOutputStream("d:/xxx.jpg");
        fileOutputStream.write(res);
        fileOutputStream.flush();
        fileOutputStream.close();

       /* String fileName = "E:/images/2.jpg";
        String extName = "jpg";
        InputStream inputStream = new FileInputStream(fileName);
        FastDFSUtil fastDFSUtil = new FastDFSUtil();

        String res = fastDFSUtil.uploadFile(inputStream,extName);
        System.out.println(res);*/
        //上传测试
       /* Properties properties = new Properties();
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
*/


    }
}
