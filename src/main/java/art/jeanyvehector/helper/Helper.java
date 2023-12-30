package art.jeanyvehector.helper;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

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
}
