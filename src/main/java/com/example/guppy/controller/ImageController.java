package com.example.guppy.controller;

import com.example.guppy.entity.Image;
import com.example.guppy.helper.Helper;
import com.example.guppy.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ImageController {
    @Autowired
    ImageService imageService;

    @RequestMapping("/admin")
    public String welcomeImage() {
        return "welcome images";
    }

    @PostMapping("/admin/images")
    public int insertImage(@RequestBody List<Image> images) {
        System.out.println("admin insert new images");
        if(images.size() == 0) return 0;

        List<String> listNames = new ArrayList<>();
        List<String> listurls = new ArrayList<>();
        List<String> listDescribes = new ArrayList<>();

        images.forEach(g -> {
            if(g.getUrl().equals("")) return;
            listNames.add(g.getName());
            listurls.add(g.getUrl());
            listDescribes.add(g.get_describe());
        });

        if(listNames.size() == 0) return 0;
        int vMax = images.size();
        String names = Helper.StrToString(listNames);
        String urls = Helper.StrToString(listurls);
        String _describes = Helper.StrToString(listDescribes);

        return imageService.insertImages(vMax, names, urls, _describes);
    }

    @GetMapping("/images/{id}")
    public Image selectImageById(@PathVariable("id") int id) {
        System.out.println("select a image by id");
        return imageService.selectImageById(id);
    }

    @GetMapping("/admin/images")
    public List<Image> selectAllImages() {
        System.out.println("admin select all image");
        return imageService.selectAllImages();
    }

    @DeleteMapping("/admin/images/{id}")
    public int deleteImageById(@PathVariable("id") int id) {
        System.out.println("admin delete a image by id = " + id);
        return imageService.deleteImageById(id);
    }

    @PutMapping("/admin/images/{id}")
    public int updateImage(@PathVariable("id") int id, @RequestBody Image image) {
        System.out.println("admin update a image id = " + id);
        if(id != image.getId()) return 0;
        return imageService.updateImage(image);
    }
}
