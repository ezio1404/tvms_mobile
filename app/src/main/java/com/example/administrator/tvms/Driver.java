package com.example.administrator.tvms;

public class Driver {
    private int driver_id;
    private String license_id,driver_pincode,driver_lname,driver_fname,driver_mi,driver_gender,driver_birthdate,driver_addressProv,driver_addressCity,driver_mobile,driver_tel,driver_type,driver_email,driver_password,driver_status;


    public Driver() {
    }

    public Driver(String license_id, String driver_pincode, String driver_lname, String driver_fname, String driver_mi, String driver_gender, String driver_birthdate, String driver_addressProv, String driver_addressCity, String driver_mobile, String driver_tel, String driver_type, String driver_email, String driver_password, String driver_status) {
        this.license_id = license_id;
        this.driver_pincode = driver_pincode;
        this.driver_lname = driver_lname;
        this.driver_fname = driver_fname;
        this.driver_mi = driver_mi;
        this.driver_gender = driver_gender;
        this.driver_birthdate = driver_birthdate;
        this.driver_addressProv = driver_addressProv;
        this.driver_addressCity = driver_addressCity;
        this.driver_mobile = driver_mobile;
        this.driver_tel = driver_tel;
        this.driver_type = driver_type;
        this.driver_email = driver_email;
        this.driver_password = driver_password;
        this.driver_status = driver_status;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getLicense_id() {
        return license_id;
    }

    public void setLicense_id(String license_id) {
        this.license_id = license_id;
    }

    public String getDriver_pincode() {
        return driver_pincode;
    }

    public void setDriver_pincode(String driver_pincode) {
        this.driver_pincode = driver_pincode;
    }

    public String getDriver_lname() {
        return driver_lname;
    }

    public void setDriver_lname(String driver_lname) {
        this.driver_lname = driver_lname;
    }

    public String getDriver_fname() {
        return driver_fname;
    }

    public void setDriver_fname(String driver_fname) {
        this.driver_fname = driver_fname;
    }

    public String getDriver_mi() {
        return driver_mi;
    }

    public void setDriver_mi(String driver_mi) {
        this.driver_mi = driver_mi;
    }

    public String getDriver_gender() {
        return driver_gender;
    }

    public void setDriver_gender(String driver_gender) {
        this.driver_gender = driver_gender;
    }

    public String getDriver_birthdate() {
        return driver_birthdate;
    }

    public void setDriver_birthdate(String driver_birthdate) {
        this.driver_birthdate = driver_birthdate;
    }

    public String getDriver_addressProv() {
        return driver_addressProv;
    }

    public void setDriver_addressProv(String driver_addressProv) {
        this.driver_addressProv = driver_addressProv;
    }

    public String getDriver_addressCity() {
        return driver_addressCity;
    }

    public void setDriver_addressCity(String driver_addressCity) {
        this.driver_addressCity = driver_addressCity;
    }

    public String getDriver_mobile() {
        return driver_mobile;
    }

    public void setDriver_mobile(String driver_mobile) {
        this.driver_mobile = driver_mobile;
    }

    public String getDriver_tel() {
        return driver_tel;
    }

    public void setDriver_tel(String driver_tel) {
        this.driver_tel = driver_tel;
    }

    public String getDriver_type() {
        return driver_type;
    }

    public void setDriver_type(String driver_type) {
        this.driver_type = driver_type;
    }

    public String getDriver_email() {
        return driver_email;
    }

    public void setDriver_email(String driver_email) {
        this.driver_email = driver_email;
    }

    public String getDriver_password() {
        return driver_password;
    }

    public void setDriver_password(String driver_password) {
        this.driver_password = driver_password;
    }

    public String getDriver_status() {
        return driver_status;
    }

    public void setDriver_status(String driver_status) {
        this.driver_status = driver_status;
    }
}
