package com.example.guppy.repository;

import com.example.guppy.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Modifying
    @Transactional
    @Procedure(procedureName = "insertImages", outputParameterName = "out_value")
    int insertImages(@Param("vMax") int vMax, @Param("names") String names, @Param("urls") String urls, @Param("_describes") String _describes);

    @Query(value = "SELECT id, name, url, _describe FROM images", nativeQuery = true)
    List<Image> selectAllImage();

    @Query(value = "SELECT id, name, url, _describe FROM images WHERE id = :id", nativeQuery = true)
    Image selectImageById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE images SET name = :name, url = :url, _describe = :_describe WHERE id = :id", nativeQuery = true)
    int updateImage(@Param("name") String name, @Param("url") String url, @Param("_describe") String _describe, @Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM images WHERE id = :id", nativeQuery = true)
    int deleteImageById(@Param("id") int id);

}
