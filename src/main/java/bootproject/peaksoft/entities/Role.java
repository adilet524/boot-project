package bootproject.peaksoft.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "role_gen",
            sequenceName = "role_seq",
            allocationSize = 1)
    private Long id;
    private String name;
}
