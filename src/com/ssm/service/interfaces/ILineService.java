package com.ssm.service.interfaces;

import java.util.Set;

import com.ssm.common.bean.Line;
import com.ssm.common.exception.EstoreCommonException;

public interface ILineService {
	
	public void saveLines(Set<Line> lines) throws EstoreCommonException;
	
	public void removeLines(Long orderId) throws EstoreCommonException;
	
	public Set<Line> findLinesByOrderId(Long orderId) throws EstoreCommonException;
}
