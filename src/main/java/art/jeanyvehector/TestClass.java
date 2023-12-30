package art.jeanyvehector;

import art.jeanyvehector.adapter.CustomerDataTypeAdapter;
import art.jeanyvehector.adapter.PersonTypeAdapter;
import art.jeanyvehector.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) {
//        Gson gson = new Gson();
//        //Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); // Or use new GsonBuilder().create();
//        Person target = new Person("Paul", "904443333", new Artwork(), new ArrayList<>());
//        String json = gson.toJson(target); // serializes target to JSON
//        Person target2 = gson.fromJson(json, Person.class); // deserializes json into target2
//        System.out.println(json);
//        System.out.println(target2);
//
//        MyPerson person1 = new MyPerson("Alice");
//        MyPerson person2 = new MyPerson("Bob");
//
//        person1.setFriend(person2);
//        person2.setFriend(person1);
//
//        Gson mygson = new Gson();
//        String myjson = mygson.toJson(person1);
//
//        System.out.println(myjson);
//        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(CustomerFavorite.class, new CustomerDataTypeAdapter<CustomerFavorite, CustomerFavoriteHelper>())
//                .registerTypeAdapter(CustomerCart.class, new CustomerDataTypeAdapter<CustomerCart, CustomerCartHelper>())
////                .registerTypeAdapter(MyOrder.class, new MyOrderAdapter())
//                .registerTypeAdapter(Person.class, new PersonTypeAdapter())
//                .create();
//        Person obj = new Person("Paul", "904443333", new Artwork(), new ArrayList<>());
//
//        //Person obj = new Person();
//    String json = gson.toJson(obj);
//    Person target2 = gson.fromJson(json, Person.class); // deserializes json into target2
//        System.out.println(json                                     );
//
//        System.out.println(target2);
    }


}


class MyPerson {
    private String name;
    private transient MyPerson friend;

    public MyPerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public MyPerson getFriend() {
        return friend;
    }

    public void setFriend(MyPerson friend) {
        this.friend = friend;
    }
}

