package art.jeanyvehector.helper;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Helper {
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            // Iterate through the cookies
            for (Cookie cookie : cookies) {
                if (cookie.getName().trim().equals(cookieName)) {
                    // Found the desired cookie
                    return cookie.getValue();
                }
            }
        }

        // Cookie not found
        return null;
    }
    public static void setCookieValue(String cookiename, String cookievalue,HttpServletResponse response) {
        // Create a cookie
        Cookie cookie = new Cookie(cookiename, cookievalue);

        // Optional: Set additional attributes for the cookie
        // cookie.setMaxAge(3600); // Set the cookie's maximum age in seconds (1 hour in this example)
        cookie.setPath("/"); // Set the path for which the cookie is valid (root path in this example)

        // Add the cookie to the response
        response.addCookie(cookie);


        // Other response logic, if needed
    }
}
