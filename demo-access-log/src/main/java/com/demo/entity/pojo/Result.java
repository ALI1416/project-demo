package com.demo.entity.pojo;

import com.demo.base.ToStringBase;
import com.demo.constant.ResultEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>统一返回</h1>
 *
 * <p>
 * createDate 2020/11/11 11:11:11
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 **/
@Getter
@Setter
public class Result<T> extends ToStringBase {

    /**
     * 是否成功(状态码为0时成功)
     */
    private boolean ok;
    /**
     * 状态码
     *
     * @see ResultEnum
     */
    private int code;
    /**
     * 状态信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    /**
     * 构造函数
     */
    public Result() {
    }

    /**
     * 构造函数
     *
     * @param resultEnum 统一返回状态枚举
     * @param data       数据
     */
    public Result(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
        this.ok = (this.code == ResultEnum.OK.getCode());
    }

    /**
     * 成功
     *
     * @param data 数据
     */
    public static <T> Result<T> o(T data) {
        return new Result<>(ResultEnum.OK, data);
    }

}
