package com.lab4dx.l06_mvc.controller;

import com.lab4dx.l06_mvc.dto.CustomerDto;
import com.lab4dx.l06_mvc.service.CustomerService;
import com.lab4dx.l06_mvc.service.CustomerServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/customerList.do")
public class CustomerListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<CustomerDto> customers=null;

        try {
            CustomerService customerService=new CustomerServiceImp();
            customers=customerService.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("customers", customers);
        //getRequestDispatcher  "/ => webapp 하위"
        req.getRequestDispatcher("/customerList.jsp").forward(req, resp);
    }
}
