//package art.jeanyvehector.controller;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.ui.Model;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.anySet;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//class CartControllerTest {
//    @Mock
//    Model model;
//    CartController cartController;
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        cartController = new CartController();
//    }
//
//    @Test
//    void getCartPage() {
//        String viewName = cartController.getCartPage(model);
//        assertEquals("cart_page", viewName);
//        verify(model, times(1)).addAttribute(eq("userCartEndpoint"), anySet());
//    }
//    @Test
//    void testCookie(){
//
//    }
//}