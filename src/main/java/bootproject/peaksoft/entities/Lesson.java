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
@Table(name = "lessons")
@NoArgsConstructor
@Getter @Setter
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "lesson_gen",
                    sequenceName = "lesson_seq",
                    allocationSize = 1)
    private Long id;
    private String lessonName;

    @ManyToOne
    private Course course;

    @OneToMany(cascade = {MERGE,REFRESH,REMOVE,DETACH}, fetch = LAZY, mappedBy = "lesson")
    private List<Task> tasks;

    public void addTask(Task task){
        if (tasks==null){
            tasks=new ArrayList<>();
        }
        tasks.add(task);
    }

    @OneToOne(cascade = {MERGE,REFRESH,REMOVE,DETACH}, fetch = LAZY, mappedBy = "lesson")
    private Video video;

    public Lesson(String lessonName) {
        this.lessonName = lessonName;
    }
}
