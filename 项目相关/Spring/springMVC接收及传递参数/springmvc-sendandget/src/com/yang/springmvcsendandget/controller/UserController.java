package com.yang.springmvcsendandget.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yang.springmvcsendandget.model.User;

@Controller
public class UserController {
	
	/**
	 * 使用request传值
	 * @param request spring会自动获取并注入页面的HttpServletRequest
	 * @return	跳转的view的名称
	 */
	@RequestMapping("/useRequest")
	public String useRequest(HttpServletRequest request){
		
		request.setAttribute("theValue", "Hello request");
		
		return "requestResult";
		
	}
	
	/**
	 * 使用ModelAndView传值
	 * @param mav ModelAndView对象，spring会自动注入该对象
	 * @param user User对象，spring会根据request中的参数自动加载User对象
	 * @return 一个ModelAndView对象
	 */
	@RequestMapping("/useModelAndView")
	public ModelAndView userModelAndView(ModelAndView mav, User user){
		mav.addObject("user", user);
		mav.setViewName("modelAndViewResult");
		
		return mav;
	}
	
	/**
	 * 使用ModelMap传值
	 * @param modelMap ModelMap对象，spring会自动注入该对象
	 * @return 跳转的view的名称
	 */
	@RequestMapping("/useModelMap")
	public String useModelMap(ModelMap modelMap){
		
		modelMap.addAttribute("warning", "Time is merciless!");
		
		return "modelMapResult";
	}
	
	/**
	 * 使用Session传值
	 * @param request spring会自动获取并注入页面的HttpServletRequest
	 * @return 跳转的view的名称
	 */
	@RequestMapping("/useSession")
	public String useSession(HttpServletRequest request){
		
		
		HttpSession session = request.getSession();
		session.setAttribute("markedWords","Do not waste your time!");
		
		return "sessionResult";
		
	}
}
