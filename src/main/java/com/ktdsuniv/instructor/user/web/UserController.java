package com.ktdsuniv.instructor.user.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.instructor.user.service.UserService;

import user.schema.UsersSchema;

@Controller
public class UserController {
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/test")
	public String test(){
		return "/test";
	}
	
	@RequestMapping("/instructorSignIn")
	public ModelAndView viewSignInPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("instructorSignIn");
		return view;
	}
	
	@RequestMapping("/instructorDoSignIn")
	public String doSignInAction(UsersSchema user, HttpSession session) {
		userService.instructorSignIn(user, session);
		return "redirect:/main";
	}
	
	@RequestMapping("/instructorSignOut")
	public String doSignOutAction(HttpSession session) {
		session.invalidate();
		return "redirect:/instructorSignIn";
	}

}
