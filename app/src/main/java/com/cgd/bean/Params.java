package com.cgd.bean;

/**
 * Created by Administrator on 2017/5/29.
 */

public class Params {
    private String content;
    private Class<?> clazz;

    public Params(String content, Class<?> clazz) {
        this.content=content;
        this.clazz=clazz;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
}
