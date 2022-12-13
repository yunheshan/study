package com.bcs.study.module.${baseInfo.packageName}.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * @Desc ${tableDesc} 前端控制器
 * @Data
 * @Author ${baseInfo.author}
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/${lowerClassName}")
@Tag(name = "${tableDesc}控制器")
public class ${className}Controller {

}