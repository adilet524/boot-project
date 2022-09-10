package bootproject.peaksoft.service;

import bootproject.peaksoft.dao.InstructorDao;
import bootproject.peaksoft.entities.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService{

    private final InstructorDao instructorDao;

    @Autowired
    public InstructorServiceImpl(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    @Override
    public List<Instructor> getAllInstructors(Long courseId) {
        return instructorDao.getAllInstructor(courseId);
    }

    @Override
    public void addInstructor(Instructor instructor, Long id) {
        instructorDao.addInstructor(id, instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
       return instructorDao.getInstructorById(id);
    }

    @Override
    public void updateInstructor(Instructor instructor, Long id) {
        instructorDao.updateInstructor(instructor, id);
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorDao.deleteInstructor(id);
    }
    @Override
    public void assignInstructor(Long courseId, Long instructorId) {
        instructorDao.assignInstructor(courseId, instructorId);
    }
}
