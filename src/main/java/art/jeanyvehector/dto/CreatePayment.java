package art.jeanyvehector.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreatePayment {
    @NotNull
    private double amount;
    private String token;

}
