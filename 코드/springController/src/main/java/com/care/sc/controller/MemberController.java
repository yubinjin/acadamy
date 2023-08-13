package com.care.sc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.sc.dto.LoginDTO;
import com.care.sc.dto.RegisterDTO;
import com.care.sc.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("index")
	public String index() {
		//디비 조회 후 
		// model 속성에 데이터 담아 JSP에 가서 출력
		return "index";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("login")
	public String login(LoginDTO login, Model model) {
		String msg = service.login(login);
		model.addAttribute("msg", msg);
		if("로그인 성공".equals(msg)) {
			return "index";
			
//			return "forward:index";
//			return "redirect:index";
			/*
			 * return "index";
			 viewResolver에게 "index" 문자열이 전달되어서
			 /WEB-INF/views/index.jsp 경로를 완성 후 찾아가서 실행하여 
			 클라이언트(웹브라우저)에게 전달함.
			 
			 return "forward:index";
			 @GetMapping("index") 찾아가서 메서드 실행
			 
			 return "redirect:index";
			 웹브라우저에게 index 라는 경로를 제공하고,
			 웹브라우저가 직접  @GetMapping("index") 찾아가서 메서드 실행
			 
			 */
		}
		return "login";
	}	
	
	@GetMapping("register")
	public void register() {}
	
	@PostMapping("register")
	public String register(RegisterDTO reg, Model model) {
		String msg = service.register(reg);
		model.addAttribute("msg", msg);
		if("회원 가입 성공".equals(msg))
			return "index";
		return "register";
		// 회원 가입 성공은 index
		// 회원 가입 실패는 register
		
//		System.out.println("아이디 : " + reg.getId());
//		System.out.println("비밀번호 : " + reg.getPw());
//		System.out.println("이름 : " + reg.getName());
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("members", service.list());
		return "list";
	}
	
	@Autowired HttpSession session;
	
	@GetMapping("update")
	public String update() {
		String id = (String)session.getAttribute("id");
		if(id == null) {
			return "login";
		}
		return "update";
	}
	
	@PostMapping("update")
	public String update(RegisterDTO reg, Model model) {
		String id = (String)session.getAttribute("id");
		if(id == null) {
			return "login";
		}
		
		reg.setId(id);
		String msg = service.update(reg);
		model.addAttribute("msg", msg);
		if("회원 수정 성공".equals(msg)) {
			if(reg.getName().isEmpty() == false)
				session.setAttribute("name", reg.getName());
			return "index";
		}
		return "update";
	}
	@GetMapping("delete")
	public String delete() {
		String id = (String)session.getAttribute("id");
		if(id == null) {
			return "login";
		}
		return "delete";
	}
	
	@PostMapping("delete")
	public String delete(String pw, String confirm, Model model) {
		String id = (String)session.getAttribute("id");
		if(id == null) {
			return "login";
		}
		
		String msg = service.delete(pw, confirm);
		model.addAttribute("msg", msg);
		if("회원 삭제 성공".equals(msg)) {
			
			return "forward:logout";
		}
		return "delete";
	}
	
	@RequestMapping("logout")
	public String logout() {
		session.invalidate();
		return "redirect:index";
	}
//	@PostMapping("login")
//	public void login(String id, String pw) {
//		System.out.println("아이디 : " + id);
//		System.out.println("비밀번호 : " + pw);
//	}
	
//	@PostMapping("login")
//	public void login(String id,
//			@RequestParam("pw") String pass) {
//		System.out.println("아이디 : " + id);
//		System.out.println("비밀번호 : " + pass);
//	}
	
//	@PostMapping("login")
//	public void login(HttpServletRequest request) {
//		System.out.println("아이디 : " + request.getParameter("id"));
//		System.out.println("비밀번호 : " + request.getParameter("pw"));
//	}
//	@PostMapping("login")
//	public void login(LoginDTO login, String id) {
//		System.out.println("아이디 : " + login.getId());
//		System.out.println("아이디 : " + id);
//		System.out.println("비밀번호 : " + login.getPw());
//	}	
	
	
	/*
	// index 요청 시 요청메서드가 get 또는 post 모두 index() 호출 
	@RequestMapping(value = "index")
	public void index() {}
	
	// index 요청 시 요청메서드가 get이면 index() 호출 
	@RequestMapping(value = "index", method=RequestMethod.GET)
	public void requestGetIndex() {}
	
	// index 요청 시 요청메서드가 post이면 index() 호출 
	@RequestMapping(value = "index", method=RequestMethod.POST)
	public void requestPostIndex() {}
	
	@GetMapping("index")
	public void getIndex() {}
	
	@PostMapping("index")
	public void postIndex() {}
	*/
}
