package bootproject.peaksoft.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "videos")
@NoArgsConstructor
@Getter @Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "video_gen",
                    sequenceName = "video_seq",
                    allocationSize = 1)
    private Long id;
    private String videoName;
    private String link;

    @OneToOne
    private Lesson lesson;

    public Video(String videoName, String link) {
        this.videoName = videoName;
        this.link = link;
    }
}
