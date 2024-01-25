package com.ruoyi.system.domain.mapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author digediao
 * @version 1.0
 * @description TODO
 * @Date 2024/1/24 17:08
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductMenuMapping {
    private Long id;
    private Long productId;
    private Long menuId;
    private String menuName;
    private String menuPname;
}
