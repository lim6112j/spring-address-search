package com.onsemiro.addresssearch;

import java.io.Serializable;

public class Juso implements Serializable {
    private String zipNo;
    private String siNm;

    public Juso() {
    }

    public Juso(String zipNo, String siNm) {
        this.zipNo = zipNo;
        this.siNm = siNm;
    }

    public String getSiNm() {
        return siNm;
    }

    public void setSiNm(String siNm) {
        this.siNm = siNm;
    }

    public String getZipNo() {
        return zipNo;
    }

    public void setZipNo(String zipNo) {
        this.zipNo = zipNo;
    }
}
