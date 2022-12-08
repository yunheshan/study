package com.bcs.study.module.business.user.controller;

import com.bcs.study.module.business.user.bean.User;
import com.bcs.study.module.business.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bcs
 * @since 2022-12-08
 */
@RestController
@RequestMapping("/user")
@Tag(name = "用户控制器", description = "用户控制器描述")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insertUser")
    @Operation(summary = "添加一个用户")
    public String insertUser(User user){
        return "";
    }

}
