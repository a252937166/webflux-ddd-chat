package com.ouyanglol.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ouyangduning
 * @date 2020/12/15 22:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCO {
    /**
     * id
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 状态
     */
    private Integer status;
}
