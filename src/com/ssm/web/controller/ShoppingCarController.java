package com.ssm.web.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.ssm.common.bean.Book;
import com.ssm.common.bean.Line;
import com.ssm.common.bean.ShoppingCar;

@Controller
public class ShoppingCarController {

	@RequestMapping("/addbook-controller/{status}")
	public String addBook(@PathVariable int status,HttpSession session){
		@SuppressWarnings("unchecked")
		PageInfo<Book> pageInfo = (PageInfo<Book>) session.getAttribute("pageInfo");
		Book book = pageInfo.getList().get(status);
		Line line = new Line();
		line.setBook(book);
		ShoppingCar shoppingCar = (ShoppingCar) session.getAttribute("car1");
		shoppingCar.add(line);
		session.setAttribute("car2", shoppingCar);
		return "redirect:/shoppingCar";
	}
	
	@RequestMapping("/delLine/{book_id}")
	public String delLine(@PathVariable Long book_id,HttpSession session) {
		ShoppingCar shoppingCar  = (ShoppingCar) session.getAttribute("car2");
		shoppingCar.delete(book_id);
		session.setAttribute("car2", shoppingCar);
		return "redirect:/shoppingCar";
	}
	
	@RequestMapping(value="/chLine/{book_id}/num",method=RequestMethod.POST)
	public String chLine(@PathVariable Long book_id,@RequestParam("num") int num,HttpSession session) {
		ShoppingCar shoppingCar  = (ShoppingCar) session.getAttribute("car2");
		shoppingCar.getLines().get(book_id).setNum(num);
		session.setAttribute("car2", shoppingCar);
		return "redirect:/shoppingCar";
	}
	
	@RequestMapping("/clearCar")
	public String clearCar(HttpSession session) {
		ShoppingCar shoppingCar = (ShoppingCar) session.getAttribute("car2");
		if (shoppingCar.getClass().isEnum()) {

			return "error";
		}
		shoppingCar.clear();
		session.setAttribute("car2", shoppingCar);
		return "redirect:/index";
	}
}
