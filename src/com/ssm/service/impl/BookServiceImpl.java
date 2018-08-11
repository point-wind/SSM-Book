package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.common.bean.Book;
import com.ssm.common.exception.EstoreCommonException;
import com.ssm.dao.IBookDao;
import com.ssm.service.interfaces.IBookService;

@Service
public class BookServiceImpl implements IBookService{

	@Autowired
	private IBookDao bookDao;
	
	@Override
	public List<Book> listAllBooks() throws EstoreCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findById(Long id) throws EstoreCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Book> finaAllBookWithPage(int page, int row) throws EstoreCommonException{
		PageHelper.startPage(page, row);
		List<Book> books = bookDao.selectAll();
		return new PageInfo<>(books);
	}

}
