package com.example.banglajokes;

public class FavModel {
    int id;
    String jokes;

    public FavModel() {
    }

    public FavModel(int id, String jokes) {
        this.id = id;
        this.jokes = jokes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJokes() {
        return jokes;
    }

    public void setJokes(String jokes) {
        this.jokes = jokes;
    }
}
