package com.bcs.study.module.admin.controller;

import com.bcs.study.module.admin.bean.Admin;
import com.bcs.study.module.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author bcs
 * @since 2022-12-07
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/")
    public List<Admin> selectAllAdmin(){
        return adminService.list();
    }
}
