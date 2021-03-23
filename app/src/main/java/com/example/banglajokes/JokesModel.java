package com.example.banglajokes;

public class JokesModel {
    int id;
    String name;

    public JokesModel() {
    }

    public JokesModel(int id, String name) {
        this.id = id;
        this.name = name;
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
}
