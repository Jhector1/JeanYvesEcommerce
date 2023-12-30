package art.jeanyvehector;

import art.jeanyvehector.model.Artwork;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;

import java.util.Date;

public interface CartAndFavoriteResource extends MyResource{
     String getUserId();
     Date getDate();
     Artwork getArtwork();
}
