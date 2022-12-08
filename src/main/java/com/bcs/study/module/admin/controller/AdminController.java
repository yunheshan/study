package com.bcs.study.module.admin.controller;

import com.bcs.study.module.admin.bean.Admin;
import com.bcs.study.module.admin.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("控制器-管理员")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/")
    @ApiOperation("列出所有管理用户")
    public List<Admin> selectAllAdmin(){
        return adminService.list();
    }
}
