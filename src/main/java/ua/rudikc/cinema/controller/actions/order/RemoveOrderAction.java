package ua.rudikc.cinema.controller.actions.order;

import ua.rudikc.cinema.controller.actions.Action;
import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.factory.CommandFactory;
import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveOrderAction implements Action {


    /**
     * Action that removes the order.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        OrderService orderService = (OrderService) ServiceFactory.getService("orderService");
        User user = (User) request.getSession().getAttribute("user");
        int orderId = Integer.parseInt(request.getParameter("order-id"));
        orderService.removeOrder(user, orderId);

        return CommandFactory.defineCommand("/user-profile").execute(request, response);
    }
}
