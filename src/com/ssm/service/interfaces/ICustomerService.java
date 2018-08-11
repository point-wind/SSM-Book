package com.ssm.service.interfaces;

import com.ssm.common.bean.Customer;
import com.ssm.common.exception.EstoreCommonException;;

public interface ICustomerService {
	void register(Customer customer) throws EstoreCommonException;
	Customer login(String name,String password) throws EstoreCommonException;
	void updateCustomer(Customer customer) throws EstoreCommonException;
	Customer findName(String name) throws EstoreCommonException;
}
