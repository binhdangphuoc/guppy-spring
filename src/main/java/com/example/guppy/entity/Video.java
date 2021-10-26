package com.example.guppy.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
@Data
public class Video {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String url;
    private String _describe;

    public Video(){};

    public Video(String name, String url, String _describe) {
        this.name = name;
        this.url = url;
        this._describe = _describe;
    }
    public Video(int id, String name, String url, String _describe) {
        this.id = id;
        this.name = name;
        this.url = url;
        this._describe = _describe;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String get_describe() {
        return _describe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void set_describe(String _describe) {
        this._describe = _describe;
    }
}
