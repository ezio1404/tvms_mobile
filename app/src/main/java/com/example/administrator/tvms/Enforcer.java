package com.example.administrator.tvms;

public class Enforcer {
    private int enforcer_id;
    private String enforcer_lname,enforcer_fname,enforcer_mi,enforcer_addressProv,enforcer_addressCity,enforcer_mobile,enforcer_tel,enforcer_gender,enforcer_email,enforcer_password,enforcer_status,enforcer_type,enforcer_birthdate;

    public Enforcer() {
    }

    public Enforcer(String enforcer_lname, String enforcer_fname, String enforcer_mi, String enforcer_addressProv, String enforcer_addressCity, String enforcer_mobile, String enforcer_tel, String enforcer_gender, String enforcer_email, String enforcer_password, String enforcer_status, String enforcer_type, String enforcer_birthdate) {
        this.enforcer_lname = enforcer_lname;
        this.enforcer_fname = enforcer_fname;
        this.enforcer_mi = enforcer_mi;
        this.enforcer_addressProv = enforcer_addressProv;
        this.enforcer_addressCity = enforcer_addressCity;
        this.enforcer_mobile = enforcer_mobile;
        this.enforcer_tel = enforcer_tel;
        this.enforcer_gender = enforcer_gender;
        this.enforcer_email = enforcer_email;
        this.enforcer_password = enforcer_password;
        this.enforcer_status = enforcer_status;
        this.enforcer_type = enforcer_type;
        this.enforcer_birthdate = enforcer_birthdate;
    }

    public int getEnforcer_id() {
        return enforcer_id;
    }

    public void setEnforcer_id(int enforcer_id) {
        this.enforcer_id = enforcer_id;
    }

    public String getEnforcer_lname() {
        return enforcer_lname;
    }

    public void setEnforcer_lname(String enforcer_lname) {
        this.enforcer_lname = enforcer_lname;
    }

    public String getEnforcer_fname() {
        return enforcer_fname;
    }

    public void setEnforcer_fname(String enforcer_fname) {
        this.enforcer_fname = enforcer_fname;
    }

    public String getEnforcer_mi() {
        return enforcer_mi;
    }

    public void setEnforcer_mi(String enforcer_mi) {
        this.enforcer_mi = enforcer_mi;
    }

    public String getEnforcer_addressProv() {
        return enforcer_addressProv;
    }

    public void setEnforcer_addressProv(String enforcer_addressProv) {
        this.enforcer_addressProv = enforcer_addressProv;
    }

    public String getEnforcer_addressCity() {
        return enforcer_addressCity;
    }

    public void setEnforcer_addressCity(String enforcer_addressCity) {
        this.enforcer_addressCity = enforcer_addressCity;
    }

    public String getEnforcer_mobile() {
        return enforcer_mobile;
    }

    public void setEnforcer_mobile(String enforcer_mobile) {
        this.enforcer_mobile = enforcer_mobile;
    }

    public String getEnforcer_tel() {
        return enforcer_tel;
    }

    public void setEnforcer_tel(String enforcer_tel) {
        this.enforcer_tel = enforcer_tel;
    }

    public String getEnforcer_gender() {
        return enforcer_gender;
    }

    public void setEnforcer_gender(String enforcer_gender) {
        this.enforcer_gender = enforcer_gender;
    }

    public String getEnforcer_email() {
        return enforcer_email;
    }

    public void setEnforcer_email(String enforcer_email) {
        this.enforcer_email = enforcer_email;
    }

    public String getEnforcer_password() {
        return enforcer_password;
    }

    public void setEnforcer_password(String enforcer_password) {
        this.enforcer_password = enforcer_password;
    }

    public String getEnforcer_status() {
        return enforcer_status;
    }

    public void setEnforcer_status(String enforcer_status) {
        this.enforcer_status = enforcer_status;
    }

    public String getEnforcer_type() {
        return enforcer_type;
    }

    public void setEnforcer_type(String enforcer_type) {
        this.enforcer_type = enforcer_type;
    }

    public String getEnforcer_birthdate() {
        return enforcer_birthdate;
    }

    public void setEnforcer_birthdate(String enforcer_birthdate) {
        this.enforcer_birthdate = enforcer_birthdate;
    }
}
