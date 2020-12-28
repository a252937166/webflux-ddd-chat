package com.ouyanglol.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author ouyangduning
 * @date 2020/10/31 16:59
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextContent extends Content {
    private String content;

    @Override
    public String get() {
        return this.content;
    }
}
