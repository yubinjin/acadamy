package com.care.dbQuiz.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	@GetMapping("ex1")
	public String ex1Get() {
		return "ajax/ex1";
	}
	
	@ResponseBody
	@PostMapping("ex1")
	public String ex1Post() {
		System.out.println("클라이언트가 요청함");
		return "server data!!!!!!!!";
	}
}














