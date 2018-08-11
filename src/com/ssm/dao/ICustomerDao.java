package com.ssm.dao;


import com.ssm.common.bean.Customer;

public interface ICustomerDao  {
	public Customer findByName(String name);
	public void saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
}
