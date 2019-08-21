package ua.rudikc.cinema.controller.actions;

import ua.rudikc.cinema.controller.actions.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeAction implements Action {
    /**
     * Action that redirect user to index page.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        request.setAttribute("todayDate", simpleDateFormat.format(today));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, 6);
        request.setAttribute("todayAfterSevenDays",simpleDateFormat.format(calendar.getTime()));

        return "index";
    }
}
