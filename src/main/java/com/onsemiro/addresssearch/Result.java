package com.onsemiro.addresssearch;

import java.io.Serializable;

public class Result{
    private Object common;
    private Object juso;

    public Result() {
    }

    public Result(Object common, Object juso) {
        this.common = common;
        this.juso = juso;
    }

    public Object getCommon() {
        return common;
    }

    public void setCommon(Object common) {
        this.common = common;
    }

    public Object getJuso() {
        return juso;
    }

    public void setJuso(Object juso) {
        this.juso = juso;
    }

    @Override
    public String toString() {
        return "Result{" +
                "common=" + common +
                ", juso=" + juso +
                '}';
    }
}
