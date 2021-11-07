package com.example.guppy.entity;

import java.util.ArrayList;
import java.util.List;

public class GuppyDetail {

    private Guppy guppy;
    private List<Image> images;
    private List<Video> videos;
    private int quantity;

    public GuppyDetail(){};
    public GuppyDetail(Guppy guppy, List<Image> images, List<Video> video, int quantity) {
        this.guppy = guppy;
        this.images = images;
        this.videos = video;
        this.quantity = quantity;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Image> getImages() {
        return images;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Guppy getGuppy() {
        return guppy;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setGuppy(Guppy guppy) {
        this.guppy = guppy;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
