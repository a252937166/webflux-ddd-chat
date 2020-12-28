package com.ouyanglol.chat.user.valueobject;

/**
 * @author ouyangduning
 * @date 2020/12/15 22:14
 */
public enum UserStatusType {
    /**
     * 在线
     */
    ONLINE(1),
    /**
     * 离线
     */
    OFFLINE(2),
    ;
    private final Integer code;

    UserStatusType(Integer code) {
        this.code = code;
    }

    /**
     * 获取code
     * @return code
     */
    public Integer getCode() {
        return this.code;
    }

    public static UserStatusType getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (UserStatusType e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
