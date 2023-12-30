//package art.jeanyvehector.adapter;
//
//import art.jeanyvehector.model.MyOrder;
//import art.jeanyvehector.model.MyProduct;
//import com.google.gson.TypeAdapter;
//import com.google.gson.stream.JsonReader;
//import com.google.gson.stream.JsonWriter;
//
//import java.io.IOException;
//
//public class MyProductAdapter extends TypeAdapter<MyProduct> {
//    @Override
//    public void write(JsonWriter out, MyProduct myProduct) throws IOException {
//        out.beginObject();
//        out.name("id").value(myProduct.getId());
//
//        // Serialize other Author fields
//        // Avoid serializing the 'books' field here
//        out.endObject();
//    }
//
//
//    @Override
//    public MyProduct read(JsonReader in) throws IOException {
//        // Implement deserialization if needed
//        return null;
//    }
//}
