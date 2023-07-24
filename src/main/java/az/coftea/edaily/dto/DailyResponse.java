package az.coftea.edaily.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class DailyResponse {
    private int id;
    private Date createdAt;
    private String status;
    private StudentResponse student;
    private List<Integer> points;
}
