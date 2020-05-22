package com.example.finalfinalpro.clase;

import android.content.Intent;

public class User {
    private Integer id;

    private String userName;
    private String password;

    private String name;
    private String surname;
    private String phone;
    private Integer age;
    private String poblation;
    private String email;
    private boolean inmune;


    public User(){

    }

    public User(Integer id, String userName, String password, String name, String surname, String phone, Integer age, String poblation, String email, boolean inmune) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.age = age;
        this.poblation = poblation;
        this.email = email;
        this.inmune = inmune;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelefono() {
        return phone;
    }

    public void setTelefono(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPoblation() {
        return poblation;
    }

    public void setPoblation(String poblation) {
        this.poblation = poblation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isInmune() {
        return inmune;
    }

    public void setInmune(boolean inmune) {
        this.inmune = inmune;
    }

}
