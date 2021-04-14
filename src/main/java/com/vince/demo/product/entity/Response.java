package com.vince.demo.product.entity;

public class Response<T> extends com.vince.demo.user.entity.Response {
    T result;

    public Response() {
    }

    public Response(Boolean isSuc, String msg, int code) {
        super(isSuc, msg, code);
    }

    public void setResponse(Boolean isSuc, String msg, int code, T result) {
        setSuc(isSuc);
        setMsg(msg);
        setCode(code);
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
