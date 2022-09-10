package bootproject.peaksoft.service;

import bootproject.peaksoft.entities.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors(Long courseId);
    void addInstructor(Instructor instructor, Long id);
    Instructor getInstructorById(Long id);
    void updateInstructor(Instructor instructor, Long id);
    void deleteInstructor(Long id);
    void assignInstructor(Long courseId, Long instructorId);
}
