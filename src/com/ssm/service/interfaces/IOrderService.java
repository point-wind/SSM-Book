package com.ssm.service.interfaces;

import java.util.List;
import java.util.Set;

import com.ssm.common.bean.Line;
import com.ssm.common.bean.Order;
import com.ssm.common.exception.EstoreCommonException;;

public interface IOrderService {
	void confirmOrder(Order order,Set<Line> lines) throws EstoreCommonException;
	void deleteOrder(Long id) throws EstoreCommonException;
	List<Order> findById(Long id) throws EstoreCommonException;
}
