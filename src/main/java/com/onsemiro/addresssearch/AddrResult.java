package com.onsemiro.addresssearch;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

public class AddrResult {
    private Result results;

    public Result getResults() {
        return results;
    }

    public void setResults(Result results) {
        this.results = results;
    }

    public AddrResult() {
    }

    public AddrResult(Result results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "AddrResult{" +
                "results=" + results +
                '}';
    }
}
