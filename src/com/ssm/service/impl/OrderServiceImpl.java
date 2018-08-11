package com.ssm.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.common.bean.Line;
import com.ssm.common.bean.Order;
import com.ssm.common.exception.EstoreCommonException;
import com.ssm.dao.IOrderDao;
import com.ssm.service.interfaces.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderDao orderDao;
	
	
	@Override
	public void confirmOrder(Order order, Set<Line> lines) throws EstoreCommonException {
		System.out.println();
		orderDao.saveOrder(order);
		for (Line line : lines) {
			line.setOrder(order);
			if (line.getBook() == null || line.getNum() == null || line.getOrder() == null) {
				
				System.out.println("--------"+line.getBook());
				System.out.println("--------"+line.getNum());
				System.out.println("--------"+line.getOrder());
				throw EstoreCommonException.getException(401);
			}
			System.out.println("--------"+line.getBook().getId());
			System.out.println("--------"+line.getNum());
			System.out.println("--------"+line.getOrder().getId());
		}
	}


	@Override
	public void deleteOrder(Long id) throws EstoreCommonException {
		orderDao.deleteOrder(id);
	}

	@Override
	public List<Order> findById(Long id) throws EstoreCommonException {
		if (id==null) {
			throw  EstoreCommonException.getException(401);
		}
		System.out.println("customer---"+id);
		List<Order> orders = (List<Order>) orderDao.findOrderById(id);
		return orders;
	}


}
