package art.jeanyvehector;

import art.jeanyvehector.model.Artwork;
import com.google.gson.annotations.Expose;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Expose
    String name;
    @Expose
     String telephone;
     Artwork artwork;
     @Expose
    List<Integer> scores;
}
