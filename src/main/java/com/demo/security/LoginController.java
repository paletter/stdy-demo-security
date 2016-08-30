package com.demo.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value="/welcome.do")
	public String welcome() {
		return "/welcome";
	}
	
	@RequestMapping(value="/success.do")
	public String success() {
		return "/success";
	}
	
	@RequestMapping(value="/intercept.do")
	public String intercept() {
		return "/intercept";
	}
	
	@RequestMapping(value="/login.do")
	public String login() {
		return "/login";
	}
	
	@RequestMapping(value="/loginFail.do")
	public String loginFail() {
		return "/loginFail";
	}
	
	@RequestMapping(value="/loginSuccess.do")
	public String loginSuccess() {
		return "/loginSuccess";
	}
	
	@RequestMapping(value="/admin.do")
	public String admin() {
		return "/admin";
	}
}
