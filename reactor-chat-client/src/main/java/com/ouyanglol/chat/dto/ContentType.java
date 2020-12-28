package com.ouyanglol.chat.dto;

import lombok.AllArgsConstructor;

/**
 * @author ouyangduning
 * @date 2020/11/1 01:42
 */
@AllArgsConstructor
public enum  ContentType {
    /**
     * 文字
     */
    TEXT(1),
    /**
     * 图片
     */
    IMG(2);
    /**
     * 类型
     */
    private final Integer type;

    public Integer getType() {
        return this.type;
    }

    public ContentType getEnum(Integer type) {
        switch (type){
            case 1:
                return TEXT;
            case 2:
                return IMG;
            default:
                throw new IllegalArgumentException("不存在此枚举");
        }
    }
}
