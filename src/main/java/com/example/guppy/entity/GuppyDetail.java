package com.example.guppy.entity;

import java.util.List;

public class GuppyDetail {

    private int id;
    private List<String> images;
    private List<String> video;
    private int quantity;

    public GuppyDetail(){};
    public GuppyDetail(int id, List<String> images, List<String> video, int quantity) {
        this.id = id;
        this.images = images;
        this.video = video;
        this.quantity = quantity;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setVideo(List<String> video) {
        this.video = video;
    }

    public List<String> getImages() {
        return images;
    }

    public List<String> getVideo() {
        return video;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
