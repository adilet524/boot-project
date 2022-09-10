package bootproject.peaksoft.dao;

import bootproject.peaksoft.entities.Lesson;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import bootproject.peaksoft.entities.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class LessonDaoImpl implements LessonDao{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Lesson> getAllLessons() {
      List<Lesson> lessons = manager.createQuery("select l from Lesson l", Lesson.class).getResultList();
      return lessons;
    }

    @Override
    public void addLesson(Long id, Lesson lesson) {
        Course course = manager.find(Course.class, id);
        course.addLessons(lesson);
        lesson.setCourse(course);
        manager.merge(lesson);
    }


    @Override
    public Lesson getLessonById(Long id) {
        return manager.find(Lesson.class, id);
    }

    @Override
    public void updateLesson(Lesson lesson, Long id) {
        Lesson lesson1 = manager.find(Lesson.class, id);
        lesson1.setLessonName(lesson.getLessonName());
        manager.merge(lesson1);
    }

    @Override
    public void deleteLesson(Long id) {
        manager.remove(manager.find(Lesson.class, id));
    }
}
