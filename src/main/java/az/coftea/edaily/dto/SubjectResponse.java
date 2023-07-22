package az.coftea.edaily.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectResponse {
    private int id;
    private String name;
    private Date createdAt;
    private String status;
    private String schoolName;
    private List<String> teacherNames;
}
