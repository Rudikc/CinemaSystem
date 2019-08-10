package ua.rudikc.cinema.command;

import ua.rudikc.cinema.dao.SeanceDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.model.Seance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetSeancesCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SeanceDao seanceDao = (SeanceDao) DaoFactory.getDao("seanceDao");
        try {
            List<Seance> seances = seanceDao.findSeancesByDate("2019-08-12");
            request.setAttribute("seances", seances);

        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "seances";
    }
}
