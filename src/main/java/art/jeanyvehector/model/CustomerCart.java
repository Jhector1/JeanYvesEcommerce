package art.jeanyvehector.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
//@DiscriminatorValue("customerCart")
//@Data
public class CustomerCart extends CustomerData<CustomerCartHelper> {
  //  @ElementCollection
  //  private List<Integer> quantities;
    public CustomerCart(MyCustomer myCustomer, List<CustomerCartHelper> customerDataHelpers){
       super(myCustomer, customerDataHelpers);
      // this.quantities = quantities;
    }

}


