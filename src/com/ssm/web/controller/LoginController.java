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
 *登陆及注册的controller
 *
 *方法login
 *	实现用户登陆功能
 *
 *方法register_checkName
 *	实现注册时实时检测用户名是否重复
 *
 *方法register
 *	实现注册功能
 *
 *@author 贺彬锋
 *@date 2018年7月31日
 *@email pointwind@aliyun.com
 * */

@Controller
public class LoginController {
	
	@Autowired
	private ICustomerService service;
	
	//login.jsp页面传入userid和password进行登陆的验证
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
				session.setAttribute("msg","登录失败"+e.getMessage());
			} 
			session.setAttribute("msg","登录失败"+e.getMessage());
			return "redirect:/login";
		}
	}
	
	
	//注册时检查用户名是否可用
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
	
	//register.jsp页面传入customer对象（传参和对象的属性要同名对应），实现注册功能
	@RequestMapping(value="/register-controller",method=RequestMethod.POST)
	public String register(Customer customer,HttpSession session) {
		try {
			service.register(customer);
			session.setAttribute("msg", "注册成功,请登陆!");
			return "redirect:/login";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "注册失败");			
			return "redirect:/register";
		}
	}

	
}
