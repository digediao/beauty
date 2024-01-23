package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.system.domain.TUserDetails;
import com.ruoyi.system.domain.dto.TUserDto;
import com.ruoyi.system.mapper.TUserDetailsMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author digediao
 * @version 1.0
 * @description TODO
 * @Date 2024/1/23 16:03
 */

@Service
public class TUserService {
    @Resource
    private TUserDetailsMapper userMapper;

    public TUserDto getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        // 获取用户信息
//        TUserDetails userDetails = userMapper.selectOne(new QueryWrapper<TUserDetails>()
//                .eq("user_id", loginUser.getUser().getUserId())
//                .select("id, recipient, address")
//        );
        TUserDetails userDetails = userMapper.getUser(loginUser.getUser().getUserId());
        String recipient = null;
        String address = null;
        if(userDetails != null) {
            recipient = userDetails.getRecipient();
            address = userDetails.getAddress();
        }

        // 构造用户信息
        TUserDto userDto = TUserDto.builder()
                .userId(loginUser.getUser().getUserId())
                .account(loginUser.getUsername())
                .recipient(recipient)
                .address(address)
                .nickName(loginUser.getUser().getNickName())
                .email(loginUser.getUser().getEmail())
                .phonenumber(loginUser.getUser().getPhonenumber())
                .sex(loginUser.getUser().getSex())
                .avatar(loginUser.getUser().getAvatar())
                .token(loginUser.getToken())
                .status(loginUser.getUser().getStatus())
                .build();

        return userDto;
    }
}
