package az.coftea.edaily.dto;

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

    private int subjectId;
}
