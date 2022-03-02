package com.example.sidebar;

public class userInputdb {

    String schoolname,spinner1,spinner2;

    public userInputdb(String schoolname, String spinner1, String spinner2) {
        this.schoolname = schoolname;
        this.spinner1 = spinner1;
        this.spinner2 = spinner2;
    }

    public userInputdb(){

    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getSpinner1() {
        return spinner1;
    }

    public void setSpinner1(String spinner1) {
        this.spinner1 = spinner1;
    }

    public String getSpinner2() {
        return spinner2;
    }

    public void setSpinner2(String spinner2) {
        this.spinner2 = spinner2;
    }
}
