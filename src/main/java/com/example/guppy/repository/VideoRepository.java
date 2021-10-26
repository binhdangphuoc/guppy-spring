package com.example.guppy.repository;

import com.example.guppy.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    @Modifying
    @Transactional
    @Procedure(procedureName = "insertVideos", outputParameterName = "out_value")
    int insertVideos(@Param("vMax") int vMax, @Param("names") String names, @Param("urls") String urls, @Param("_describes") String _describes);

    @Query(value = "SELECT id, name, url, _describe FROM videos", nativeQuery = true)
    List<Video> selectAllVideo();

    @Query(value = "SELECT id, name, url, _describe FROM videos WHERE id = :id", nativeQuery = true)
    Video selectVideoById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE videos SET name = :name, url = :url, _describe = :_describe WHERE id = :id", nativeQuery = true)
    int updateVideo(@Param("name") String name, @Param("url") String url, @Param("_describe") String _describe, @Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM videos WHERE id = :id", nativeQuery = true)
    int deleteVideoById(@Param("id") int id);

}
