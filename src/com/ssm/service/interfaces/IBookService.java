package com.ssm.service.interfaces;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ssm.common.bean.Book;
import com.ssm.common.exception.EstoreCommonException;;

public interface IBookService {
	
	List<Book> listAllBooks() throws EstoreCommonException ;
	Book findById(Long id) throws EstoreCommonException;
	PageInfo<Book> finaAllBookWithPage(int page, int row) throws EstoreCommonException;
}
