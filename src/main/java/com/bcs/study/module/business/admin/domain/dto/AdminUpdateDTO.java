package com.bcs.study.module.business.admin.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author bcs
 * @Date 2022/12/14 15:39
 * @Version 1.0
 * @Desc
 */
@Data
public class AdminUpdateDTO extends AdminSaveDTO{

    /**
     * id
     */
    @Schema(description = "id" )
    private Long id;
}
