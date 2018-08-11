package com.ssm.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.common.bean.Customer;
import com.ssm.common.bean.Line;
import com.ssm.common.bean.Order;
import com.ssm.common.bean.ShoppingCar;
import com.ssm.common.exception.EstoreCommonException;
import com.ssm.service.interfaces.ILineService;
import com.ssm.service.interfaces.IOrderService;

@Controller
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private ILineService lineService;
	
	@RequestMapping("orderInfo-controller")
	public String orderInfo(HttpSession session) {
		Customer customer=(Customer) session.getAttribute("customer");
		try {
			List<Order> orders = orderService.findById(customer.getId());
			session.setAttribute("orders", orders);
			return "redirect:/orderInfo";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			return "redirect:/index";
		}
	}
	
	@RequestMapping("orderInfoDetail-controller/{status}")
	public String orderInfoDetail(@PathVariable int status,HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Order> orders = (List<Order>) session.getAttribute("orders");
		Order order = orders.get(status);
		session.setAttribute("order", order);
		try {
			Set<Line> lines = lineService.findLinesByOrderId(order.getId());
			session.setAttribute("lines", lines);

			return "redirect:/orderDetail";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			return "redirect:/orderInfo";
		}
	}
	
	@RequestMapping(value="/saveOrder",method=RequestMethod.POST)
	public String orderAdd(HttpSession session){
		Customer customer = (Customer) session.getAttribute("customer");
		
		ShoppingCar shoppingCar = (ShoppingCar) session.getAttribute("car2");
		if (shoppingCar.getClass().isEnum()) {
			return "error";
		}
		
		Map<Long, Line> line_map = shoppingCar.getLines();
		Set<Line> lines = new HashSet<Line>(line_map.values());
		
		Order order = new Order();
		order.setCustomer(customer);
		order.setCost(shoppingCar.getCost());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = df.parse(df.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		order.setOrderDate(date);
		order.setLines(lines);
		try {
			orderService.confirmOrder(order,lines);
			lineService.saveLines(lines);
			return "redirect:/index";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping("orderDel/{status}")
	public String orderDel(@PathVariable int status,HttpSession session){
		@SuppressWarnings("unchecked")
		List<Order> orders = (List<Order>) session.getAttribute("orders");
		Order order = orders.get(status);
		try {
			lineService.removeLines(order.getId());
			orderService.deleteOrder(order.getId());
			return "redirect:/index";
		} catch (EstoreCommonException e) {
			return "redirect:/orderInfo";
		}
	}
	
}
