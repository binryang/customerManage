package Servlet;

import Dao.CustomerDao;
import Service.CustomerService;
import domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by yangrb on 17-7-17.
 */
@WebServlet(name = "CustomerServlet")
public class CustomerServlet extends HttpServlet {
    CustomerDao customerDao = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("text/html;charset=utf-8");

        String servletPath = request.getServletPath();

        String servletmethod = servletPath.substring(1,servletPath.length()-3);


        try {
            Method method = getClass().getDeclaredMethod(servletmethod,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (Exception e) {
            response.sendRedirect("/error.jsp");
            e.printStackTrace();
        }
    }

    private void queryall(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerDao.getAll();
        request.setAttribute("customers",customers);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    private void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String description = request.getParameter("description");
        if(customerDao.getcountwithName(name)>0){
            request.setAttribute("msg",name+"用户已存在！");
            request.getRequestDispatcher("/add.jsp").forward(request,response);
        }
        else {
            Customer customer = new Customer(name, gender, phone, email, description);
            customerDao.save(customer);
            request.setAttribute("msg", name + "用户已经添加成功！");
            request.getRequestDispatcher("/msg.jsp").forward(request, response);
        }
    }
}
