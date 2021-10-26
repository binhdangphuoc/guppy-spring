package com.example.guppy.controller;

import com.example.guppy.entity.Image;
import com.example.guppy.entity.Video;
import com.example.guppy.helper.Helper;
import com.example.guppy.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VideoController {
    @Autowired
    VideoService videoService;

    @RequestMapping("/admin2")
    public String welcomeVideo() {
        return "welcome videos";
    }

    @PostMapping("/admin/videos")
    public int insertVideos(@RequestBody List<Video> videos) {
        System.out.println("admin insert new images");
        if(videos.size() == 0) return 0;

        List<String> listNames = new ArrayList<>();
        List<String> listurls = new ArrayList<>();
        List<String> listDescribes = new ArrayList<>();

        videos.forEach(g -> {
            if(g.getUrl().equals("")) return;
            listNames.add(g.getName());
            listurls.add(g.getUrl());
            listDescribes.add(g.get_describe());
        });

        if(listNames.size() == 0) return 0;
        int vMax = videos.size();
        String names = Helper.StrToString(listNames);
        String urls = Helper.StrToString(listurls);
        String _describes = Helper.StrToString(listDescribes);

        return videoService.insertVideos(vMax, names, urls, _describes);
    }

    @GetMapping("/videos/{id}")
    public Video selectVideoById(@PathVariable("id") int id) {
        System.out.println("select a video by id");
        return videoService.selectVideoById(id);
    }

    @GetMapping("/admin/videos")
    public List<Video> selectAllVideos() {
        System.out.println("admin select all videos");
        return videoService.selectAllVideos();
    }

    @DeleteMapping("/admin/videos/{id}")
    public int deleteVideoById(@PathVariable("id") int id) {
        System.out.println("admin delete a video by id = " + id);
        return videoService.deleteVideoById(id);
    }

    @PutMapping("/admin/videos/{id}")
    public int updateVideo(@PathVariable("id") int id, @RequestBody Video video) {
        System.out.println("admin update a video id = " + id);
        if(id != video.getId()) return 0;
        return videoService.updateVideo(video);
    }
}
