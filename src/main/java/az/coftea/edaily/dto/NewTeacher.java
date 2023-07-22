package az.coftea.edaily.dto;

import az.coftea.edaily.model.Role;
import az.coftea.edaily.model.School;
import az.coftea.edaily.model.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class NewTeacher {
    private String name;

    private String surname;

    private Date birthday;

    private int schoolId;

    private final String role;

    private String subject;
}
