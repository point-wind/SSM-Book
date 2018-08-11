package com.ssm.common.bean;

import java.io.Serializable;

/**
 *书本类
 *属性有:
 *	Long id
 *	String name
 *	Double price
 *
 *
 *@author 贺彬锋
 *@date 2018年7月30日 18:26:40
 *@email pointwind@aliyun.com
 * */
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// 书本的id属性
	private Long id;
	
	// 书本的名字属性
	private String name;
	
	// 书本的价格属性
	private Double price;
	/*
	//书本的作者
	private String author;
	
	//书本的出版社
	private String press;
	
	//页码
	private String page;
	
	//类别
	private String family;
	
	//简介
	private String introduction;
	*/
	
	public Book(){
	}
	
	public Book(Long id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
