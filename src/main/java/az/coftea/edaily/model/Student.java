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
@Table(name = "student")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "name cannot be null")
    @Size(max = 30,message = "name cannot exceed 30 characters")
    private String name;

    @NotNull(message = "surname cannot be null")
    @Size(max = 30,message = "surname cannot exceed 30 characters")
    private String surname;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "status cannot be null")
    private Status status;

    @OneToOne(mappedBy = "student")
    private Daily daily;

}
