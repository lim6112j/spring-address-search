package com.onsemiro.addresssearch;

import java.io.Serializable;

public class Addrsearch implements Serializable {
    private String keywd;
    public Addrsearch(){}
    public Addrsearch(String keywd) {
        this.keywd = keywd;
    }

    public String getKeywd() {
        return keywd;
    }

    public void setKeywd(String keywd) {
        this.keywd = keywd;
    }
}
