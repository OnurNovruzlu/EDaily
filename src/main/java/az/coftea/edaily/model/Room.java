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
@Table(name = "room")
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "number cannot be null")
    @Size(max = 20,message = "number field cannot exceed 20 characters")
    private String number;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "status cannot be null")
    private Status status = Status.ACTIVE;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

}
