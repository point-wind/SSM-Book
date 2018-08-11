package com.ssm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ssm.common.exception.EstoreCommonException;
import com.ssm.common.util.ResponseResult;
import com.ssm.service.interfaces.IBookService;
import com.ssm.service.interfaces.ICustomerService;
import com.ssm.common.bean.Book;
import com.ssm.common.bean.Customer;

/*
 * 首页相关的Controller
 * showIndexPage分页展示的方法
 * showBookDetial	展示书本的详细信息
 * updateCustomer	更改用户信息
 * 		update_checkName	更改用户时检查是否可用
 * 
 */
@Controller
public class IndexController {
	
	@Autowired
	private IBookService bookService;
	
	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value={"/","index"})
	public String showIndexPage(HttpSession session,@RequestParam(value="page",required=false,defaultValue="1") int page) {
		try {
			PageInfo<Book> pageInfo = bookService.finaAllBookWithPage(page, 3);
			session.setAttribute("pageInfo", pageInfo);
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "查询失败:" + e.getMessage());
		}
		return "index";
	}
	
	@RequestMapping("/productDetail/{status}")
	public String showBookDetial(@PathVariable int status,HttpSession session){
		@SuppressWarnings("unchecked")
		PageInfo<Book> pageInfo = (PageInfo<Book>) session.getAttribute("pageInfo");
		Book book = pageInfo.getList().get(status);
		session.setAttribute("book", book);
		return "redirect:/productDetail";
	}
	
	@RequestMapping(value="/updateCustomer-controller",method=RequestMethod.POST)
	public String updateCustomer(Customer customer,HttpSession session) {
		Long customer_id = (Long) session.getAttribute("customer_id");
		customer.setId(customer_id);
		try {
			customerService.updateCustomer(customer);
			session.removeAttribute("customer");
			session.setAttribute("msg", "修改成功");
			return "redirect:/login";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "修改失败");
			return "redirect:/userInfo";
		}
	}
	
	@RequestMapping("/update-check/{name}")
	@ResponseBody
	public Object update_checkName(@PathVariable String name,HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		String user_name=customer.getName();
		if ((name.equals(user_name))) {
			return ResponseResult.build(300, "exist");
		}
		try {
			Customer findName = customerService.findName(name);
			if (findName==null) {
				return ResponseResult.ok();
			}
			return ResponseResult.build(500, "faile");
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			return ResponseResult.build(500, "faile");
		}
	}
}


