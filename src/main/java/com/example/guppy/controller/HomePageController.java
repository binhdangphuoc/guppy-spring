package com.example.guppy.controller;

import com.example.guppy.entity.Blog;
import com.example.guppy.entity.Guppy;
import com.example.guppy.service.BlogService;
import com.example.guppy.service.GuppyService;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.*;

@RestController
public class HomePageController {
    @Autowired
    GuppyService guppyService;
    @Autowired
    BlogService blogService;

    @RequestMapping(path = "home")
    public Map<String,Object> homepage() {
        List<Guppy> hotSale = guppyService.homepageHotSale();
        List<Guppy> hotGuppy = guppyService.homepageHotGuppy();
        List<Blog> blogs = blogService.homepageBlogs();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hot_sale", hotSale);
        map.put("guppy", hotGuppy);
        map.put("blogs", blogs);

        return map;
    }
}
