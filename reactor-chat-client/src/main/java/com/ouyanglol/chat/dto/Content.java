package com.ouyanglol.chat.dto;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author ouyangduning
 * @date 2020/10/31 16:57
 */
public abstract class Content {
    /**
     * 获取消息内容
     * @return 内容
     */
    public abstract String get() throws JsonProcessingException;
}
