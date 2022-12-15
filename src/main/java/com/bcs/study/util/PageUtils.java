package com.bcs.study.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bcs.study.common.OrderItem;
import com.bcs.study.common.PageParamDTO;
import com.bcs.study.common.PageResultDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author bcs
 * @Date 2022/12/15 9:28
 * @Version 1.0
 * @Desc 分页结果构造转换工具类
 */
public class PageUtils {

    /**
     * 把查询到的分页对象转为返回的结果对象
     * @param iPage
     * @param <T>
     * @return
     */
    public static <T> PageResultDTO<T> convert2PageResult(IPage<T> iPage){
        PageResultDTO<T> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setPageSize(iPage.getSize());
        pageResultDTO.setPageIndex(iPage.getCurrent());
        pageResultDTO.setRecords(iPage.getRecords());
        pageResultDTO.setTotalPage(iPage.getPages());
        pageResultDTO.setTotalCount(iPage.getTotal());
        return pageResultDTO;
    }

    /**
     * 把分页查询参数转化为Page对象
     * @param pageParamDTO
     * @param <T>
     * @return
     */
    public static <T> Page<T> convert2QueryPage(PageParamDTO pageParamDTO){
        Page<T> page = new Page<>();
        page.setSize(pageParamDTO.getPageSize());
        page.setCurrent(pageParamDTO.getPageIndex());
        List<OrderItem> orders = pageParamDTO.getOrders();
        if (!ValidUtils.isEmpty(orders)){
            List<com.baomidou.mybatisplus.core.metadata.OrderItem> orderItems = orders.stream()
                    .map(order -> {
                        com.baomidou.mybatisplus.core.metadata.OrderItem orderItem = new com.baomidou.mybatisplus.core.metadata.OrderItem();
                        orderItem.setAsc(order.isAsc());
                        orderItem.setColumn(order.getColumn());
                        return orderItem;
                    }).collect(Collectors.toList());
            page.setOrders(orderItems);
        }
        return page;
    }
}
