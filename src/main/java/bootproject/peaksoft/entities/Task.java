package bootproject.peaksoft.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Getter @Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "task_gen",
                    sequenceName = "task_seq",
                    allocationSize = 1)
    private Long id;
    private String taskName;
    private String deadline;

    @ManyToOne
    private Lesson lesson;

    public Task(String taskName, String deadline) {
        this.taskName = taskName;
        this.deadline = deadline;
    }
}
