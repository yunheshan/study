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
import com.bcs.study.module.business.admin.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @Desc 管理员表 服务实现 接口
 * @Data
 * @Author bcs
 * @Version 1.0.0
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminDO> implements AdminService {


    @Override
    public ResponseDTO<PageResultDTO<AdminVO>> listPageAdmins(AdminQueryDTO adminQueryDTO) {
        Page<AdminVO> adminVOPage = new Page<>();
        adminVOPage.setCurrent(adminQueryDTO.getPageIndex());
        adminVOPage.setSize(adminQueryDTO.getPageSize());
        IPage<AdminVO> adminVOIPage = baseMapper.queryByPage(adminVOPage, adminQueryDTO);
        PageResultDTO<AdminVO> adminVOPageResultDTO = new PageResultDTO<>();
        adminVOPageResultDTO.setPageSize(adminVOIPage.getSize());
        adminVOPageResultDTO.setPageIndex(adminVOIPage.getCurrent());
        adminVOPageResultDTO.setRecords(adminVOIPage.getRecords());
        adminVOPageResultDTO.setTotalPage(adminVOIPage.getPages());
        adminVOPageResultDTO.setTotalCount(adminVOIPage.getTotal());
        return ResponseDTO.successData(adminVOPageResultDTO);
    }

    @Override
    public ResponseDTO<String> saveAdmin(AdminSaveDTO adminSaveDTO) {
        AdminDO adminEntity = new AdminDO();
        BeanUtils.copyProperties(adminSaveDTO,adminEntity);
        int insert = baseMapper.insert(adminEntity);
        if (insert==1)
        return ResponseDTO.success();
        else
            return ResponseDTO.fail("添加失败");
    }

    @Override
    public ResponseDTO<String> updateAdmin(AdminUpdateDTO adminUpdateDTO) {
        AdminDO adminEntity = new AdminDO();
        BeanUtils.copyProperties(adminUpdateDTO,adminEntity);
        int insert = baseMapper.updateById(adminEntity);
        if (insert==1)
            return ResponseDTO.success();
        else
            return ResponseDTO.fail("修改失败");
    }
}