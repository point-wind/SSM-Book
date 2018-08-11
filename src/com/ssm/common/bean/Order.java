package com.ssm.common.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *订单类
 *属性有:
 *	Long id
 *	Double cost
 *	Date orderDate
 *
 *
 *@author 贺彬锋
 *@date 2018年7月30日 18:26:40
 *@email pointwind@aliyun.com
 * */
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 订单id
	private Long id;
	
	// 订单的总价格
	private Double cost;
	
	// 下单时间
	private Date orderDate;
	
	// 订单项  关联关系 - 一对多 : 对应多个订单项
	private Set<Line> lines = new HashSet<>();
	
	// 用户   关联关系 - 多对一 : 对应一个顾客
	private Customer customer;
	
	public Order(){
		
	}
	
	public Order(Long id, Double cost, Date orderDate) {
		this.id = id;
		this.cost = cost;
		this.orderDate = orderDate;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getCost() {
		return cost;
	}
	
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public Set<Line> getLines() {
		return lines;
	}
	
	public void setLines(Set<Line> lines) {
		this.lines = lines;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
