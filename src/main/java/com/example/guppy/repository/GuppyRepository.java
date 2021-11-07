package com.example.guppy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.guppy.entity.Guppy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.StoredProcedureParameter;
import java.util.List;

@Repository
public interface GuppyRepository extends JpaRepository<Guppy, Integer> {
    //query insert a new guppy
    @Modifying
    @Transactional
    @Procedure(procedureName = "insertGuppy", outputParameterName = "out_value")
    int insertGuppy(int vMax, String names, String images, String prices, String _describes);
//    @Query(value = "INSERT INTO guppy (name, image, price, sale, status, _describe) VALUES (:name, :image, :price, :sale, :status, :_describe)", nativeQuery = true)
//    int insertGuppy(@Param("name") String name, @Param("image") String image, @Param("price") float price, @Param("sale") float sale, @Param("status") boolean status, @Param("_describe") String _describe);

    //query select all guppy
    @Modifying
    @Transactional
    @Query(value = "SELECT id, name, image, price, sale, status, _describe FROM guppy", nativeQuery = true)
    List<Guppy> selectAllGuppy();

    //query select 1 guppy by id
    @Query(value = "SELECT * FROM guppy WHERE id = :id", nativeQuery = true)
    Guppy selectGuppyById(@Param("id") int id);

    //query delete a guppy by id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM guppy WHERE id = :id", nativeQuery = true)
    int deleteGuppyById(@Param("id") int id);

    //query update guppy
    @Modifying
    @Transactional
    @Query(value = "UPDATE guppy SET name = :name, image = :image, price = :price, sale = :sale, status = :status, _describe = :_describe WHERE id = :id", nativeQuery = true)
    int updateGuppy(@Param("name") String name, @Param("image") String image, @Param("price") float price, @Param("sale") float sale, @Param("status") boolean status,@Param("_describe") String _describe, @Param("id") int id);

    //query insert new guppy detail
    @Modifying
    @Transactional
    @Procedure(procedureName = "insertGuppyDetail", outputParameterName = "out_value")
//    @Query(value = "CALL insertGuppyDetail(:v_max, :list_of_guppy, :list_of_images, :list_of_videos, :variable)", nativeQuery = true)
    int insertGuppyDetail(@Param("v_max") int v_max, @Param("list_of_guppy") String listOfGuppy, @Param("list_of_images") String listOfImages, @Param("list_of_videos") String listOfVideos);

    //query select homepage host sale
    @Modifying
    @Transactional
    @Query(value = "SELECT id, name, image, price, sale, status, _describe FROM guppy ORDER BY sale DESC LIMIT 1,6", nativeQuery = true)
    List<Guppy> homepageHotSale();
    //query select homepage hot guppy
    @Modifying
    @Transactional
    @Query(value = "SELECT id, name, image, price, sale, status, _describe FROM guppy ORDER BY add_date DESC LIMIT 1,6",  nativeQuery = true)
    List<Guppy> homepageHotGuppy();

    //admin
    //query get all guppy filter by name
    @Transactional
    @Query(value = "SELECT id, name, image, price, sale, status, _describe FROM guppy  WHERE name LIKE %:name%",  nativeQuery = true)
    List<Guppy> adminGetAllGuppy(@Param("name") String name);

    //query select guppy detail
   @Query(value = "SELECT id_image FROM guppy_detail WHERE id_guppy = :id", nativeQuery = true)
    List<Integer> getGuppyDetailImages(@Param("id") int id);
    @Query(value = "SELECT id_video FROM guppy_detail WHERE id_guppy = :id", nativeQuery = true)
    List<Integer> getGuppyDetailVideos(@Param("id") int id);
    @Query(value = "Select quantity from guppy_quantity WHERE id_guppy = :id", nativeQuery = true)
    int getQuantityGuppy(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE guppy_quantity SET quantity = :quantity WHERE id_guppy = :id", nativeQuery = true)
    int updateQuantity(@Param("quantity") int quantity, @Param("id") int id);

}
