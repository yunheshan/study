package com.bcs.study.module.business.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bcs.study.common.PageResultDTO;
import com.bcs.study.common.ResponseDTO;
import com.bcs.study.module.business.admin.dao.AdminDao;
import com.bcs.study.module.business.admin.domain.entity.AdminEntity;
import com.bcs.study.module.business.admin.domain.form.AdminAddForm;
import com.bcs.study.module.business.admin.domain.form.AdminQueryForm;
import com.bcs.study.module.business.admin.domain.form.AdminUpdateForm;
import com.bcs.study.module.business.admin.domain.vo.AdminVO;
import com.bcs.study.module.business.admin.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bcs.study.util.PackedBeanUtils;
import com.bcs.study.util.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc 管理员表 服务实现 接口
 * @Data
 * @Author bcs
 * @Version 1.0.0
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements AdminService {

    @Override
    public ResponseDTO<PageResultDTO<AdminVO>> pageQueryAdmin(AdminQueryForm adminQueryForm) {
        Page<AdminVO> adminVOPage = PageUtils.convert2QueryPage(adminQueryForm);
        IPage<AdminVO> adminVOIPage = baseMapper.pageQueryAdmin(adminVOPage, adminQueryForm);
        PageResultDTO<AdminVO> adminVOPageResultDTO = PageUtils.convert2PageResult(adminVOIPage);
        return ResponseDTO.successData(adminVOPageResultDTO);
    }

    @Override
    public ResponseDTO<String> addAdmin(AdminAddForm adminAddForm) {
        AdminEntity adminDO = PackedBeanUtils.copy2Class(adminAddForm, AdminEntity.class);
        baseMapper.insert(adminDO);
        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO<String> updateAdmin(AdminUpdateForm adminUpdateForm) {
        AdminEntity adminDO = PackedBeanUtils.copy2Class(adminUpdateForm, AdminEntity.class);
        baseMapper.updateById(adminDO);
        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO<String> batchDeleteAdmin(List<Long> ids) {
        baseMapper.batchDeleteAdmin(ids);
        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO<AdminVO> getAdmin(Long id) {
        AdminVO adminVO = baseMapper.selectById(id);
        return ResponseDTO.successData(adminVO);
    }
}