package com.example.guppy.service;

import com.example.guppy.entity.Blog;
import com.example.guppy.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public int insertBlogs(String title, String image, String body) {
        return blogRepository.insertBlogs(title, image, body);
    }

    public List<Blog> selectAllBlogs() {
        return blogRepository.selectAllBlogs();
    }

    public Blog selectBlogById(int id) {
        return blogRepository.selectBlogById(id);
    }

    public int updateBlog(int id, String title, String image, String body) {
        return blogRepository.updateBlog(title, image, body, id);
    }

    public int deleteBlog(int id) {
        return blogRepository.deleteBlogById(id);
    }

    public List<Blog> homepageBlogs() {
        return blogRepository.homepageBlogs();
    }
}
