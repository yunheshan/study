package com.bcs.study.learn.company;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * 根据网络路径下载文件到本地
 *
 * @Author bcs
 * @Date 2023/7/11 16:16
 * @Version 1.0
 * @Desc
 */
@Slf4j
public class DownloadNetFile {


    public static String downloadFile(String fileUrl, String name) {
        long l = 0L;
        String path = null;
        String fileName = null;
        if (fileUrl != null) {
            //下载时文件名称
            if (fileUrl.contains(".pdf") || fileUrl.contains("letsign") ) {
                fileName = ".pdf";
            } else if (fileUrl.contains(".excel")) {
                fileName = ".excel";
            } else {
                fileName = ".jpeg";
            }
            int reCount = 0;
            String errMsg;
            do {
                reCount++;
                try {
                    if (name == null) {
                        name = UUID.randomUUID().toString();
                    }
                    if (!System.getProperty("os.name").toLowerCase().contains("linux")) {
                        path = "d:\\PROJECT\\" + name + fileName;
                    } else {
                        path = new File("").getCanonicalPath() + "/" + name + fileName;
                    }
                    HttpUtil.downloadFile(fileUrl, path);
                    errMsg = "";
                } catch (Exception e) {
                    errMsg = e.getMessage();
                    path = "";
                    log.error("下载失败:" + errMsg + "当前次数为:" + reCount);
                    e.printStackTrace();
                }
            } while (errMsg != null && reCount < 15);

        }
        System.out.println(System.currentTimeMillis() - l);
        return path;
    }


    public static File MultipartFileToFile(MultipartFile multiFile) {
        // 获取文件名
        String fileName = multiFile.getOriginalFilename();
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
        // 若需要防止生成的临时文件重复,可以在文件名后添加随机码

        try {
            File file = File.createTempFile(fileName, prefix);
            multiFile.transferTo(file);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
