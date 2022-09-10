package bootproject.peaksoft.dao;

import bootproject.peaksoft.entities.Instructor;

import java.util.List;

public interface InstructorDao {
    List<Instructor> getAllInstructor(Long courseId);
    void addInstructor(Long id,Instructor instructor);
    Instructor getInstructorById(Long id);
    void updateInstructor(Instructor instructor, Long id);
    void deleteInstructor(Long id);
    void assignInstructor(Long courseId, Long instructorId);
}
