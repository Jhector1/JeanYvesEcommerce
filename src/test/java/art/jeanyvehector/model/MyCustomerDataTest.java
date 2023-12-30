package art.jeanyvehector.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCustomerDataTest {
    CustomerData<CustomerCartHelper>  c;

    @BeforeEach
    void setUp() {
        c = new CustomerCart();
    }

    @Test
    void getId() {
        long idValue = 4L;
        c.setId(idValue);
        assertEquals(idValue, c.getId());
    }

    @Test
    void getCustomerDataHelpers() {
    }

    @Test
    void getDate() {
    }
}