package com.bcs.study.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * 读取纯文本工具类
 *
 * @Author bcs
 * @Date 2024/1/18 15:51
 * @Version 1.0
 * @Desc
 */
@Slf4j
public class NovelUtils {
    public static void main(String[] args) throws Exception {
        //List<String> novel = getNovel("e:\\testA", Collections.singletonList("甲"));
        Charset ascii = StandardCharsets.US_ASCII;
        Map<String, Map<String, Integer>> novel = getNovel("e:\\test", new ArrayList<>(Arrays.asList("", "")));
        novel.forEach((k, v) -> {
            log.info("路径:{}", k);
            v.forEach((k1, v1) -> log.info("关键词:{}, 个数:{}", k1, v1));
        });
    }

    /**
     * 获取传入路径下所有包含了关键字的txt文件
     *
     * @param path     读取路径
     * @param keywords 关键字
     * @return TXT文件名
     */
    public static Map<String, Map<String, Integer>> getNovel(String path, List<String> keywords) throws Exception {
        Map<String, Map<String, Integer>> novels = new LinkedHashMap<>();
        // 未设置关键词,直接返回
        if (ValidUtils.isEmpty(keywords)) {
            return novels;
        }
        // 检查路径是否正确
        File originFile = new File(path);
        if (!originFile.exists()) {
            return novels;
        }
        // 传入的路径是txt文件
        if (originFile.isFile() && "text/plain".equals(Files.probeContentType(Paths.get(path)))) {
            log.info("**********当前文件:{}", originFile.getName());
            Map<String, Integer> keywordMap = new LinkedHashMap<>();
            try (FileReader fileReader = new FileReader(originFile)) {
                // utf8编码导致字符串数量为3的倍数,这里除以2是因为有部分非文字
                int fileSize = (int) (originFile.length());
                log.info("文件的长度除以2为:{}", fileSize);
                if (fileSize == 0) {
                    return novels;
                }
                char[] c = new char[fileSize];
                int read = fileReader.read(c);
                log.info("读取到的字符数量为:{}", read);
                String content = new String(c, 0, read);
                //log.info("待匹配的文本:{}", content);
                for (String keyword : keywords) {
                    log.info("当前待匹配关键字:{}", keyword);
                    int count = 0;
                    int index = content.indexOf(keyword);
                    if (index != -1) {
                        count++;
                        while ((index = content.indexOf(keyword, index + keyword.length())) != -1) {
                            count++;
                        }
                    }
                    if (count != 0) {
                        keywordMap.put(keyword, count);
                    }
                }
                if (keywordMap.size() > 0) {
                    novels.put(originFile.getAbsolutePath(), keywordMap);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        // 传入的路径是文件夹
        if (originFile.isDirectory()) {
            List<File> files = readFilesRecursively(originFile);
            for (File file : files) {
                if (!"text/plain".equals(Files.probeContentType(Paths.get(file.getAbsolutePath())))) {
                    continue;
                }
                log.info("**********当前文件:{}", file.getName());
                Map<String, Integer> keywordMap = new LinkedHashMap<>();
                try (FileReader fileReader = new FileReader(file)) {
                    // utf8编码导致字符串数量为3的倍数,这里除以2是因为有部分非文字
                    int fileSize = (int) (file.length());
                    log.info("文件的长度除以2为:{}", fileSize);
                    if (fileSize == 0) {
                        return novels;
                    }
                    char[] c = new char[fileSize];
                    int read = fileReader.read(c);
                    log.info("读取到的字符数量为:{}", read);
                    String content = new String(c, 0, read);
                    //log.info("待匹配的文本:{}", content);
                    for (String keyword : keywords) {
                        log.info("当前待匹配关键字:{}", keyword);
                        int count = 0;
                        int index = content.indexOf(keyword);
                        if (index != -1) {
                            count++;
                            while ((index = content.indexOf(keyword, index + keyword.length())) != -1) {
                                count++;
                            }
                        }
                        if (count != 0) {
                            keywordMap.put(keyword, count);
                        }
                    }
                    if (keywordMap.size() > 0) {
                        novels.put(file.getAbsolutePath(), keywordMap);
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return novels;
    }

    public static List<File> readFilesRecursively(File directory) {
        List<File> reFiles = new ArrayList<>();
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        readFilesRecursively(file);
                    } else {
                        reFiles.add(file);
                    }
                }
            }
        }
        return reFiles;
    }
}
