package com.example.guppy.service;

import com.example.guppy.entity.Image;
import com.example.guppy.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;

    public String welcomeImage() {
        return "welcome images";
    }

    public int insertImages(int vMax, String names, String urls, String _describes) {
        return imageRepository.insertImages(vMax, names, urls, _describes);
    }

    public Image selectImageById(int id) {
        return imageRepository.selectImageById(id);
    }

    public List<Image> selectAllImages() {
        return imageRepository.selectAllImage();
    }

    public int deleteImageById(int id) {
        return imageRepository.deleteImageById(id);
    }

    public int updateImage(Image image) {
        return imageRepository.updateImage(image.getName(), image.getUrl(), image.get_describe(), image.getId());
    }
}
