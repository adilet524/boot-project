package bootproject.peaksoft.controllers;

import bootproject.peaksoft.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import bootproject.peaksoft.entities.Course;
import bootproject.peaksoft.service.CourseService;
import bootproject.peaksoft.service.StudentService;

@Controller
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;

    @Autowired
    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping("/students/{companyId}")
    public String getAllStudents(@PathVariable Long companyId, Model model,
                                 @ModelAttribute("course") Course course){
        model.addAttribute("students", studentService.getAllStudents(companyId));
        model.addAttribute("companyId", companyId);
        model.addAttribute("courseId", courseService.getAllCourses(companyId));
        return "/student/students";
    }

    @PostMapping("/{courseId}/{companyId}/assignStu")
    public String assignStudent(@PathVariable("courseId") Long courseId,
                                @PathVariable("companyId") Long companyId,
                                @ModelAttribute("student") Student student){
        studentService.assignStudent(courseId, student.getId());
        return "redirect:/courses/" + companyId;
    }

    @GetMapping("/student/{id}")
    public String getStudentById(@PathVariable("id") Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "student/students";
    }

    @GetMapping("/{companyId}/addStudent")
    public String addStudent(@PathVariable("companyId") Long companyId, Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("companyId", companyId);
        return "student/addStudent";
    }

    @PostMapping("/{companyId}/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student,
                              @PathVariable("companyId") Long companyId){
        studentService.addStudent(companyId, student);
        return "redirect:/students/" + companyId;
    }

    @GetMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("companyId", student.getCompany().getId());
        return "student/updateStudent";
    }

    @GetMapping("/{companyId}/{id}/updateStudent")
    public String saveUpdateStudent(@PathVariable("companyId") Long companyId,
                                    @PathVariable("id") Long id,
                                    @ModelAttribute("student") Student student) {
        studentService.updateStudent(student, id);
        return "redirect:/students/" + companyId;
    }

    @GetMapping("/{companyId}/{id}/deleteStudent")
    public String deleteStudent(@PathVariable("id") Long id,
                                @PathVariable("companyId") Long companyId){
        studentService.deleteStudent(id);
        return "redirect:/students/" + companyId;
    }
}
