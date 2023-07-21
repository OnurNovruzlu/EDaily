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
    private Date createdAt;
    private TeacherResponse director;
    private List<String> teacherNames;
    private List<String> studentNames;

    public SchoolResponse(int id, String name, String location, String description, Date createdAt, TeacherResponse director) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.createdAt = createdAt;
        this.director = director;
    }
}
