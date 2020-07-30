//DTO : Data Transfer Object. Setter/Getter 있는 bean파일.

package com.twosome.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Order {
	private int num;
	private String item;
	private int price;
	private int qty;
	private int tn;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getTn() {
		return tn;
	}
	public void setTn(int tn) {
		this.tn = tn;
	}
	
	
	// 이모부만 사용하시는 편리한 기능.
	public String ret;
	public static Order makeByJsonStr(String jsonStr) {
		String ret = "";
		ObjectMapper mapper = new ObjectMapper();
		Order order = null;
		try {
			order = mapper.readValue(jsonStr, Order.class);
			order.ret = null;
		} catch (JsonProcessingException e) {
			order = new Order();
			Map<String, String> map = new HashMap<>(); 
			map.put("result", "error"); 
			map.put("message", e.toString());
			try {
				ret = mapper.writeValueAsString(map);
			} catch (JsonProcessingException e1) {
				ret = e1.toString();
				e1.printStackTrace();
			}
			order.ret = ret;
		}
		return order;
	}		
}



