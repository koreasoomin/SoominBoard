package com.twosome.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.twosome.common.Utils;
import com.twosome.model.Order;
import com.twosome.services.OrderService;
import com.twosome.services.impl.OrderServiceImpl;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

	private OrderService orderService;

	OrderController() {
		super(); // 모든 조상클래스(BaseController의 생성자 호출
	}

	// OrderController는 OrderService에 의존한다.
	@Autowired
	OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	/*
	 * RestAPI
	 * 
	 * Order 리스트를 가져온다.
	 * 
	 * 입력 업음
	 * 
	 * 출력 JSON
	 */

//	@RequestMapping(value = "/list", produces = "text/plain;charset=UTF-8", method=RequestMethod.GET)
//	@ResponseBody	
//	public String list() {
//		List<Order> list = null;
//		try {
//			list = orderService.list();
//		} catch (Exception e) {
//			return Utils.makeJsonResult(e);
//		}
//
//		int num = 1;
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("count", new Integer(list.size()));
//		for (Order user : list) {
//			map.put("order_" + num, user);
//			num++;
//		}
//		return Utils.makeJsonResult(map);
//	}


	/*
	 * RestAPI
	 * 
	 * Order 추가
	 * 
	 * 입력 JSON { "item": "orang", "price" : 100, "qty": 5, "tn": 7 }
	 * 
	 * 출력 JSON
	 */

	@PostMapping(value = "/new", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String newOrder(@RequestBody String jsonStr) {
		String decodedString;
		try {
			decodedString = URLDecoder.decode(jsonStr, "UTF-8").replace("}=", "}");
		} catch (UnsupportedEncodingException e) {
			return Utils.makeJsonResult(e);
		}
		/*
		 * Order order = Order.makeByJsonStr(decodedString); if(order.ret!=null) { // 실패
		 * return order.ret; } int ret = this.orderService.newOrder(order); return
		 * Utils.makeJsonResult((ret==1) ? true : false, order.getNum());
		 */

		return this.orderService.newOrder(decodedString);
	}

	@PostMapping(value = "/update", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String updateOrder(@RequestBody String jsonStr) {
		String decodedString;
		try {
			decodedString = URLDecoder.decode(jsonStr, "UTF-8").replace("}=", "}");
		} catch (UnsupportedEncodingException e) {
			return Utils.makeJsonResult(e);
		}
		return this.orderService.updateOrder(decodedString);
	}

	@PostMapping(value = "/reupdate", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String reUpdate(@RequestBody String jsonStr) {
		String decodedString;
		try {
			decodedString = URLDecoder.decode(jsonStr, "UTF-8").replace("}=", "}");
		} catch (UnsupportedEncodingException e) {
			return Utils.makeJsonResult(e);
		}
		return this.orderService.reUpdate(decodedString);
	}

	@PostMapping(value = "/redelete", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String reDelete(@RequestBody String jsonStr) {
		String decodedString;
		try {
			decodedString = URLDecoder.decode(jsonStr, "UTF-8").replace("}=", "}");
		} catch (UnsupportedEncodingException e) {
			return Utils.makeJsonResult(e);
		}
		return this.orderService.reDelete(decodedString);
	}

	@PostMapping(value = "/get_updatenum", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getUpdateNum(@RequestBody String jsonStr) {
		String decodedString;
		try {
			decodedString = URLDecoder.decode(jsonStr, "UTF-8").replace("}=", "}");
		} catch (UnsupportedEncodingException e) {
			return Utils.makeJsonResult(e);
		}
		return this.orderService.getUpdateNum(decodedString);
	}

	@PostMapping(value = "/delete", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String deleteOrder(@RequestBody String jsonStr) {
		String decodedString;
		try {
			decodedString = URLDecoder.decode(jsonStr, "UTF-8").replace("}=", "}");
		} catch (UnsupportedEncodingException e) {
			return Utils.makeJsonResult(e);
		}
		return this.orderService.deleteOrder(decodedString);
	}

	@RequestMapping("/odrdone/{num}")
	public ModelAndView orderDone(@PathVariable("num") int num) {
		Order order = new Order();
		order.setNum(num);
		List<Order> orders = this.orderService.getOrder(order);
		if (orders.size() > 0) {
			order = orders.get(0);
			ModelAndView mav = new ModelAndView("odrdone");
			mav.addObject("order", order);
			return mav;
		}
		return null;
	}

	@RequestMapping("/updatedone/{num}")
	public ModelAndView updateDone(@PathVariable("num") int num) {
		Order order = new Order();
		order.setNum(num);
		List<Order> orders = this.orderService.getOrder(order);
		if (orders.size() > 0) {
			order = orders.get(0);
			ModelAndView mav = new ModelAndView("updatedone");
			mav.addObject("order", order);
			return mav;
		}
		return null;
	}

	@RequestMapping("/deletedone/{num}")
	public ModelAndView deleteDone(@PathVariable("num") int num) {
		Order order = new Order();
		order.setNum(num);
		List<Order> orders = this.orderService.getOrder(order);
		if (orders.size() > 0) {
			order = orders.get(0);
			ModelAndView mav = new ModelAndView("deletedone");
			mav.addObject("order", order);
			return mav;
		}
		return null;
	}

	@RequestMapping("/reupdate/{num}")
	public ModelAndView reUpdate(@PathVariable("num") int num) {
		Order order = new Order();
		order.setNum(num);
		List<Order> orders = this.orderService.getOrder(order);
		if (orders.size() > 0) {
			order = orders.get(0);
			ModelAndView mav = new ModelAndView("reupdate");
			mav.addObject("order", order);
			return mav;
		}
		return null;
	}

	@RequestMapping("/redelete/{num}")
	public ModelAndView reDelete(@PathVariable("num") int num) {
		Order order = new Order();
		order.setNum(num);
		List<Order> orders = this.orderService.getOrder(order);
		if (orders.size() > 0) {
			order = orders.get(0);
			ModelAndView mav = new ModelAndView("redelete");
			mav.addObject("order", order);
			return mav;
		}
		return null;
	}

	@RequestMapping("/updateodr/{num}")
	public ModelAndView updateOrder(@PathVariable("num") int num) {
		Order order = new Order();
		order.setNum(num);
		List<Order> orders = this.orderService.getOrder(order);
		if (orders.size() > 0) {
			order = orders.get(0);
			ModelAndView mav = new ModelAndView("updateodr");
			mav.addObject("order", order);
			return mav;
		}
		return null;
	}
}
