package com.onsemiro.addresssearch;

import java.io.Serializable;

public class DetailAddr implements Serializable{
    private String detail;
    private String address;

    public DetailAddr(String detail, String address) {
        this.detail = detail;
        this.address = address;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public DetailAddr() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
