package com.ssm.dao;


import java.util.List;

import com.ssm.common.bean.Order;

public interface IOrderDao  {
	public void saveOrder(Order order);
	public List<Order> findOrderById(Long id);
	public void deleteOrder(Long id);
}
