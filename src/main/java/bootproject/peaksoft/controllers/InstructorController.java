package bootproject.peaksoft.controllers;

import bootproject.peaksoft.entities.Instructor;
import bootproject.peaksoft.service.CourseService;
import bootproject.peaksoft.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InstructorController {
    private final InstructorService instructorService;
    private final CourseService courseService;

    @Autowired
    public InstructorController(InstructorService instructorService, CourseService courseService) {
        this.instructorService = instructorService;
        this.courseService = courseService;
    }


    @GetMapping("/instructors/{id}")
    public String getAllInstructors(@PathVariable Long id, Model model){
        model.addAttribute("instructors", instructorService.getAllInstructors(id));
        model.addAttribute("courseId", id);
        return "/instructor/instructors";
    }

    @PostMapping("/{courseId}/{companyId}/assignIns")
    public String assignInstructor(@PathVariable("courseId") Long courseId,
                                   @PathVariable("companyId") Long companyId,
                                   @ModelAttribute("instructor") Instructor instructor){
        instructorService.assignInstructor(courseId, instructor.getId());
        return "redirect:/instructors/" + companyId;
    }

    @GetMapping("/instructor/{id}")
    public String getInstructorById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("instructor", instructorService.getInstructorById(id));
        return "instructor/instructors";
    }

    @GetMapping("/instructors/{id}/addinstructor")
    public String addInstructor(@PathVariable Long id, Model model) {
        model.addAttribute("instructor", new Instructor());
        model.addAttribute("courseId", id);
        return "instructor/addinstructor";
    }

    @PostMapping("/{id}/saveinstructors")
    public String saveInstructor(@ModelAttribute("instructor") Instructor instructor, @PathVariable Long id) {
        instructorService.addInstructor(instructor, id);
        return "redirect:/instructors/" + id;
    }

    @GetMapping("/updateinstructor/{id}")
    public String updateInstructor(@PathVariable("id") Long id, Model model) {
        Instructor instructor = instructorService.getInstructorById(id);
        model.addAttribute("instructor", instructor);
        model.addAttribute("companyId", instructor.getCompany().getId());
        return "instructor/updateinstructor";
    }

    @GetMapping("/{companyId}/{id}/updateinstructor")
    public String saveUpdateInstructor(@PathVariable("companyId") Long companyId,
                                       @PathVariable("id") Long id,
                                       @ModelAttribute("instructor") Instructor instructor) {
        instructorService.updateInstructor(instructor, id);
        return "redirect:/instructors/" + companyId;
    }

    @GetMapping("/{courseId}/{id}/deleteinstructor")
    public String deleteInstructor(@PathVariable("id") Long id, @PathVariable("courseId") Long courseId){
        instructorService.deleteInstructor(id);
        return "redirect:/instructors/" + courseId;
    }
}
