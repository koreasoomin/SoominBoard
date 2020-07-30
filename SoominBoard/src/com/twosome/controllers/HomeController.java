package com.twosome.controllers;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.org.slf4j.internal.LoggerFactory;


@Controller
public class HomeController extends BaseController {
	
	private static final com.sun.org.slf4j.internal.Logger logger = LoggerFactory.getLogger(OrderController.class);


	HomeController() {
		super();
	}
	
	//home.jsp로 이동 
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "home";
	}
		
	@RequestMapping(value = "/neworder", method=RequestMethod.GET)
	public String newOrder() {
		return "neworder";
	}
	
	@RequestMapping(value = "/updateodr", method=RequestMethod.GET)
	public String updateOdr() {
		return "updateodr";
	}
	
	@RequestMapping(value = "/deleteodr", method=RequestMethod.GET)
	public String deleteOdr() {
		return "deleteodr";
	}

	@RequestMapping(value = "/updatedone", method=RequestMethod.GET)
	public String updateDone() {
		return "updatedone";
	}

//	@RequestMapping(value = "/reupdate", method=RequestMethod.GET)
//	public String reUpdate() {
//		return "reupdate";
//	}
	
	@RequestMapping(value = "/deletedone", method=RequestMethod.GET)
	public String deleteDone() {
		return "deletedone";
	}
	
	@RequestMapping(value = "/listorder", method=RequestMethod.GET)
	public String getOrder() {
		return "listorder";
	}
	
	@RequestMapping(value = "/get_updatenum", method=RequestMethod.GET)
	public String getUpdateNum() {
		return "get_updatenum";
	}
	
	

}
