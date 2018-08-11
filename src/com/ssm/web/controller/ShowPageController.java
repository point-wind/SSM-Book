package com.ssm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Ìø×ªµÄController
 * @author xxx
 */
@Controller
public class ShowPageController {

	//µÇÂ½Ò³Ãæ
	@RequestMapping("/login")
	public String showLoginPage(){
		return "/login";
	}
	
	//
	@RequestMapping("/register")
	public String showResisterPage(){
		return "/register";
	}

	@RequestMapping("/userInfo")
	public String showUserInfoPage(){
		return "/userInfo";
	}
	
	@RequestMapping("/shoppingCar")
	public String showShopCarPage(){
		return "/shoppingCar";
	}
	
	@RequestMapping("/productDetail")
	public String showProductDetialPage() {
		return "/productDetail";
	}
	
	@RequestMapping("/orderInfo")
	public String showOrderPage() {
		return "/order";
	}
	
	@RequestMapping("/orderDetail")
	public String showOrderDetialPage() {
		return "/orderDetail";
	}
	
	@RequestMapping("/orderConfirm")
	public String showConfirmOrderPage() {
		return "/confirmOrder";
	}
	
	@RequestMapping("/error")
	public String showErrorPage(){
		return "/error";
	}
	
	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
