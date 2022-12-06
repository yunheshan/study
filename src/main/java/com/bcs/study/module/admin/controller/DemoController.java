package com.bcs.study.module.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author bcs
 * @Date 2022/12/6 13:35
 * @Version 1.0
 * @Desc
 */
@Controller
public class DemoController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "hello,world!!！！！";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
