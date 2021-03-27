package com.example.banglajokes;

public class JokesDetailsModel {

    String id,tag,jokes;

    public JokesDetailsModel() {
    }

    public JokesDetailsModel(String id, String tag, String jokes) {
        this.id = id;
        this.tag = tag;
        this.jokes = jokes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getJokes() {
        return jokes;
    }

    public void setJokes(String jokes) {
        this.jokes = jokes;
    }
}
