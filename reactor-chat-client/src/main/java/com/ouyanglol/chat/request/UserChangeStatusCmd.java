package com.ouyanglol.chat.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ouyangduning
 * @date 2020/12/27 15:16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserChangeStatusCmd {
    private String userId;
    private Integer status;
}
