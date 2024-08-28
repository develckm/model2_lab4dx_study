package com.lab4dx.l06_mvc.service;

import com.lab4dx.l06_mvc.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    /* dao 용어와 service 용어를 구분하려한다.(거의 비슷해서 구분하려고)
    * 전체조회 read, fetch, get
    * 디테일조회
    * 수정요청 modify
    * 등록요청 register,add
    * 삭제요청 remove
    * */

    List<CustomerDto> getAll() throws Exception;
    CustomerDto get(int id) throws Exception;
    int register(CustomerDto customerDto) throws Exception;
    int modify(CustomerDto customerDto) throws Exception;
}
