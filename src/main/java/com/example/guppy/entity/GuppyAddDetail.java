package com.example.guppy.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.util.List;


public class GuppyAddDetail {

    public int vMax;
    public List<Integer> listGuppy;
    public List<Integer> listImages;
    public List<Integer> listVideos;

    public GuppyAddDetail(){};

    public GuppyAddDetail(int vMax, List<Integer> listGuppy, List<Integer> listImages, List<Integer> listVideos) {
        this.vMax = vMax;
        this.listGuppy = listGuppy;
        this.listImages = listImages;
        this.listVideos = listVideos;
    }

    public void setvMax(int vMax) {
        this.vMax = vMax;
    }

    public void setListGuppy(List<Integer> listGuppy) {
        this.listGuppy = listGuppy;
    }

    public void setListImages(List<Integer> listImages) {
        this.listImages = listImages;
    }

    public void setListVideos(List<Integer> listVideos) {
        this.listVideos = listVideos;
    }
}
