package com.ruoyi.system.domain.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author digediao
 * @version 1.0
 * @description TODO
 * @Date 2024/1/23 15:41
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TUserDto {
    private static final long serialVersionUID = 1L;
    private Long userId;
    private String account;
    private String recipient;
    private String address;

    private String nickName;
    private String email;
    private String phonenumber;
    @JsonIgnore
    private String password;
    private String sex;
    /** 用户头像 */
    private String avatar;
    /**
     * 用户唯一标识
     */
    @JsonIgnore
    private String token;
    private String status;
    @JsonIgnore
    private String delFlag;

    @JSONField(serialize = false)
    public String getPassword()
    {
        return this.password;
    }

}
