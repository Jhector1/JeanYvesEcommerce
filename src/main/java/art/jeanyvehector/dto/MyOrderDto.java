package art.jeanyvehector.dto;

import art.jeanyvehector.model.MyCustomer;
import art.jeanyvehector.model.MyProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyOrderDto {
    private List<MyProduct> products = new ArrayList<>();
    private String  customerId;
}
