package az.coftea.edaily.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewPoint {
    private int point;
    private int teacherId;
    private int subjectId;
    private int dailyId;
}
