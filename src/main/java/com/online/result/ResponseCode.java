package com.online.result;

/**
 * Created by panlu02 on 2017/4/29.
 */
public enum ResponseCode {

    OK(0, "成功"),
    BAD_PARAMETERS(2, "参数错误"),
    INTERNAL_ERROR(10, "服务内部异常"),
    NOTLOGIN(-2, "未登录"),
    ROOTUSER(100, "超管登陆"),
    ADMINUSER(101, "普通管理员登陆"),
    USUALUSER(103, "普通用户登陆"),
    OTHER(-3,"其他异常");

    private Integer code;
    private String desc;

    ResponseCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
