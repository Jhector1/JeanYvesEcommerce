package art.jeanyvehector.model;

import lombok.Data;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class MyReview implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    @JoinColumn(name = "my_customer_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private MyCustomer myCustomer;
    private String headline;
    @Column(length = 10000)

    private String reviewText;
    @OneToOne
    private MyProduct product;
    private int rating;
    private Date date = new Date();
    @Lob
    private byte[] imageData;
    private String imageName;
}
