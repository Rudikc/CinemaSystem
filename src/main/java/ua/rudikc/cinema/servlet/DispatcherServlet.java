package ua.rudikc.cinema.servlet;

import ua.rudikc.cinema.command.Command;
import ua.rudikc.cinema.factory.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.rudikc.cinema.utils.Constants.JSP_PATH;

public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response){

        String action = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')+1);
        Command command = CommandFactory.getCommand();
        String page = command.execute(request,response);

        if (!page.isEmpty()){
            try {
                request.getRequestDispatcher(String.format(JSP_PATH,page)).forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
