package ism.api.auth;

import ism.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AuthServlet", urlPatterns = {"auth"}, loadOnStartup = 1)
public class AuthServlet extends BaseServlet {

  @Override
  protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      PrintWriter writer = resp.getWriter();
      System.out.println("Got here");
      resp.setContentType("");
      writer.println("worked somehow");
  }

  @Override
  protected void head(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }

  @Override
  protected void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }

  @Override
  protected void put(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }

  @Override
  protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }

  @Override
  protected void serviceRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }
}
