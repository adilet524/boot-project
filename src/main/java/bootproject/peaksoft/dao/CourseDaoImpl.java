package bootproject.peaksoft.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import bootproject.peaksoft.entities.Company;
import bootproject.peaksoft.entities.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class    CourseDaoImpl implements CourseDao{
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = manager.createQuery("select c from Course c", Course.class).getResultList();
        return courses;
    }

    @Override
    public void addCourse(Long id,Course course) {
        Company company=manager.find(Company.class,id);
        company.addCourse(course);
        course.setCompany(company);
        manager.merge(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return manager.find(Course.class, id);
    }

    @Override
    public void updateCourse(Course course, Long id) {
        Course course1 = manager.find(Course.class,id);
        course1.setCourseName(course.getCourseName());
        course1.setDurationMonth(course.getDurationMonth());
        manager.merge(course1);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course=manager.find(Course.class,id);
        if (course!=null){
            course.setInstructors(null);
            manager.remove(manager.find(Course.class,id));
        }
        manager.remove(course);

    }
}
