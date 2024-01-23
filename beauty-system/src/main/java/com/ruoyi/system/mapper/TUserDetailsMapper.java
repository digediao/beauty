package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.TUserDetails;

/**
 * @author digediao
 * @version 1.0
 * @description TODO
 * @Date 2024/1/23 16:03
 */
public interface TUserDetailsMapper extends BaseMapper<TUserDetails> {
    TUserDetails getUser(Long userId);
}
