package bootproject.peaksoft.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "companies")
@NoArgsConstructor
@Getter @Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "company_gen",
            sequenceName = "company_seq",
            allocationSize = 1)
    private Long id;
    private String companyName;
    private String locatedCountry;

    @OneToMany(cascade = {MERGE,REMOVE,REFRESH,DETACH}, fetch = LAZY, mappedBy = "company")
    private List<Student> students;

    public void addStudent(Student student1){
        if (students==null){
            students=new ArrayList<>();
        }
        students.add(student1);
    }

    @OneToMany(cascade = {MERGE, REMOVE, REFRESH, DETACH}, fetch = LAZY, mappedBy = "company")
    private List<Course> courses;
     public void addCourse(Course course1){
         if (courses==null){
             courses=new ArrayList<>();
         }
         courses.add(course1);
     }

     @OneToMany(cascade = {MERGE, REMOVE, REFRESH, DETACH}, fetch = LAZY, mappedBy = "company")
     private List<Instructor> instructors;

    public void addInstructor(Instructor instructor){
        if (instructors==null){
            instructors=new ArrayList<>();
        }
        instructors.add(instructor);
    }

    public Company(String companyName, String locatedCountry, List<Course> courses) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
        this.courses = courses;
    }
}
