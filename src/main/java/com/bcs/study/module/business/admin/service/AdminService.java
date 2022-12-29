package com.bcs.study.module.business.admin.service;

import com.bcs.study.common.PageResultDTO;
import com.bcs.study.common.ResponseDTO;
import com.bcs.study.module.business.admin.domain.entity.AdminEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bcs.study.module.business.admin.domain.form.AdminAddForm;
import com.bcs.study.module.business.admin.domain.form.AdminQueryForm;
import com.bcs.study.module.business.admin.domain.form.AdminUpdateForm;
import com.bcs.study.module.business.admin.domain.vo.AdminVO;

import java.util.List;

/**
 * @Desc 管理员表 服务类
 * @Data
 * @Author bcs
 * @Version 1.0.0
 */
public interface AdminService extends IService<AdminEntity> {

    /**
     * 分页查询
     * @param adminQueryForm
     * @return
     */
    ResponseDTO<PageResultDTO<AdminVO>> pageQueryAdmin(AdminQueryForm adminQueryForm);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    ResponseDTO<AdminVO> getAdmin(Long id);

    /**
     * 新增
     * @param adminAddForm
     * @return
     */
    ResponseDTO<String> addAdmin(AdminAddForm adminAddForm);

    /**
     * 更改
     * @param adminUpdateForm
     * @return
     */
    ResponseDTO<String> updateAdmin(AdminUpdateForm adminUpdateForm);

    /**
     * 批量删除(逻辑删除)
     * @param ids
     * @return
     */
    ResponseDTO<String> batchDeleteAdmin(List<Long> ids);
}