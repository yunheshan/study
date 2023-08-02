package com.bcs.study.util;

import cn.hutool.http.HttpUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.HttpHeaders;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Objects;

/**
 * 获取IP地址和真实地址的工具类
 *
 * @Author bcs
 * @Date 2023/8/2 16:39
 * @Version 1.0
 * @Desc
 */
public class IPUtils {

    public static final String UNKNOWN = "unknown";

    public static final String X_FORWARDED_FOR = "x-forwarded-for";

    public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";

    public static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";

    public static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";

    public static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";

    public static final String X_REAL_IP = "X-Real-IP";

    public static final String LOCAL_IP_V4 = "127.0.0.1";

    public static final String LOCAL_IP_V6 = "0:0:0:0:0:0:0:1";

    public static final String CDN_SRC_IP = "cdn-src-ip";

    /**
     * 获取请求IP.
     *
     * @return String ip
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader(X_FORWARDED_FOR);
        if (ip != null && ip.length() != 0 && !UNKNOWN.equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.contains(",")) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(PROXY_CLIENT_IP);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(WL_PROXY_CLIENT_IP);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(HTTP_CLIENT_IP);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(HTTP_X_FORWARDED_FOR);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(X_REAL_IP);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (LOCAL_IP_V4.equals(ip) || LOCAL_IP_V6.equals(ip)) {
                // 根据网卡取本机配置的IP
                InetAddress inet;
                try {
                    inet = InetAddress.getLocalHost();
                    ip = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }
        return ip;
    }

    /**
     * 根据ip获取归属地
     *
     * @return String address
     */
    public static String getAddress(String ip) {
        try {
            URL realUrl = new URL("https://whois.pconline.com.cn/?ip=" + ip);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setUseCaches(false);
            conn.setReadTimeout(6000);
            conn.setConnectTimeout(6000);
            conn.setInstanceFollowRedirects(false);
            int code = conn.getResponseCode();
            StringBuilder sb = new StringBuilder();
            String ipaddr = "";
            if (code == 200) {
                InputStream in = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, "GBK"));//指定编码格式
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                System.out.println("==" + sb);
                String pro = sb.substring((sb.indexOf("pro") + 6), sb.indexOf("proCode") - 3);
                String city = sb.substring((sb.indexOf("city") + 7), sb.indexOf("cityCode") - 3);
                String addr = (sb.substring(sb.indexOf("addr") + 7, sb.indexOf("regionNames") - 3)).trim();
                String ipAddr = pro + city;
                if (StringUtils.isBlank(ipAddr)) {
                    ipaddr = addr;
                } else {
                    ipaddr = pro.equals(city) ? pro : pro + city;
                }

            }
            return ipaddr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAddress2(String ip) {
        String url = "https://whois.pconline.com.cn/?ip=" + ip;
        String result = HttpUtil.get(url);
        Document document = Jsoup.parse(result);
        Elements form = document.getElementsByTag("p");
        return form.get(1).text().split("：")[1];
    }

}
