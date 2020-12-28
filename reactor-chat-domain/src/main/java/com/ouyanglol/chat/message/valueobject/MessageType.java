package com.ouyanglol.chat.message.valueobject;

/**
 * @author ouyangduning
 * @date 2020/12/14 22:23
 */
public enum MessageType {
    /**
     * 文本
     */
    TEXT(1),
    /**
     * 图片
     */
    IMG(2),
    ;
    private final Integer code;
    MessageType(Integer code) {
        this.code = code;
    }

    public static MessageType getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (MessageType e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
