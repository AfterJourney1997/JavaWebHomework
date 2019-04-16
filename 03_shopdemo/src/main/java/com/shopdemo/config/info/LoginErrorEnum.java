package com.shopdemo.config.info;

public enum LoginErrorEnum {

    ACCOUNT_OR_PASSWORD_EMPTY(1, "账号或密码不能为空"),
    ACCOUNT_OR_PASSWORD_ERROR(2, "账号或密码错误");

    private int index;
    private String info;

    private LoginErrorEnum(int index, String info){
        this.index = index;
        this.info = info;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
