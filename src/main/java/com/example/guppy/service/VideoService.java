package com.example.guppy.service;

import com.example.guppy.entity.Video;
import com.example.guppy.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    @Autowired
    VideoRepository videoRepository;

    public int insertVideos(int vMax, String names, String urls, String _describes) {
        return videoRepository.insertVideos(vMax, names, urls, _describes);
    }

    public Video selectVideoById(int id) {
        return videoRepository.selectVideoById(id);
    }

    public List<Video> selectAllVideos() {
        return videoRepository.selectAllVideo();
    }

    public int deleteVideoById(int id) {
        return videoRepository.deleteVideoById(id);
    }

    public int updateVideo(Video video) {
        return videoRepository.updateVideo(video.getName(), video.getUrl(), video.get_describe(), video.getId());
    }
}
