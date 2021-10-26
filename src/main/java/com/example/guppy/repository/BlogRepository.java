package com.example.guppy.repository;

import com.example.guppy.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO blogs (title, image, body) VALUES(:title, :image, :body)", nativeQuery = true)
    int insertBlogs(@Param("title") String title, @Param("image") String image, @Param("body") String body);

    @Modifying
    @Transactional
    @Query(value = "SELECT id, title, image, body FROM blogs", nativeQuery = true)
    List<Blog> selectAllBlogs();


    @Transactional
    @Query(value = "SELECT id, title, image, body FROM blogs WHERE id = :id", nativeQuery = true)
    Blog selectBlogById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE blogs SET title = :title, image = :image, body = :body WHERE id = :id", nativeQuery = true)
    int updateBlog(@Param("title") String title, @Param("image") String image, @Param("body") String body, @Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE from blogs WHERE id = :id", nativeQuery = true)
    int deleteBlogById(@Param("id") int id);

    @Transactional
    @Query(value = "SELECT id, title, image, body FROM blogs", nativeQuery = true)
    List<Blog> homepageBlogs();
}
