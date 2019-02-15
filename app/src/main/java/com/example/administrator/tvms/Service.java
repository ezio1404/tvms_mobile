package com.example.administrator.tvms;

public class Service {
    private String agency_name, agency_id;

    public Service() {
    }

    public Service(String agency_name, String agency_id) {
        this.agency_name = agency_name;
        this.agency_id = agency_id;
    }

    public String getAgency_name() {
        return agency_name;
    }

    public void setAgency_name(String agency_name) {
        this.agency_name = agency_name;
    }

    public String getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(String agency_id) {
        this.agency_id = agency_id;
    }
}
