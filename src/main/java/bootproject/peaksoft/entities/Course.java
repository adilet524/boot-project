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
@Table(name = "courses")
@Getter @Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(generator = "course_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_gen",
                       sequenceName = "course_seq",
                       allocationSize = 1)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "duration_month")
    private String durationMonth;

    @ManyToOne
    private Company company;

    @ManyToMany(cascade = {MERGE,DETACH,REFRESH,PERSIST},fetch = LAZY, mappedBy = "courses")
    private List<Instructor> instructors;

    public void addInstructor(Instructor instructor){
        if (instructors==null){
            instructors=new ArrayList<>();
        }
        instructors.add(instructor);
    }

    @OneToMany(cascade = {MERGE,DETACH,PERSIST,REFRESH})
    private List<Student> students;

    public void addStudents(Student student){
        if (students==null){
            students=new ArrayList<>();
        }
        students.add(student);
    }

    @OneToMany(cascade = {MERGE, REFRESH, REMOVE, DETACH}, fetch = LAZY, mappedBy = "course")
    private List<Lesson> lessons;

    public void addLessons(Lesson lesson){
        if (lessons==null){
            lessons=new ArrayList<>();
        }
        lessons.add(lesson);
    }

    public Course(String courseName, String durationMonth) {
        this.courseName = courseName;
        this.durationMonth = durationMonth;
    }
}
