package bootproject.peaksoft.dao;

import bootproject.peaksoft.entities.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getAllCourses();
    void addCourse(Long id,Course course);
    Course getCourseById(Long id);
    void updateCourse(Course course, Long id);
    void deleteCourse(Long id);
}
