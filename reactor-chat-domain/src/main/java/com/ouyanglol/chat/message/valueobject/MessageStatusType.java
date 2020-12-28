package com.ouyanglol.chat.message.valueobject;

/**
 * @author ouyangduning
 * @date 2020/12/14 21:54
 */
public enum MessageStatusType {
    /**
     * 未读
     */
    UNREAD(1),
    /**
     * 已读
     */
    READ(2),
    ;
    private final Integer code;

    MessageStatusType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public static MessageStatusType getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (MessageStatusType e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

}
