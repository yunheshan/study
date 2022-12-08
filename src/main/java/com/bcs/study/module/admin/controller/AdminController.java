package com.bcs.study.module.admin.controller;

import com.bcs.study.module.admin.bean.Admin;
import com.bcs.study.module.admin.bean.AdminDTO;
import com.bcs.study.module.admin.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@Tag(name = "管理员控制器",description = "管理员控制器描述")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/")
    @Operation(summary = "展示所有管理员信息",description = "方法描述")
    @Parameter(name = "id",description = "管理员ID")
    @Parameter(name = "age",description = "管理员年龄")
    public List<Admin> selectAllAdmin(String id,Integer age){
        return adminService.list();
    }

    @PostMapping("/insertAdmin")
    @Operation(summary = "新增一个管理员")
    @Parameter(name = "adminDTO",description = "管理员DTO对象")
    public String insertAdmin(@RequestBody AdminDTO adminDTO){
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDTO,admin);
        boolean save = adminService.save(admin);
        return save?"添加成功!!":"添加失败!!";
    }
}
