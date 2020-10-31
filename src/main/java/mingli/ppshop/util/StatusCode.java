package mingli.ppshop.util;

import lombok.Getter;

@Getter
public enum StatusCode {
    COMMON_REQUEST_SUCCESS(8000, "Request success"),
    COMMON_REQUEST_FAILED(9000, "Request failed"),

    PARAMS_ERROR(9001, "Params error"),
    REMOTE_ERROR(9002, "Remote error"),
    REPEAT_ERROR(9003, "Repeat operation"),

    // signup
    SIGNUP_FAILED_EMAIL_EXIST(10001, "Email has been registered."),

    // login
    LOGIN_FAILED_PASSWORD_INVALID(20001, "Password is invalid"),
    LOGIN_FAILED_USERNAME_NOT_EXIST(20002, "Email is not found.");

    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
