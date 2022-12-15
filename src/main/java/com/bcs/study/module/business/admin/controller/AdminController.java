package com.bcs.study.module.business.admin.controller;

import com.bcs.study.common.PageResultDTO;
import com.bcs.study.common.ResponseDTO;
import com.bcs.study.module.business.admin.domain.dto.AdminSaveDTO;
import com.bcs.study.module.business.admin.domain.dto.AdminQueryDTO;
import com.bcs.study.module.business.admin.domain.dto.AdminUpdateDTO;
import com.bcs.study.module.business.admin.domain.vo.AdminVO;
import com.bcs.study.module.business.admin.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Desc 管理员表 前端控制器
 * @Data
 * @Author bcs
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/admin")
@Tag(name = "AdminController" ,description = "管理员表控制器")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/listPageAdmins")
    @Operation(summary = "分页查询管理员",description = "分页查询管理员description" )
    public ResponseDTO<PageResultDTO<AdminVO>> listPageAdmins(@Parameter(description = "分页参数") AdminQueryDTO adminQueryDTO){
        return adminService.listPageAdmins(adminQueryDTO);
    }

    @PostMapping("/saveAdmin")
    @Operation(description = "添加管理员" )
    public ResponseDTO<String> saveAdmin(@RequestBody AdminSaveDTO adminSaveDTO){
        return adminService.saveAdmin(adminSaveDTO);
    }

    @PostMapping("/updateAdmin")
    @Operation(description = "修改管理员" )
    public ResponseDTO<String> updateAdmin(@RequestBody AdminUpdateDTO adminUpdateDTO){
        return adminService.updateAdmin(adminUpdateDTO);
    }
}