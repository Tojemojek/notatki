package pl.sda.javawwa.servlets;

import pl.sda.javawwa.dto.DaysDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class DaysListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer days = Integer.valueOf(req.getParameter("days"));
        LocalDateTime dt = LocalDateTime.now();

        List<DaysDto> daysDtoList = new LinkedList<>();

        for (int i = 1; i <= days; i++) {

            LocalDateTime after = dt.plusDays(i);
            DaysDto dayDto = new DaysDto();

            dayDto.setDaysAfter(i);
            dayDto.setDateAfter(after);

            daysDtoList.add(dayDto);
        }

        //ustawienie atrubutu sesji po to żeby było to przekazane obiektowo wewnątrz
        //servletów
        req.setAttribute("mojAtrybutListyDTO", daysDtoList);
        req.setAttribute("howManyDaysWereGiven",days);

        //to jest do przekazania sterowania do kolejnego servletu - w tym przypadku jsp.
        req.getRequestDispatcher("views/days.jsp").forward(req, resp);

    }
}
