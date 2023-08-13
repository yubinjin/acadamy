package com.care.cs.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SessionController {
	//http://localhost:8085/cs/session/index
	@RequestMapping("session/index")
	public void index() {}
	
	@GetMapping("session/login")
	public void login() {}
	
	@Autowired private HttpSession session;
	
	@PostMapping("session/login")
	public String login(String id, String pw, RedirectAttributes ra) {
		if("admin".equals(id) && "1234".equals(pw)) {
			ra.addFlashAttribute("msg", "로그인 성공");
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			return "redirect:index";
		}
		ra.addFlashAttribute("msg", "로그인 실패");
		return "redirect:login";
	}
	@RequestMapping("session/logout")
	public String logout(Model model, HttpServletRequest request) {
		session.invalidate();
		model.addAttribute("msg", "로그 아웃");
		String context = request.getContextPath();
		model.addAttribute("redirectPath", context + "/session/index");
		return "session/logout";
	}
}












