package app.servlets;

import app.entities.Product;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //PrintWriter writer = resp.getWriter();
        //writer.println("Method GET from MenuServlet, req: " );

        //req.setAttribute("menuChose", req.getParameter("menu"));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/menu.jsp");
        requestDispatcher.forward(req, resp);

    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        int price = Integer.parseInt(req.getParameter("price"));
//        Product product = new Product(name, price);
//        Model model = Model.getInstance();
//        model.add(product);
//
//        req.setAttribute("productName", name);
//        doGet(req, resp);
//    }


}
