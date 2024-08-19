package servlet;

import dao.Product;
import dao.ProductDao;
import dao.ProductDaoMock;
import exception.DaoSystemException;
import exception.NoSuchProductException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    public static final String PARAM_ID = "id";
    public static final String ATTRIBUTE_MODEL_TO_VIEW = "product";
    public static final String PAGE_OK = "/WEB-INF/jsp/product.jsp";
    public static final String PAGE_ERROR= "/WEB-INF/jsp/error.jsp";

    private ProductDao productDao = new ProductDaoMock();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(productDao == null);
        String str = req.getParameter(PARAM_ID);
        if (str != null) {
        try {
                Integer id = Integer.valueOf(str);
                Product model = productDao.selectById(id);
                req.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);
                req.getRequestDispatcher(PAGE_OK).forward(req, resp);
            } catch (NoSuchProductException | DaoSystemException e) {
            req.getRequestDispatcher(PAGE_ERROR).forward(req, resp);
        }
        } else {
            req.getRequestDispatcher(PAGE_ERROR).forward(req, resp);
        }
    }
}























