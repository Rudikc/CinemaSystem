package ua.rudikc.cinema.servlet;

import ua.rudikc.cinema.controller.actions.Action;
import ua.rudikc.cinema.factory.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.rudikc.cinema.utils.Constants.JSP_PATH;


@WebServlet("/finalProject/*")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        Action action = CommandFactory.defineCommand(path);
        String resultPage = action.execute(req, resp);

        if (!resultPage.isEmpty()) {
            req.getRequestDispatcher(String.format(JSP_PATH, resultPage))
                    .forward(req, resp);
        }
//        if (req.getMethod().equals("POST")) {
//            resp.sendRedirect(resultPage);
//        } else if (req.getMethod().equals("GET")){
//            req.getRequestDispatcher(String.format(JSP_PATH,resultPage)).forward(req,resp);
//        }
    }
}
