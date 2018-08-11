package com.ssm.dao;

import java.util.Set;

import com.ssm.common.bean.Line;

public interface ILineDao  {

	public void saveLines(Line line);
	
	public void removeLinesByOrderId(Long orderId);
	
	public Set<Line> findLinesByOrderId(Long orderId);
	
	public void commit();
}
