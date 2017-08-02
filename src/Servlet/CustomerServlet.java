package Servlet;

import Dao.CustomerDao;
import Service.CustomerService;
import Service.SendEmail;
import domain.CriteriaCustomer;
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
        String page = null;
        page = request.getParameter("page");
        if (page == null||page.equals("")){
            page = "1";
        }
        long pagenum = customerDao.getcountwithAll()%5==0?customerDao.getcountwithAll()/5:customerDao.getcountwithAll()/5+1;
        if (pagenum==0){
            page="0";
        }
        List<Customer> customers = customerDao.getAll(Integer.parseInt(page));
        request.setAttribute("customers",customers);
        request.setAttribute("pagenum",pagenum);
        request.setAttribute("page",page);
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
            SendEmail sendEmail = new SendEmail(customer);
            sendEmail.start();
            request.setAttribute("msg", name + "用户已经添加成功！");
            request.getRequestDispatcher("/msg.jsp").forward(request, response);
        }
    }

    private void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String strid = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(strid);
            customerDao.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("queryall.do");
    }

    private void edit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String strid = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(strid);
            Customer customer = customerDao.get(id);
            request.setAttribute("editcustomer",customer);
            request.getRequestDispatcher("/edit.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String idstr = request.getParameter("id");
        int id = Integer.parseInt(idstr);
        String oldname = request.getParameter("oldname");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String description = request.getParameter("description");

        Customer customer = new Customer(id,name,gender,phone,email,description);

        if(!oldname.equalsIgnoreCase(name)){
            if (customerDao.getcountwithName(name)>0) {
                request.setAttribute("msg", oldname + ",您好！该用户名已经存在");
                request.setAttribute("editcustomer", customer);
                request.getRequestDispatcher("/edit.jsp").forward(request, response);
            }
        }
        else {
            customerDao.edit(customer);
            response.sendRedirect("queryall.do");
        }

    }

    private void query(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String page = null;
        page = request.getParameter("page");
        if (page==null || page.equals("")){
            page = "1";
        }
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String description = request.getParameter("description");
        CriteriaCustomer criteriaCustomer = new CriteriaCustomer(name,gender,phone,email,description);
        long pagenum = customerDao.getcountwithCC(criteriaCustomer)%5==0?customerDao.getcountwithCC(criteriaCustomer)/5:customerDao.getcountwithCC(criteriaCustomer)/5+1;
        if (pagenum==0){
            page = "0";
        }
        List<Customer> customers = customerDao.getAllWithCC(criteriaCustomer,Integer.parseInt(page));
        request.setAttribute("customers",customers);
        request.setAttribute("pagenum",pagenum);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
