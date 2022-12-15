package com.bcs.study.module.business.admin.service;

import com.bcs.study.common.PageResultDTO;
import com.bcs.study.common.ResponseDTO;
import com.bcs.study.module.business.admin.domain.AdminDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bcs.study.module.business.admin.domain.dto.AdminSaveDTO;
import com.bcs.study.module.business.admin.domain.dto.AdminQueryDTO;
import com.bcs.study.module.business.admin.domain.dto.AdminUpdateDTO;
import com.bcs.study.module.business.admin.domain.vo.AdminVO;

import java.util.List;

/**
 * @Desc 管理员表 服务类
 * @Data
 * @Author bcs
 * @Version 1.0.0
 */
public interface IAdminService extends IService<AdminDO> {

    /**
     * 分页查询
     * @param adminQueryDTO
     * @return
     */
    ResponseDTO<PageResultDTO<AdminVO>> listPageAdmins(AdminQueryDTO adminQueryDTO);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    ResponseDTO<AdminVO> getAdmin(Long id);

    /**
     * 新增
     * @param adminSaveDTO
     * @return
     */
    ResponseDTO<String> saveAdmin(AdminSaveDTO adminSaveDTO);

    /**
     * 更改
     * @param adminUpdateDTO
     * @return
     */
    ResponseDTO<String> updateAdmin(AdminUpdateDTO adminUpdateDTO);

    /**
     * 批量删除(逻辑删除)
     * @param ids
     * @return
     */
    ResponseDTO<String> removeBatchAdmin(List<Long> ids);

    /**
     * 批量删除(物理删除)
     * @param ids
     * @return
     */
    ResponseDTO<String> deleteBatchAdmin(List<Long> ids);
}