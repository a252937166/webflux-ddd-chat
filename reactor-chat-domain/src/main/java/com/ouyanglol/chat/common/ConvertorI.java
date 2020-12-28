package com.ouyanglol.chat.common;

/**
 * @author ouyangduning
 * @date 2020/12/14 21:43
 */
public interface ConvertorI {
    /**
     * Entity转Client
     * @param entityObject entity
     * @param <T>
     * @return
     */
    default <T> T entityToClient(Object... entityObject) {
        return null;
    }

    /**
     * dataObject转Client
     * @param dataObject dataObject
     * @param <T>
     * @return
     */
    default <T> T dataToClient(Object... dataObject) {
        return null;
    }

    /**
     * clientObject转Entity
     * @param clientObject clientObject
     * @param <T>
     * @return
     */
    default <T> T clientToEntity(Object... clientObject) {
        return null;
    }

    /**
     * dataObject转Entity
     * @param dataObject dataObject
     * @param <T>
     * @return
     */
    default <T> T dataToEntity(Object... dataObject) {
        return null;
    }

    /**
     * entityObject转Data
     * @param entityObject entityObject
     * @param <T>
     * @return
     */
    default <T> T entityToData(Object... entityObject) {
        return null;
    }
}
