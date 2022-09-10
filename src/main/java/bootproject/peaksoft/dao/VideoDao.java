package bootproject.peaksoft.dao;

import bootproject.peaksoft.entities.Video;

import java.util.List;

public interface VideoDao {
    List<Video> getAllVideo();
    void addVideo(Long id, Video video);
    Video getVideoById(Long id);
    void updateVideo(Video video, Long id);
    void deleteVideo(Long id);
}
