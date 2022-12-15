package com.bcs.study.module.business.admin.controller;

import com.bcs.study.common.PageResultDTO;
import com.bcs.study.common.ResponseDTO;
import com.bcs.study.module.business.admin.domain.dto.AdminSaveDTO;
import com.bcs.study.module.business.admin.domain.dto.AdminQueryDTO;
import com.bcs.study.module.business.admin.domain.dto.AdminUpdateDTO;
import com.bcs.study.module.business.admin.domain.vo.AdminVO;
import com.bcs.study.module.business.admin.service.IAdminService;
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
@RequestMapping("/admin")
@Tag(name = "AdminController" ,description = "管理员表控制器")
public class AdminController {

    @Autowired
    private IAdminService iAdminService;

    @PostMapping("/listPageAdmins")
    @Operation(summary = "分页查询管理员")
    public ResponseDTO<PageResultDTO<AdminVO>> listPageAdmins(@RequestBody AdminQueryDTO adminQueryDTO){
        return iAdminService.listPageAdmins(adminQueryDTO);
    }

    @PostMapping("/getAdmin")
    @Operation(summary = "根据ID查询管理员")
    public ResponseDTO<AdminVO> getAdmin(@RequestBody Long id){
        return iAdminService.getAdmin(id);
    }

    @PostMapping("/saveAdmin")
    @Operation(summary = "添加管理员")
    public ResponseDTO<String> saveAdmin(@RequestBody AdminSaveDTO adminSaveDTO){
        return iAdminService.saveAdmin(adminSaveDTO);
    }

    @PostMapping("/updateAdmin")
    @Operation(summary = "修改管理员")
    public ResponseDTO<String> updateAdmin(@RequestBody AdminUpdateDTO adminUpdateDTO){
        return iAdminService.updateAdmin(adminUpdateDTO);
    }

    @PostMapping("/removeBatchAdmin")
    @Operation(summary = "批量删除管理员(逻辑删除)")
    public ResponseDTO<String> removeBatchAdmin(@RequestBody List<Long> ids){
        return iAdminService.removeBatchAdmin(ids);
    }

    @PostMapping("/deleteBatchAdmin")
    @Operation(summary = "批量删除管理员(物理删除)")
    public ResponseDTO<String> deleteBatchAdmin(@RequestBody List<Long> ids){
        return iAdminService.deleteBatchAdmin(ids);
    }
}