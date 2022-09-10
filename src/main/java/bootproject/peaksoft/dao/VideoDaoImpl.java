package bootproject.peaksoft.dao;

import bootproject.peaksoft.entities.Lesson;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import bootproject.peaksoft.entities.Video;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class VideoDaoImpl implements VideoDao{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Video> getAllVideo() {
        List<Video> videos = manager.createQuery("select v from Video v", Video.class).getResultList();
        return videos;
    }

    @Override
    public void addVideo(Long id, Video video) {
        Lesson lesson = manager.find(Lesson.class, id);
        if (lesson.getVideo() == null){
            lesson.setVideo(video);
            video.setLesson(lesson);
            manager.merge(lesson);
        }
    }

    @Override
    public Video getVideoById(Long id) {
        return manager.find(Video.class, id);
    }

    @Override
    public void updateVideo(Video video, Long id) {
        Video video1 = manager.find(Video.class, id);
        video1.setVideoName(video.getVideoName());
        video1.setLink(video.getLink());
        manager.merge(video1);
    }

    @Override
    public void deleteVideo(Long id) {
        manager.remove(manager.find(Video.class, id));
    }
}
