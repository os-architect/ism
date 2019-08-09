package ism.base;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
      super.init(config);
  }

  @Override
  public void destroy() {
    super.destroy();
  }

  public static void main(String[] args) {
      System.out.println("Hello!");
  }

  private final void setDefaults(HttpServletRequest req, HttpServletResponse resp) {
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
  }

  @Override
  protected final void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.setDefaults(req, resp);
    try {
      this.get(req, resp);
    } catch(Exception e) {
      this.onException(e, req, resp);
    } finally {
      this.log(e);
    }
  }

  @Override
  protected final void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.setDefaults(req, resp);
    this.head(req, resp);
  }

  @Override
  protected final void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.setDefaults(req, resp);
    this.post(req, resp);
  }

  @Override
  protected final void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.setDefaults(req, resp);
    this.put(req, resp);
  }

  @Override
  protected final void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.setDefaults(req, resp);
    this.delete(req, resp);
  }

  @Override
  protected final void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.setDefaults(req, resp);
    this.serviceRequest(req, resp);
  }

  protected abstract void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
  protected abstract void head(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
  protected abstract void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
  protected abstract void put(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
  protected abstract void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
  protected abstract void serviceRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
  protected void onException(Exception e, HttpServletRequest req, HttpServletResponse resp) throws Exception {}

  private void log(Object object){
    if (object instanceof Exception){

    } else (object instanceof gson){

    }



  }


}
