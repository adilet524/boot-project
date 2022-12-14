package bootproject.peaksoft.service;

import bootproject.peaksoft.entities.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> getAllLessons();
    void addLesson(Long id, Lesson lesson);
    Lesson getLessonById(Long id);
    void updateLesson(Lesson lesson, Long id);
    void deleteLesson(Long id);
}
