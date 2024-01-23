package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author digediao
 * @version 1.0
 * @description TODO
 * @Date 2024/1/23 16:52
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_user_details")
public class TUserDetails extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long userId;
    private String recipient;
    private String address;
}
