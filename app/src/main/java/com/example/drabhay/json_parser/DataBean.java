package com.example.drabhay.json_parser;

/**
 * Created by Anjli Chikara on 5/30/2015.
 */
public class DataBean {
    int id;
    String title;
    String body;

    public DataBean(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
