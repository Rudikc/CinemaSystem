package ua.rudikc.cinema.controller.actions.profile;

import ua.rudikc.cinema.controller.actions.Action;
import ua.rudikc.cinema.dto.OrderDto;
import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.entity.UserRole;
import ua.rudikc.cinema.factory.CommandFactory;
import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetUserProfileAction implements Action {
    /**
     * Action to get info for user profile.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        OrderService orderService = (OrderService) ServiceFactory.getService("orderService");
        User user = (User) request.getSession().getAttribute("user");
        List<OrderDto> orders = orderService.getUserOrders(user);

        request.setAttribute("orders",orders);
        if(user.getRole().equals(UserRole.USER)) {
            return "user-profile";
        }
        else if(user.getRole().equals(UserRole.ADMIN)){
            return "admin-profile";
        }else {
            return CommandFactory.defineCommand("/").execute(request,response);
        }


    }
}
