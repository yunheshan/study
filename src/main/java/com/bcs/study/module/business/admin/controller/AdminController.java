package com.bcs.study.module.business.admin.controller;

import com.bcs.study.module.business.admin.bean.Admin;
import com.bcs.study.module.business.admin.bean.AdminDTO;
import com.bcs.study.module.business.admin.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/")
    @Operation(summary = "展示所有管理员信息",description = "方法描述")
    public List<Admin> selectAllAdmin(){
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
