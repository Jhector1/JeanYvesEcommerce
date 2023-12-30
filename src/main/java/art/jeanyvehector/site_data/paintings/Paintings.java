package art.jeanyvehector.site_data.paintings;


import art.jeanyvehector.model.MyProduct;

import java.util.ArrayList;
import java.util.List;

public class Paintings {
    List<MyProduct> allMyProducts = new ArrayList<>();
  public List<MyProduct> getSeries(Serie serie) {

      return serie.getArtworkList();
    }

}
