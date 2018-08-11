package com.ssm.common.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 用户类
 * 属性有:
 * 	Long id
 * 	String name
 * 	String password
 * 	String zip
 * 	String address
 * 	String telephone
 * 	String email
 * 	Set<Order> orders
 * 	
 * 	
 *@author 贺彬锋
 *@date 2018年7月30日 18:49:01
 *@email pointwind@aliyun.com
 * */
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// 用户的id
	private Long id;
	
	// 用户的用户名
	private String name;
	
	// 用户的密码
	private String password;
	
	// 用户的地址  省市
	private String zip;
	
	// 用户的地址  详细地址
	private String address;
	
	// 用户的电话
	private String telephone;
	
	// 用户的邮箱
	private String email;
	
	// 用户的订单  关联关系 -- 一对多  一个用户多个订单
	private Set<Order> orders = new HashSet<>();
	
	public Customer(){
		
	}
	
	public Customer(Long id, String name, String passwd, String zip,
			String address, String telephone, String email, Set<Order> orders) {
		this.id = id;
		this.name = name;
		this.password = passwd;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.orders = orders;
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
}
