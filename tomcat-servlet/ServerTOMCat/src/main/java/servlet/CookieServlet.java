package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    private static final String COUNT = "count";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie fromClient = null;
        Cookie[] cok = req.getCookies();
        if (cok != null) {
            for (Cookie c : cok) {
                if (COUNT.equals(c.getName())) {
                    fromClient = c;
                    break;
                }
            }
        }
        if (fromClient == null) {
            resp.addCookie(new Cookie(COUNT, "" + 1));
            resp.getWriter().write("You visit this page: 1 time!");
        }
        else {
            int count = Integer.valueOf(fromClient.getValue());
            resp.addCookie(new Cookie(COUNT, "" + (count+1)));
            resp.getWriter().write("You visit this page: " + count + " time!");
        }

    }
}
