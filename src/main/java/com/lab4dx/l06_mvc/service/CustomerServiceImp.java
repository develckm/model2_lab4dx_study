package com.lab4dx.l06_mvc.service;

import com.lab4dx.l06_mvc.DBConnection;
import com.lab4dx.l06_mvc.dao.CustomerDao;
import com.lab4dx.l06_mvc.dao.CustomerDaoImp;
import com.lab4dx.l06_mvc.dto.CustomerDto;

import java.sql.Connection;
import java.util.List;

public class CustomerServiceImp implements CustomerService {
    //서비스에서 트랜잭션을 관리하려면 세이브포인트(commit) 오류가 발생하면 세이브 포인트로
    //되돌려야(rollback)하는데 Connection을 서비스에서 가지고 있어야한다.
    //dao는 Connection을 주는대로 쓰기만함.

    private Connection conn;
    private CustomerDao customerDao;
    public CustomerServiceImp() throws Exception {
        conn= DBConnection.getConnection();
        customerDao=new CustomerDaoImp(conn);
    }


    @Override
    public List<CustomerDto> getAll() throws Exception {
        return customerDao.findAll();
    }

    @Override
    public CustomerDto get(int id) throws Exception {
        return customerDao.findById(id);
    }
    @Override
    public int register(CustomerDto customerDto) throws Exception {
        try {
            conn.setAutoCommit(false);
            conn.commit(); //세이브 포인트
            //대출
            //1.은행잔고확인
            //2.은행금고 돈을 업데이트
            //3.업데트 내역 등록
            //4.대출하는 은행에 금고 업데이트
            //5.대출받는 고객의 잔고에 금액을 업데이트
            //6.완료 기록
            //-> 트랜잭션 (일괄성 == 원자성) : 이중하나라도 오류가 생기면 모두를 취소
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw new RuntimeException(e);
        }



        return 0;
    }

    @Override
    public int modify(CustomerDto customerDto) throws Exception {
        return 0;
    }
}
