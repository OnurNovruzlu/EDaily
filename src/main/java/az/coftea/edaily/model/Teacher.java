package az.coftea.edaily.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "name cannot be null")
    @Size(max = 30,message = "name field cannot exceed 30 characters")
    private String name;

    @NotNull(message = "surname cannot be null")
    @Size(max = 30,message = "surname field cannot exceed 30 characters")
    private String surname;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "status cannot be null")
    private Status status = Status.ACTIVE;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "role cannot be null")
    private Role role = Role.TEACHER;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

}
