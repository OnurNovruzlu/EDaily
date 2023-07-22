package az.coftea.edaily.dto;

import az.coftea.edaily.model.Role;
import az.coftea.edaily.model.School;
import az.coftea.edaily.model.Status;
import az.coftea.edaily.model.Subject;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
public class TeacherResponse {

    private int id;

    private String name;

    private String surname;

    private Date birthday;

    private int schoolId;

    private Date createdAt;

    private String statusName;

    private String roleName;

    private String subjectName;


}
