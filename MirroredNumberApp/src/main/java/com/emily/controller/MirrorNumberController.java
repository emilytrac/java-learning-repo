package com.emily.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.emily.model.service.MirrorNumberService;

@Controller
public class MirrorNumberController {
	
	@Autowired
	MirrorNumberService mirrorNumberService;
	
	@RequestMapping("/")
	public ModelAndView mainPageController() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/calculate")
	public ModelAndView isMirroredNumberController(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		int num = Integer.parseInt(request.getParameter("number"));
		
		boolean mirroredNum = mirrorNumberService.IsMirrorNumber(num);
		
		modelAndView.addObject("mirr", mirroredNum);
		
		modelAndView.setViewName("output");
		
		return modelAndView;
	}
	

}
