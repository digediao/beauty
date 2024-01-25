package com.ruoyi.system.domain.dto;

import com.ruoyi.system.domain.TBrand;
import com.ruoyi.system.domain.TCategory;
import com.ruoyi.system.domain.TMenu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author digediao
 * @version 1.0
 * @description TODO
 * @Date 2024/1/24 14:54
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsTypesDto {
    private List<TBrand> brandList;
    private List<TCategory> categoryList;
    private Map<String,List<TMenu>> menuMap;

}
