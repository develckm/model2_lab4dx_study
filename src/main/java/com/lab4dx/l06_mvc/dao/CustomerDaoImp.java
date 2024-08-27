package com.lab4dx.l06_mvc.dao;

import com.lab4dx.l06_mvc.DBConnection;
import com.lab4dx.l06_mvc.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImp implements CustomerDao {
    //db 접속 해서 쿼리실행하려면  Connection 꼭 필요 (생성자 매개변수)
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement pstmt;

    public CustomerDaoImp(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<CustomerDto> findAll() throws Exception {
        List<CustomerDto> customers=null;
        stmt=conn.createStatement(); //질의를 할 준비
        rs=stmt.executeQuery("SELECT * FROM CUSTOMER");//Select == query
        customers=new ArrayList<CustomerDto>();
        while (rs.next()) {
            CustomerDto customer = new CustomerDto();
            customer.setCustomerEmail(rs.getString("CUSTOMER_EMAIL"));
            customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
            customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
            customer.setCustomerPhone(rs.getString("CUSTOMER_PHONE"));
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public CustomerDto findById(int id) throws Exception {
        return null;
    }

    @Override
    public int save(CustomerDto customerDto) throws Exception {
        return 0;
    }

    @Override
    public int update(CustomerDto customerDto) throws Exception {
        return 0;
    }

    @Override
    public int delete(int id) throws Exception {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        Connection conn=DBConnection.getConnection();
        CustomerDaoImp customerDao=new CustomerDaoImp(conn);
        List<CustomerDto> customers=customerDao.findAll();
        System.out.println(customers.toString());
    }
}
