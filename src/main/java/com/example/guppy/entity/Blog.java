package com.example.guppy.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blogs")
@Data
public class Blog {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String image;
    private String body;

    public Blog() {};

    public Blog(String title, String image, String body) {
        this.title = title;
        this.image = image;
        this.body = body;
    }

    public Blog(int id, String title, String image, String body) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getBody() {
        return body;
    }
}
