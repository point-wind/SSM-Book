package com.ssm.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.common.bean.Line;
import com.ssm.common.exception.EstoreCommonException;
import com.ssm.dao.ILineDao;
import com.ssm.service.interfaces.ILineService;

@Service
public class LineServiceImpl implements ILineService {

	@Autowired
	private ILineDao lineDao;

	@Override
	public void saveLines(Set<Line> lines) throws EstoreCommonException {
		if (lines == null) {
			throw EstoreCommonException.getException(401);
		}
		for (Line line : lines) {
			if (line.getBook() == null || line.getNum() == null || line.getOrder() == null) {
				throw EstoreCommonException.getException(401);
			}
			// 将每个订单项都插入数据库
			System.out.println(line.getBook());
			lineDao.saveLines(line);
		}
	}

	@Override
	public void removeLines(Long orderId) throws EstoreCommonException {
		if (orderId == null) {
			throw EstoreCommonException.getException(401);
		}
		lineDao.removeLinesByOrderId(orderId);
	}

	@Override
	public Set<Line> findLinesByOrderId(Long orderId) throws EstoreCommonException {
		if (orderId == null) {
			throw EstoreCommonException.getException(401);
		}
		Set<Line> lines = lineDao.findLinesByOrderId(orderId);
		return lines;
	}

}
