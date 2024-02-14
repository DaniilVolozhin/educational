package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    private static final String COUNT = "count";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        AtomicInteger count = (AtomicInteger) session.getAttribute(COUNT);
        if (count == null) {
            count = new AtomicInteger(1);
            session.setAttribute(COUNT, count);
        }
        int num = count.getAndIncrement();
        resp.getWriter().write("You come in: " + num + " time!");

    }
}
