package cn.catbar.easycloud.file.controller;

import cn.catbar.easycloud.common.AppResultBuilder;
import cn.catbar.easycloud.common.bean.AppResult;
import cn.catbar.easycloud.common.eum.ResultCode;
import cn.catbar.easycloud.file.bean.FastDFSFile;
import cn.catbar.easycloud.file.client.FastDFSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class UploadController {
    private static Logger logger = LoggerFactory.getLogger(UploadController.class);



    @PostMapping("/upload") //new annotation since 4.3
    public AppResult<String> singleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return AppResultBuilder.success("Please select a file to upload", ResultCode.PARAM_NOT_COMPLETE);
        }
        String path = "";
        try {
            // Get the file and save it somewhere
            path=saveFile(file);
        } catch (Exception e) {
            logger.error("upload file failed",e);
            return AppResultBuilder.faile( ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
        }
        return AppResultBuilder.success(path, ResultCode.SUCCESS);
    }


    /**
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public String saveFile(MultipartFile multipartFile) throws IOException {
        String[] fileAbsolutePath={};
        String fileName=multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream=multipartFile.getInputStream();
        if(inputStream!=null){
            int len1 = inputStream.available();
            file_buff = new byte[len1];
            inputStream.read(file_buff);
        }
        inputStream.close();
        FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
        try {
            fileAbsolutePath = FastDFSClient.upload(file);  //upload to fastdfs
        } catch (Exception e) {
            logger.error("upload file Exception!",e);
        }
        if (fileAbsolutePath==null) {
            logger.error("upload file failed,please upload again!");
        }
        String path=FastDFSClient.getTrackerUrl()+fileAbsolutePath[0]+ "/"+fileAbsolutePath[1];
        return path;
    }
}