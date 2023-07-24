package az.coftea.edaily.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
public class TeacherResponse {

    private int id;

    private String name;

    private String surname;

    private Date birthday;

    private String schoolName;

    private Date createdAt;

    private String status;

    private String role;

    private String subjectName;
}
