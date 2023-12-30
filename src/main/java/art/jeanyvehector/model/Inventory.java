package art.jeanyvehector.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence_generator")
//    @SequenceGenerator(name = "my_sequence_generator", sequenceName = "my_sequence", initialValue = 0, allocationSize = 1)
    @Id
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    private MyProduct myProduct;
    private String category;
    private int quantity;
    @ElementCollection
    List<String>  metadata = new ArrayList<>();
}
