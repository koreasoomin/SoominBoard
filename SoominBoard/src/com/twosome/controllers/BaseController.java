package com.twosome.controllers;

public class BaseController {

	BaseController() {
		InitializeServletConfig();
	}
	
	private void InitializeServletConfig() {
		System.out.println("BaseController InitializeServletConfig()");
	}
}
