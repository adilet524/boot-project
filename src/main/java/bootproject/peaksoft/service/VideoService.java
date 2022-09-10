package bootproject.peaksoft.service;

import bootproject.peaksoft.entities.Video;

import java.util.List;

public interface VideoService {
    List<Video> getAllVideo();
    void addVideo(Long id, Video video);
    Video getVideoById(Long id);
    void updateVideo(Video video, Long id);
    void deleteVideo(Long id);
}
