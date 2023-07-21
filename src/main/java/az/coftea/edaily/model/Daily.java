package az.coftea.edaily.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Daily {
    @Enumerated(EnumType.STRING)
    @NotNull(message = "status cannot be null")
    private Status status;
}
