package bootproject.peaksoft.service;

import bootproject.peaksoft.dao.VideoDao;
import bootproject.peaksoft.entities.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService{

    private final VideoDao videoDao;

    @Autowired
    public VideoServiceImpl(VideoDao videoDao) {
        this.videoDao = videoDao;
    }


    @Override
    public List<Video> getAllVideo() {
        return videoDao.getAllVideo();
    }

    @Override
    public void addVideo(Long id, Video video) {
        videoDao.addVideo(id, video);
    }

    @Override
    public Video getVideoById(Long id) {
        return videoDao.getVideoById(id);
    }

    @Override
    public void updateVideo(Video video, Long id) {
        videoDao.updateVideo(video, id);
    }

    @Override
    public void deleteVideo(Long id) {
        videoDao.deleteVideo(id);
    }
}
