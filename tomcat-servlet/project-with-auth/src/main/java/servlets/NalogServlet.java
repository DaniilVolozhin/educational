package servlets;

import servlets.methodForCorrectArgument.MethodCorrectArgument;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/nalog")
public class NalogServlet extends HttpServlet {
    public static final String PAGE_RESULT = "/WEB-INF/page/resultNalog.jsp";
    public static final String PAGE_AGAIN = "/WEB-INF/page/nalog.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sum = req.getParameter("sum");
        Long resultSum = null;

        try {
            resultSum = MethodCorrectArgument.parsingSum(sum);
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher(PAGE_AGAIN).forward(req, resp);
            return;
        }

        req.setAttribute("resultSum", (int)(resultSum*0.87));
        req.getRequestDispatcher(PAGE_RESULT).forward(req, resp);
    }
}
