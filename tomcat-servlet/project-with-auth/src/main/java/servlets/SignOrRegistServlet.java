package servlets;

import dao.DaoMock;
import dao.Profile;
import servlets.exception.ArgumentIsNoCorrectException;
import servlets.exception.ArgumentIsNullException;
import servlets.methodForCorrectArgument.MethodCorrectArgument;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign")
public class SignOrRegistServlet extends HttpServlet {
    private DaoMock daoMock = DaoMock.getInstance();

    public static final String PAGE_NALOG = "/WEB-INF/page/nalog.jsp";
    public static final String PAGE_AGAINREG = "/WEB-INF/page/regAgain.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        String reg = req.getParameter("reg");

        try {
            MethodCorrectArgument.isCorrectForLogic(login, pass);
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher(PAGE_AGAINREG).forward(req, resp);
            return;
        }

        try {
            MethodCorrectArgument.isCorrectForDao(login);
        } catch (ArgumentIsNoCorrectException e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher(PAGE_AGAINREG).forward(req, resp);
            return;
        }

        if (reg.toLowerCase().equals("signup")) {

            Profile profile = new Profile(login, pass);

            daoMock.addNewProfile(profile);
            daoMock.addOnlineSession(req.getSession().getId(), login);

            req.getRequestDispatcher(PAGE_NALOG).forward(req, resp);
            resp.setStatus(HttpServletResponse.SC_OK);

            return;
        }

        if (reg.toLowerCase().equals("signin")) {

            daoMock.addOnlineSession(req.getSession().getId(), login);

            req.getRequestDispatcher(PAGE_NALOG).forward(req, resp);
            resp.setStatus(HttpServletResponse.SC_OK);

            return;
        }

        req.getSession().setAttribute("message", "Неверно указан параметр: вход-signin или регистрация-signup. Параметр: " + reg);
        req.getRequestDispatcher(PAGE_AGAINREG).forward(req, resp);

    }
}
