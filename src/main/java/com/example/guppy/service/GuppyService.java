package com.example.guppy.service;

import com.example.guppy.entity.Guppy;
import com.example.guppy.repository.GuppyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuppyService {
    @Autowired
    GuppyRepository guppyRepository;

    // insert new guppy to DB
    public int insertGuppy(int vMax, String names, String images, String prices, String _describes) {
        return guppyRepository.insertGuppy(vMax, names, images, prices, _describes);
    }

    // select all guppy from DB
    public List<Guppy> selectAllGuppy() {
        return guppyRepository.selectAllGuppy();
    }

    // select a guppy by id
    public Guppy selectGuppyById(int id) {
        return guppyRepository.selectGuppyById(id);
    }

    // delete guppy by id
    public int deleteGuppyById(int id) {
        return guppyRepository.deleteGuppyById(id);
    }

    // update guppy
    public int updateGuppy(Guppy guppyUpdate) {
        return guppyRepository.updateGuppy(guppyUpdate.getName(), guppyUpdate.getImage(), guppyUpdate.getPrice(), guppyUpdate.getSale(), guppyUpdate.getStatus(), guppyUpdate.get_describe(), guppyUpdate.getId());
    }

    // insert new guppy_detail
    public int insertGuppyDetail(int vMax, String listOfGuppy, String listOfImages, String listOfVideos) {
        return guppyRepository.insertGuppyDetail(vMax, listOfGuppy, listOfImages, listOfVideos);
    }

    //home page
    public List<Guppy> homepageHotSale() {
        return guppyRepository.homepageHotSale();
    }
    public List<Guppy> homepageHotGuppy() {
        return guppyRepository.homepageHotGuppy();
    }

    //admin
    public List<Guppy> adminGetAllGuppy(String name) {
        System.out.println(name);
        return guppyRepository.adminGetAllGuppy(name);
    }
}
