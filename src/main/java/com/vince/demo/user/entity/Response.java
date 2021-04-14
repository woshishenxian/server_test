package com.vince.demo.user.entity;

/**
 * 实体类
 */
public class Response {
    String msg;
    int code;
    Boolean isSuc = true;

    public Response() {
    }

    public Response(Boolean isSuc, String msg, int code) {
        this.msg = msg;
        this.code = code;
        this.isSuc = isSuc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Boolean getSuc() {
        return isSuc;
    }

    public void setSuc(Boolean suc) {
        isSuc = suc;
    }
}
