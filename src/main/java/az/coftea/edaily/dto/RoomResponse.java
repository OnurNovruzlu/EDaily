package az.coftea.edaily.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class RoomResponse {

    private int id;

    private String number;

    private Date createdAt;

    private String statusName;

    private String schoolName;
}
