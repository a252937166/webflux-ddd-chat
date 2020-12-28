package com.ouyanglol.chat.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ouyangduning
 * @date 2020/10/31 17:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ImgContent extends Content {
    private String url;
    private String height;
    private String width;

    @Override
    public String get() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException ignore) {
        }
        return null;
    }
}
