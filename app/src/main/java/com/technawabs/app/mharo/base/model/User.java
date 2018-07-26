package com.technawabs.app.mharo.base.model;

import java.util.List;

public class User {

    private int id;
    private String name;
    private int age;
    private boolean emploeyed;
    private String address;
    private List<CardDetail> getCards;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isEmploeyed() {
        return emploeyed;
    }

    public void setEmploeyed(boolean emploeyed) {
        this.emploeyed = emploeyed;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CardDetail> getGetCards() {
        return getCards;
    }

    public void setGetCards(List<CardDetail> getCards) {
        this.getCards = getCards;
    }
}
