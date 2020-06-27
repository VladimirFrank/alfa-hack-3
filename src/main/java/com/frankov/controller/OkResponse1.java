package com.frankov.controller;

import com.frankov.model.Office;

public class OkResponse1 implements Response {

    private Office office;

    public OkResponse1(Office office) {
        this.office = office;
    }

    public int getId() {
        return office.getId();
    }

    public String getTitle() {
        return office.getTitle();
    }

    public double getLon() {
        return office.getLon();
    }

    public double getLat() {
        return office.getLat();
    }

    public String getAddress() {
        return office.getAddress();
    }

}
