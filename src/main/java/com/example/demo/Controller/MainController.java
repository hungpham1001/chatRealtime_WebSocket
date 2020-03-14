package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping(path = "/")
	public String index(HttpServletRequest request, Model model) {
		String userName = (String) request.getSession().getAttribute("username");
		if(userName==null) {
			return "redirect:/login";
		}
		model.addAttribute("username", userName);
		return "chatRoomClient";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String Login(HttpServletRequest request,@RequestParam("username") String userName) {
		String user = userName.trim();
		if(user.isEmpty()) {
			return "login";
		}
		request.getSession().setAttribute("username", user);
		return "redirect:/";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("username");
		request.getSession(true).invalidate();
		return "/login";
	}
}
