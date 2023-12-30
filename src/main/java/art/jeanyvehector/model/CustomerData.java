package art.jeanyvehector.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Entity
@MappedSuperclass
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Setter
@Getter
@NoArgsConstructor
//@DiscriminatorColumn(name="customerData",
        //discriminatorType = DiscriminatorType.STRING)
@AllArgsConstructor
public abstract class CustomerData<H> implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Expose
    private long id;
    @OneToMany
    private List<H> customerDataHelpers = new ArrayList<>();

    @OneToOne(cascade = {CascadeType.PERSIST})

   // @JsonManagedReference

    @JoinColumn(name = "my_customer_id")
    private MyCustomer myCustomer;
    @Expose
    private Date date = new Date();
    public CustomerData(MyCustomer myCustomer, List<H> customerDataHelpers){
        this.myCustomer = myCustomer;
        this.customerDataHelpers = customerDataHelpers;
    }


}
