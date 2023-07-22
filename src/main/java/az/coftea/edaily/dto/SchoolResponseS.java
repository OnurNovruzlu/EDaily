package az.coftea.edaily.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
public class SchoolResponseS {
    private int id;
    private String name;
    private String location;
    private String description;
    private Date createdAt;
}