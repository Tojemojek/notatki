package pl.sda.javawwa;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class AllHeadersStrikesBack extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("mojNaglowek", "tresc naglowka");

        Cookie cookie = new Cookie("mojeCiasteczko","123");
        resp.addCookie(cookie);

        Enumeration<String> headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            resp.getWriter().write(header + ":" + req.getHeader(header) + "\n");
        }

//        resp.addHeader("mojNaglowek2", "tresc naglowka2");

    }
}
