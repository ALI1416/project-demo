package com.demo.constant;

import lombok.Getter;

/**
 * <h1>统一返回状态枚举</h1>
 *
 * <p>
 * createDate 2020/11/11 11:11:11
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 **/
@Getter
public enum ResultEnum {

    /* ==================== 成功0 ==================== */
    /**
     * 成功0
     */
    OK(0, "成功"),

    /* ==================== 未知错误-1 ==================== */
    /**
     * -1 未知错误
     */
    ERROR(-1, "未知错误");

    /**
     * 状态码
     */
    private final int code;
    /**
     * 状态信息
     */
    private final String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}