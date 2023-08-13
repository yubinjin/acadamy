package com.care.cs.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	
	// http://localhost:8085/cs/cookie/index
	@RequestMapping("cookie/index")
	public String index(HttpServletResponse response) {
		Cookie cookie = new Cookie("cookieName", "쿠키값");
		response.addCookie(cookie);
		return "cookie/index";
	}
	
	//http://localhost:8085/cs/cookie/result
	@RequestMapping("cookie/result")
	public void result(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies) {
			System.out.println("쿠키 이름 : " + c.getName());
			System.out.println("쿠키 값 : " + c.getValue());
			System.out.println();
		}
	}
}







