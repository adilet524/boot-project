package bootproject.peaksoft.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import bootproject.peaksoft.entities.Company;
import bootproject.peaksoft.entities.Course;
import bootproject.peaksoft.entities.Instructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class InstructorDaoImpl implements InstructorDao{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Instructor> getAllInstructor(Long courseId) {
        List<Instructor> instructors = manager.createQuery("select i from Instructor i", Instructor.class).getResultList();
        return instructors;
    }

    @Override
    public void addInstructor(Long id, Instructor instructor) {
        Company company = manager.find(Company.class, id);
        company.addInstructor(instructor);
        instructor.setCompany(company);
        manager.merge(company);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return manager.find(Instructor.class, id);
    }

    @Override
    public void updateInstructor(Instructor instructor, Long id) {
        Instructor instructor1 = manager.find(Instructor.class, id);
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setEmail(instructor.getEmail());
        manager.merge(instructor1);
    }

    @Override
    public void deleteInstructor(Long id) {
        manager.remove(manager.find(Instructor.class, id));
    }

    @Override
    public void assignInstructor(Long courseId, Long instructorId) {
        Instructor instructor = manager.find(Instructor.class, instructorId);
        Course course = manager.find(Course.class, courseId);
        instructor.addCourse(course);
        course.addInstructor(instructor);
        manager.merge(instructor);
        manager.merge(course);
    }
}
