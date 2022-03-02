package com.example.sidebar;

public class registerion {
    String name,email,phone,password,schoolname,spinner1,spinnner2;

    public registerion(String name, String email, String phone, String password, String schoolname, String spinner1, String spinnner2) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.schoolname = schoolname;
        this.spinner1 = spinner1;
        this.spinnner2 = spinnner2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getSpinnner2() {
        return spinnner2;
    }

    public void setSpinnner2(String spinnner2) {
        this.spinnner2 = spinnner2;
    }
}
