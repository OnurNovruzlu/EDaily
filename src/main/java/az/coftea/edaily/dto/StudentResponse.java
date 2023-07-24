package az.coftea.edaily.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class StudentResponse {

    private int id;
    private String name;
    private String surname;
    private Date birthday;
    private String schoolName;
    private Date createdAt;
    private String status;
    private int dailyId;
    private String role;
    private String email;
    private String password;

}
