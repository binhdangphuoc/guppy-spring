package com.example.guppy.controller;

import com.example.guppy.entity.Guppy;
import com.example.guppy.service.GuppyService;
import com.example.guppy.service.ImageService;
import com.example.guppy.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AdminController {
    @Autowired
    GuppyService guppyService;
    @Autowired
    ImageService imageService;
    @Autowired
    VideoService videoService;


}
