package com.ssm.common.bean;

import java.io.Serializable;

/**
 *订单项类
 *属性有:
 *	Long id
 *	Integer num
 *	Order order
 *	Book book
 *
 *
 *@author 贺彬锋
 *@date 2018年7月30日 18:26:40
 *@email pointwind@aliyun.com
 * */
public class Line implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 订单id
	private Long id;
	
	// 订单项中书本数量
	private Integer num;
	
	// 订单属性  关联关系 -- 多对一  对应一个订单
	private Order order;
	
	// 书本属性  关联关系 -- 多对一  对应一类书
	private Book book;
	
	public Line(){
		
	}
	
	public Line(Long id, Integer num) {
		this.id = id;
		this.num = num;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getNum() {
		return num;
	}
	
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
}
