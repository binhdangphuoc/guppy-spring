package com.example.guppy.service;

import com.example.guppy.entity.Guppy;
import com.example.guppy.entity.GuppyDetail;
import com.example.guppy.entity.Image;
import com.example.guppy.entity.Video;
import com.example.guppy.helper.Helper;
import com.example.guppy.repository.GuppyRepository;
import com.example.guppy.repository.ImageRepository;
import com.example.guppy.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuppyService {
    @Autowired
    GuppyRepository guppyRepository;

    @Autowired
    ImageRepository imageRepository;
    @Autowired
    VideoRepository videoRepository;

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

    //get guppy detail
    public GuppyDetail getGuppyDetail(int id) {
        List<Integer> listIdImages = guppyRepository.getGuppyDetailImages(id);
        List<Integer> listIdVideos = guppyRepository.getGuppyDetailVideos(id);

        String idImages = Helper.IntToString(listIdImages);
        String idVideos = Helper.IntToString(listIdVideos);

        GuppyDetail guppyDetail = new GuppyDetail();
        guppyDetail.setGuppy(guppyRepository.selectGuppyById(id));
        List<Image> images = new ArrayList<>();
        List<Video> videos = new ArrayList<>();
        int quantity = guppyRepository.getQuantityGuppy(id);
        listIdImages.forEach(idImg -> {
            Image image = imageRepository.selectImageById(idImg);
            images.add(image);
        });
        listIdVideos.forEach(idV -> {
            Video video = videoRepository.selectVideoById(idV);
            videos.add(video);
        });

        guppyDetail.setQuantity(quantity);
        guppyDetail.setImages(images);
        guppyDetail.setVideos(videos);

        return guppyDetail;

    }

    public int updateQuantity(int quantity, int id) {
        return guppyRepository.updateQuantity(quantity, id);

    }
}
