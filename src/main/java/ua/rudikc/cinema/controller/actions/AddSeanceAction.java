package ua.rudikc.cinema.controller.actions;

import ua.rudikc.cinema.entity.Seance;
import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.factory.CommandFactory;
import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.service.SeanceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddSeanceAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SeanceService seanceService = (SeanceService) ServiceFactory.getService("seanceService");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        User user = (User) request.getSession().getAttribute("user");

        try {
            Date start = simpleDateFormat.parse(request.getParameter("start"));
            int filmId = Integer.parseInt(request.getParameter("film-id"));
            double price = Double.parseDouble(request.getParameter("ticket-price"));

            Seance seance = Seance
                    .newBuilder()
                    .setFilm(filmId)
                    .setStart(start)
                    .setEnd(start)
                    .setPrice(price)
                    .build();

            seanceService.addSeance(user,seance);
        } catch (ParseException e) {
            e.printStackTrace();
        }



        return CommandFactory.defineCommand("/").execute(request,response);
    }
}
