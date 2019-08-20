package ua.rudikc.cinema.controller.actions;

import ua.rudikc.cinema.dao.SeanceDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dto.SeanceDto;
import ua.rudikc.cinema.factory.CommandFactory;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.entity.Seat;
import ua.rudikc.cinema.service.SeanceService;
import ua.rudikc.cinema.service.SeatService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class GetSeatsMapAction implements Action {
    /**
     * Action that creates map of free seats for seance.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SeanceDao seanceDao = (SeanceDao) DaoFactory.getDao(DaoFactory.SEANCE_DAO);
        SeatService seatService = (SeatService) ServiceFactory.getService("seatService");
        SeanceService seanceService = (SeanceService) ServiceFactory.getService("seanceService");

        int seanceId = Integer.parseInt(request.getParameter("seance-id"));
        try {
            if (!seanceDao.get(seanceId).isPresent()){
                return CommandFactory.defineCommand("/seances").execute(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }

        SeanceDto seanceDto = seanceService.getSeanceDtoById(seanceId);
        ArrayList<ArrayList<Seat>> allSeats = seatService.getListOfRowsOfSeats();
        ArrayList<Seat> busySeats = seatService.getBusySeatsById(seanceId);
        request.setAttribute("seance",seanceDto);
        request.setAttribute("all_seats",allSeats);
        request.setAttribute("busy_seats",busySeats);
        return "seats";
    }
}
