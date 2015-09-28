package com.cs616.adapterdemo;

/**
 * Created by ian.clement on 2015-09-14.
 */
public class Contact {
    private int id;
    private String name;
    private String phoneNum;

    public Contact(int id, String name, String phoneNum) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return name + " " + phoneNum;
    }
}
