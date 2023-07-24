package az.coftea.edaily.dto;

import az.coftea.edaily.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
public class NewStudent {

    private String name;

    private String surname;

    private Date birthday;

    private int schoolId;

    private int dailyId;

    private String role;

    private String email;

    private String password;


}
