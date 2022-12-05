package com.emily.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.emily.entity.BankAccount;
import com.emily.model.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/")
	public ModelAndView loginPageController() {
		return new ModelAndView("LoginPage");
	}
	

	@RequestMapping("/login")
	public ModelAndView loginController(@RequestParam("accId") int accId, @RequestParam("password") String password, HttpSession session) {
		ModelAndView modelAndView=new ModelAndView();
		
		if(accountService.loginCheck(accId, password)) {
			BankAccount account = accountService.searchAccountById(accId); 
			session.setAttribute("user", account);  //data is set on session scope i.e data availble in multiple request and response cycles
			modelAndView.setViewName("index");
		} else {
			modelAndView.addObject("message", "Invalid User Credentials, Please try again");
			modelAndView.setViewName("LoginPage");
		}
			
		return modelAndView;
	}
	
	@RequestMapping("/inputForTransferPage")
	public ModelAndView incrementSalaryPageController() {
		return new ModelAndView("InputForTransfer");
	}

	@RequestMapping("/performTransaction")
//	public ModelAndView incrementSalaryController(HttpServletRequest request) {
	public ModelAndView incrementSalaryController(@RequestParam("accIdTo") int idTo, @RequestParam("increment") double incrementAmount, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		String message = null;
		BankAccount account = (BankAccount) session.getAttribute("user");
		int idFrom = account.getAccId();
		
		if (accountService.transferMoney(idFrom, idTo, incrementAmount)) {
			message = "Bank account with account number " + idTo + " credited with amount " + incrementAmount
			+ " account with number " + idFrom + " debited with amount " + incrementAmount;
		} else {
			message = "Something went wrong with the transaction, please try again!";
		}
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		return modelAndView;
	}

}
