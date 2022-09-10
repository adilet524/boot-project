package bootproject.peaksoft.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@NoArgsConstructor
@Getter @Setter
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "instructor_get",
                sequenceName = "instructor_seq",
                allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany
    private List<Course> courses;

    @ManyToOne
    private Company company;

    public void addCourse(Course course1){
        if (courses==null){
            courses=new ArrayList<>();
        }
        courses.add(course1);
    }

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}

