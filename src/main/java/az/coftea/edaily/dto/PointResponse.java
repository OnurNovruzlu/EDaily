package az.coftea.edaily.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PointResponse {
    private int point;
    private String status;
    private Date createdAt;
    private String teacherName;
    private String subjectName;
    private int dailyId;
}
