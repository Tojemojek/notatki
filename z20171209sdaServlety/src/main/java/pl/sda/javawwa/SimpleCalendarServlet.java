package pl.sda.javawwa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class SimpleCalendarServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String date = LocalDateTime.now().toString();
        resp.getWriter().write(date+ "\n");

        Date time = Calendar.getInstance().getTime();
        resp.getWriter().write(time.toString());

    }
}
