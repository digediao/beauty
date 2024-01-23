package com.ruoyi.system.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.system.domain.dto.TUserDto;
import com.ruoyi.system.service.impl.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author digediao
 * @version 1.0
 * @description TODO
 * @Date 2024/1/23 15:39
 */


@RestController
@RequestMapping("/beauty/user")
public class TUserController extends BaseController {
    @Autowired
    private TUserService userService;

    @GetMapping("/getUser")
    public AjaxResult getUser() {
        TUserDto user = userService.getUser();
        if(user == null) {return AjaxResult.error("用户不存在");}
        return AjaxResult.success(user);
    }
}
