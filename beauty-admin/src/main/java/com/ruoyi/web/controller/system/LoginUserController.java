package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.core.domain.model.RegisterBody;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.service.LoginService;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.ruoyi.common.core.domain.AjaxResult.error;
import static com.ruoyi.common.core.domain.AjaxResult.success;

/**
 * @author digediao
 * @version 1.0
 * @description TODO
 * @Date 2024/1/18 14:38
 */

@RestController
@RequestMapping("/login")
public class LoginUserController {
    @Resource
    private LoginService loginService;
    @Autowired
    private ISysConfigService configService;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody){
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword());
        return success(Constants.TOKEN, token);
    }

    @PostMapping("/registry")
    public AjaxResult registry(@RequestBody RegisterBody RegisterBody){
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
        {
            return error("当前系统没有开启注册功能！");
        }
        String msg = loginService.register(RegisterBody);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }

    @PostMapping("/logout")
    public AjaxResult logout(){
        return loginService.logout();
    }
}
