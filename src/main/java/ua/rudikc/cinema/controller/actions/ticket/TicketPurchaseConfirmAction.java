package ua.rudikc.cinema.controller.actions.ticket;

import ua.rudikc.cinema.controller.actions.Action;
import ua.rudikc.cinema.entity.Order;
import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.factory.CommandFactory;
import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TicketPurchaseConfirmAction implements Action {
    /**
     * Action that creates a new ticket in database.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        OrderService orderService = (OrderService) ServiceFactory.getService("orderService");

        User user = (User) request.getSession().getAttribute("user");
        int seanceId = Integer.parseInt(request.getParameter("seance-id"));
        int seatId = Integer.parseInt(request.getParameter("seat-id"));
        double ticketPrice = Double.parseDouble(request.getParameter("ticket-price"));

        Order order = Order.newBuilder()
                .setOrderTime()
                .setPrice(ticketPrice)
                .setUser(user.getId())
                .build();
        orderService.saveOrder(order,seanceId,seatId);

        return CommandFactory.defineCommand("/").execute(request,response);
    }
}
