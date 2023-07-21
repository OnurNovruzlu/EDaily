package az.coftea.edaily.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "school")
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "name cannot be null")
    @Size(max = 50,message = "name field cannot exceed 50 characters")
    private String name;

    @Size(max = 150,message = "location field cannot exceed 150 characters")
    private String location;

    private String description;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "status cannot be null")
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "school")
    private List<Room> rooms;

    @OneToMany(mappedBy = "school")
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "school")
    private List<Student> students;

    @OneToMany(mappedBy = "school")
    private List<Subject> subjects;

}
