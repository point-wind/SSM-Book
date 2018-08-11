package com.ssm.dao;

import java.util.List;


import com.ssm.common.bean.Book;

public interface IBookDao  {
	public List<Book> selectAll();
	public Book selectById(Long id);
}
