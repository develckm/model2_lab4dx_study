package com.lab4dx.l06_mvc.dao;

import com.lab4dx.l06_mvc.dto.CustomerDto;

import java.util.List;

public interface CustomerDao {
    //선인 Dao
    List<CustomerDto> findAll() throws Exception;
    CustomerDto findById(int id) throws Exception;
    int save(CustomerDto customerDto) throws Exception;
    int update(CustomerDto customerDto) throws Exception;
    int delete(int id) throws Exception;
}
