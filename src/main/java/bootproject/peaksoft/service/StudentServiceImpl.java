package bootproject.peaksoft.service;

import bootproject.peaksoft.dao.StudentDao;
import bootproject.peaksoft.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents(Long courseId) {
        return studentDao.getAllStudents(courseId);
    }

    @Override
    public void addStudent(Long id, Student student) {
        studentDao.addStudent(id, student);
    }

    @Override
    public Student getStudentById(Long id) {
       return studentDao.getStudentById(id);
    }

    @Override
    public void updateStudent(Student student, Long id) {
        studentDao.updateStudent(student, id);
    }

    @Override
    public void deleteStudent(Long id) {
        studentDao.deleteStudent(id);
    }

    @Override
    public void assignStudent(Long courseId, Long studentId) {
        studentDao.assignStudent(courseId, studentId);
    }
}
