package art.jeanyvehector.dto;

import art.jeanyvehector.security.user.MyUser;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {


    private MyCurrentUserImpl reviewer;

    private String headline;
    private String reviewText;

    private long productId;
    private int rating;
    private Date date;
    private byte[] imageData;
    private String imageName;
}
