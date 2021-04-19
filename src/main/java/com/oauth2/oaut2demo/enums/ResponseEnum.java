package com.oauth2.oaut2demo.enums;

public enum ResponseEnum {

    USER_LOGGEDIN_FAILED("USR_ERR_01"),
    USER_LOGGEDIN_SUCCESS("USR_SUC_01"),
    ERROR("ERROR"),
    SUCCESS("SUCCESS"),
    USER_ACCESS_GRANTED("USR_AUTH_SUC_01"),
    USER_NOT_FOUND("USR_ERR_02"),
    EXCEPTION("SYS_ERR_01");

    private String value;

    ResponseEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
