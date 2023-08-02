package com.bcs.study.learn.company;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 批量下载文件示例
 *
 * @Author bcs
 * @Date 2023/7/11 16:07
 * @Version 1.0
 * @Desc
 */
@Slf4j
public class BatchDownload {
    /**
     * 本地文件路径
     */
    private static final String FILE_PATH = "D:\\test";

    /**
     * 批量下载文件
     *
     * @param list     批量文件集合（前端只传id集合，后端去查数据库拿到文件信息）
     * @param request  request
     * @param response response
     */
    public static void batchDownloadFile(List list, HttpServletRequest request, HttpServletResponse response) {
        //设置响应头信息
        // 此处的reset导致全局的跨域配置失效
        response.reset();
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        // 压缩包的响应头
        // response.setContentType("application/x-msdownload");
        // 导出Excel的响应头
        // response.setHeader("Content-Type", "application/vnd.ms-excel");

        String downloadName = "压缩包" + System.currentTimeMillis() + ".zip";
        //返回客户端浏览器的版本号、类型
        String agent = request.getHeader("USER-AGENT");
        try {
            //针对IE或者以IE为内核的浏览器：
            if (agent.contains("MSIE") || agent.contains("Trident")) {
                downloadName = java.net.URLEncoder.encode(downloadName, StandardCharsets.UTF_8);
            } else {
                //非IE浏览器的处理：
                downloadName = new String(downloadName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setHeader("Content-Disposition", "attachment;filename=" + downloadName + ";" + "filename*=utf-8''" + downloadName);

        //设置压缩流：直接写入response，实现边压缩边下载
        ZipOutputStream zipOs = null;
        //循环将文件写入压缩流
        DataOutputStream os = null;
        //文件
        File file;
        try {
            zipOs = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()));
            //设置压缩方法
            zipOs.setMethod(ZipOutputStream.DEFLATED);
            //遍历文件信息（主要获取文件名/文件路径等）
            for (Object t : list) {
                try {
                    //文件名（包含后缀名，如：测试.pdf）
                    Field field = t.getClass().getDeclaredField("name");
                    field.setAccessible(true);
                    String name = field.get(t).toString();
                    //本地文件路径（绝对路径，包含后缀名，如：D:\\test\\测试.pdf），这里是在windows上测试的，路径是反斜杠
                    String path = FILE_PATH + File.separator + name;
                    log.info("batchDownloadFile:[filePath:{}]", path);
                    file = new File(path);
                    if (!file.exists()) {
                        throw new RuntimeException("文件不存在");
                    }
                    //添加ZipEntry，并将ZipEntry写入文件流
                    zipOs.putNextEntry(new ZipEntry(name));
                    os = new DataOutputStream(zipOs);
                    FileInputStream fs = new FileInputStream(file);
                    byte[] b = new byte[100];
                    int length;
                    //读入需要下载的文件的内容，打包到zip文件
                    while ((length = fs.read(b)) != -1) {
                        os.write(b, 0, length);
                    }
                    //关闭流
                    fs.close();
                    zipOs.closeEntry();
                    //==============此处如果是网络文件路径，可按如下方式读取=============
					/*
					//文件名（包含后缀名,如:测试.pdf）
                    Field field = t.getClass().getDeclaredField("name");
                    field.setAccessible(true);
                    String name = field.get(t).toString() + ".pdf";
                    //网络文件路径（浏览器可直接访问的路径，如：http://192.168.0.12/frame-service-gengbao/document/四川省2022第四季度报告.pdf）
                    Field urlField = t.getClass().getDeclaredField("url");
                    urlField.setAccessible(true);
                    URL url = new URL(urlField.get(t).toString());
                    URLConnection connection = url.openConnection();
                    InputStream is = connection.getInputStream();
                    //添加ZipEntry，并将ZipEntry写入文件流
                    zipOs.putNextEntry(new ZipEntry(name));
                    os = new DataOutputStream(zipOs);
                    byte[] b = new byte[100];
                    int length;
                    //读入需要下载的文件的内容，打包到zip文件
                    while ((length = is.read(b)) != -1) {
                        os.write(b, 0, length);
                    }
                    is.close();
                    zipOs.closeEntry();
                    */
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    log.error("下载文件出错![{}]", e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (os != null) {
                    os.flush();
                    os.close();
                }
                if (zipOs != null) {
                    zipOs.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
