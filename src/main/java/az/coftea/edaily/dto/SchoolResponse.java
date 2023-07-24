package az.coftea.edaily.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolResponse {
    private int id;
    private String name;
    private String location;
    private String description;
    private String status;
    private Date createdAt;
    private TeacherResponse director;
    private List<String> teacherNames;
    private List<String> studentNames;
    private List<String> subjectNames;
}