package art.jeanyvehector.dto;

import art.jeanyvehector.model.Artwork;
import art.jeanyvehector.model.Checkout;
import lombok.Data;

@Data
public class ChargeRequest {

//    public enum Currency {
//        EUR, USD;
//    }
   private CreatePayment createPayment;
   private Checkout checkoutInfo;

}
