package com.ruoyi.system.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.web.PageableDefault;

import java.util.List;

/**
 * @author digediao
 * @version 1.0
 * @description TODO
 * @Date 2024/1/24 15:58
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeSortDto {
    private Long brandId;
    private Long categoryId;
    private List<Long> menuIdList;
    private String sort;
    private Integer pageNum = 1;
    private Integer pageSize = 15;
}
