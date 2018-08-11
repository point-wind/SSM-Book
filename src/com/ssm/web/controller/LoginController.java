package com.ssm.web.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.common.bean.Customer;
import com.ssm.common.bean.ShoppingCar;
import com.ssm.common.exception.EstoreCommonException;
import com.ssm.common.util.ResponseResult;
import com.ssm.service.interfaces.ICustomerService;

/**
 *��½��ע���controller
 *
 *����login
 *	ʵ���û���½����
 *
 *����register_checkName
 *	ʵ��ע��ʱʵʱ����û����Ƿ��ظ�
 *
 *����register
 *	ʵ��ע�Ṧ��
 *
 *@author �ر��
 *@date 2018��7��31��
 *@email pointwind@aliyun.com
 * */

@Controller
public class LoginController {
	
	@Autowired
	private ICustomerService service;
	
	//login.jspҳ�洫��userid��password���е�½����֤
	@RequestMapping(value="/login-controller",method=RequestMethod.POST)
	public String login(@RequestParam("userid") String userid,
			@RequestParam("password") String password,HttpSession session){
		try {
			Customer customer = service.login(userid, password);
			session.setAttribute("customer", customer);
			session.setAttribute("customer_id", customer.getId());
			session.setAttribute("car1",new ShoppingCar());
			return "redirect:/index";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			if (e.getErrcode()==101) {
				session.setAttribute("msg","��¼ʧ��"+e.getMessage());
			} 
			session.setAttribute("msg","��¼ʧ��"+e.getMessage());
			return "redirect:/login";
		}
	}
	
	
	//ע��ʱ����û����Ƿ����
	@RequestMapping("/register-check/{name}")
	@ResponseBody
	public Object register_checkName(@PathVariable String name) {
		try {
			Customer findName = service.findName(name);
			if (findName==null) {
				return ResponseResult.ok();
			}
			return ResponseResult.build(500, "faile");
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			return ResponseResult.build(500, "faile");
		}
	}
	
	//register.jspҳ�洫��customer���󣨴��κͶ��������Ҫͬ����Ӧ����ʵ��ע�Ṧ��
	@RequestMapping(value="/register-controller",method=RequestMethod.POST)
	public String register(Customer customer,HttpSession session) {
		try {
			service.register(customer);
			session.setAttribute("msg", "ע��ɹ�,���½!");
			return "redirect:/login";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "ע��ʧ��");			
			return "redirect:/register";
		}
	}

	
}
