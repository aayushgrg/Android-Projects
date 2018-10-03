package com.example.neelansh.firebasedatabase;

public class model {
    public String uid;
    public String name;
    public String age;
    public String bg;
    public String healthstatus;

    /*public model() {
    }*/

    public model(String uidf,String s) {

    }

    public model(String uid,String name, String age, String bg, String healthstatus) {
        this.name = name;
        this.uid = uid;
        this.age = age;
        this.bg = bg;
        this.healthstatus = healthstatus;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getBg() {
        return bg;
    }

    public String getUid() {
        return uid;
    }

    public String getHealthstatus() {
        return healthstatus;
    }
}
