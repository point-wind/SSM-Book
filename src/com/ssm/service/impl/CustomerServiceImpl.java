package com.ssm.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.ICustomerDao;
import com.ssm.common.bean.Customer;
import com.ssm.common.exception.EstoreCommonException;
import com.ssm.service.interfaces.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;
	
	@Override
	public void register(Customer customer) throws EstoreCommonException {
		Customer findC = customerDao.findByName(customer.getName());
		if (findC != null) {
			throw new EstoreCommonException(103,"用户已存在");
		}
		customerDao.saveCustomer(customer);
	}

	@Override
	public Customer login(String userid, String password) throws EstoreCommonException {
		Customer findByName = customerDao.findByName(userid);
		if (findByName != null) {
			if (findByName.getPassword().equals(password)) {
				return findByName;
			}
			throw new EstoreCommonException(101, "密码错误");
		}
		throw new EstoreCommonException(102, "没有该用户");
	}

	@Override
	public void updateCustomer(Customer customer) throws EstoreCommonException {
		customerDao.updateCustomer(customer);
	}

	@Override
	public Customer findName(String name) throws EstoreCommonException {
		if (name.isEmpty()) {
			throw EstoreCommonException.getException(401);
		}
		return customerDao.findByName(name);
	}

}
