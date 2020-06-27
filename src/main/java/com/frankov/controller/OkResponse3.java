package com.frankov.controller;

import com.frankov.model.Office;

public class OkResponse3 implements Response {

    private Office office;
    private int predicting;

    public OkResponse3(Office office, int predicting) {
        this.office = office;
        this.predicting = predicting;
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

    public int getPredicting() {
        return predicting;
    }

}
