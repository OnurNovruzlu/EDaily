package az.coftea.edaily.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class NewStudent {

    private String name;

    private String surname;

    private Date birthday;

    private int schoolId;

    private String role;

    private String email;

    private String password;


}
