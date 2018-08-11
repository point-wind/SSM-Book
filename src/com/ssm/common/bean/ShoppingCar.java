package com.ssm.common.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *购物车类（订单项）
 *属性:
 *	Map<Long, Line> map
 *方法:
 *	void add(Line line)
 *	void delete(Long bookId)
 *	double getCost()
 *	Map<Long, Line> getLines()
 *	void clear()
 *
 *
 *
 *@author 贺彬锋
 *@date 2018年7月30日 18:26:40
 *@email pointwind@aliyun.com
 * */
public class ShoppingCar {
	
	// key 商品id value 订单项（商品，数量）
	private Map<Long, Line> map = new HashMap<Long, Line>();
	
	// 向购物车中添加
	public void add(Line line){
		if(map.containsKey(line.getBook().getId())){
			Line oldline = map.get(line.getBook().getId());
			oldline.setNum(oldline.getNum()+1);
		}else{
			line.setNum(1);
			map.put(line.getBook().getId(), line);
		}
	}
	
	// 删除书本
	public void delete(Long bookId){
		map.remove(bookId);
	}
	
	// 获取价钱
	public double getCost(){
		Set<Long> keySet = map.keySet();
		Iterator<Long> iter = keySet.iterator();
		double cost = 0.0;
		while(iter.hasNext()){
			Long key = iter.next();
			Line value = map.get(key);
			Integer num = value.getNum();
			double price = value.getBook().getPrice();
			double lineCost = num*price;
			cost += lineCost;
		}
		return cost;
	}
	
	// 获取购物车中所有订单项
	public Map<Long, Line> getLines(){
		return map;
	}
	
	// 清空购物车
	public void clear(){
		map.clear();
	}
	
}
