package com.example.guppy.controller;

import com.example.guppy.entity.Blog;
import com.example.guppy.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping(path = "/admin/blogs")
    public int insertBlog(@RequestBody Blog blog) {
        return blogService.insertBlogs(blog.getTitle(), blog.getImage(), blog.getBody());
    }

    @GetMapping(path = "/blogs")
    public List<Blog> selectAllBlogs() {
        return blogService.selectAllBlogs();
    }

    @GetMapping(path = "/blogs/{id}")
    public Blog selectBlogById(@PathVariable("id") int id) {
        return blogService.selectBlogById(id);
    }

    @PutMapping(path = "/admin/blogs")
    public int updateBlog(@RequestBody Blog blog) {
        return blogService.updateBlog(blog.getId(), blog.getTitle(), blog.getImage(), blog.getBody());
    }

    @DeleteMapping(path = "/admin/blogs/{id}")
    public int deleteBlog(@PathVariable int id) {
        return blogService.deleteBlog(id);
    }
}
