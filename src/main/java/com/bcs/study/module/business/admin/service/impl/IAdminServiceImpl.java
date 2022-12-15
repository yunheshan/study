package com.bcs.study.module.business.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bcs.study.common.PageResultDTO;
import com.bcs.study.common.ResponseDTO;
import com.bcs.study.module.business.admin.dao.AdminDao;
import com.bcs.study.module.business.admin.domain.AdminDO;
import com.bcs.study.module.business.admin.domain.dto.AdminSaveDTO;
import com.bcs.study.module.business.admin.domain.dto.AdminQueryDTO;
import com.bcs.study.module.business.admin.domain.dto.AdminUpdateDTO;
import com.bcs.study.module.business.admin.domain.vo.AdminVO;
import com.bcs.study.module.business.admin.service.IAdminService;
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
public class IAdminServiceImpl extends ServiceImpl<AdminDao, AdminDO> implements IAdminService {

    @Override
    public ResponseDTO<PageResultDTO<AdminVO>> listPageAdmins(AdminQueryDTO adminQueryDTO) {
        Page<AdminVO> adminVOPage = PageUtils.convert2QueryPage(adminQueryDTO);
        IPage<AdminVO> adminVOIPage = baseMapper.listPageAdmins(adminVOPage, adminQueryDTO);
        PageResultDTO<AdminVO> adminVOPageResultDTO = PageUtils.convert2PageResult(adminVOIPage);
        return ResponseDTO.successData(adminVOPageResultDTO);
    }

    @Override
    public ResponseDTO<String> saveAdmin(AdminSaveDTO adminSaveDTO) {
        AdminDO adminDO = PackedBeanUtils.copy2Class(adminSaveDTO, AdminDO.class);
        baseMapper.insert(adminDO);
        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO<String> updateAdmin(AdminUpdateDTO adminUpdateDTO) {
        AdminDO adminDO = PackedBeanUtils.copy2Class(adminUpdateDTO, AdminDO.class);
        baseMapper.updateById(adminDO);
        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO<String> removeBatchAdmin(List<Long> ids) {
        baseMapper.removeBatchAdmin(ids);
        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO<AdminVO> getAdmin(Long id) {
        AdminVO adminVO = baseMapper.selectById(id);
        return ResponseDTO.successData(adminVO);
    }

    @Override
    public ResponseDTO<String> deleteBatchAdmin(List<Long> ids) {
        baseMapper.deleteBatchAdmin(ids);
        return ResponseDTO.success();
    }
}