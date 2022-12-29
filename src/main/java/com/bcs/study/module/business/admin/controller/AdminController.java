package com.bcs.study.module.business.admin.controller;

import com.bcs.study.common.PageResultDTO;
import com.bcs.study.common.ResponseDTO;
import com.bcs.study.module.business.admin.domain.form.AdminAddForm;
import com.bcs.study.module.business.admin.domain.form.AdminQueryForm;
import com.bcs.study.module.business.admin.domain.form.AdminUpdateForm;
import com.bcs.study.module.business.admin.domain.vo.AdminVO;
import com.bcs.study.module.business.admin.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Desc 管理员表 前端控制器
 * @Data
 * @Author bcs
 * @Version 1.0.0
 */
@RestController
@Tag(name = "AdminController" ,description = "管理员表控制器")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/pageQueryAdmin")
    @Operation(summary = "分页查询管理员")
    public ResponseDTO<PageResultDTO<AdminVO>> pageQueryAdmin(@RequestBody AdminQueryForm adminQueryForm){
        return adminService.pageQueryAdmin(adminQueryForm);
    }

    @PostMapping("/admin/getAdmin")
    @Operation(summary = "根据ID查询管理员")
    public ResponseDTO<AdminVO> getAdmin(@RequestBody Long id){
        return adminService.getAdmin(id);
    }

    @PostMapping("/admin/addAdmin")
    @Operation(summary = "添加管理员")
    public ResponseDTO<String> addAdmin(@RequestBody AdminAddForm adminAddForm){
        return adminService.addAdmin(adminAddForm);
    }

    @PostMapping("/admin/updateAdmin")
    @Operation(summary = "修改管理员")
    public ResponseDTO<String> updateAdmin(@RequestBody AdminUpdateForm adminUpdateForm){
        return adminService.updateAdmin(adminUpdateForm);
    }

    @PostMapping("/admin/batchDeleteAdmin")
    @Operation(summary = "批量删除管理员(逻辑删除)")
    public ResponseDTO<String> batchDeleteAdmin(@RequestBody List<Long> ids){
        return adminService.batchDeleteAdmin(ids);
    }
}