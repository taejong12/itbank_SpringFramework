package com.test.pro09;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableTransactionManagement
public class AccountController {
	@Autowired
	AccountService service;
	
	@RequestMapping("select.do")
	public ModelAndView select(
			HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
		List<AccountDTO> accList = 
				service.selectAllBalance();
		mav.addObject("accList", accList);
		mav.setViewName("selectList");
		return mav;
	}
	
	@RequestMapping("/sendMoney.do")
	public ModelAndView sendMoney(
			HttpServletRequest request, 
			HttpServletResponse response) {
		service.sendMoney2();
		ModelAndView mav = new ModelAndView("result");
		return mav;
	}
	
	@RequestMapping("/receiveForm.do")
	public String receiveForm(
			HttpServletRequest request,
			HttpServletResponse response) {
		return "receiveForm";
	}	
	
	@RequestMapping("/receive.do")
	public ModelAndView receiveForm(
			@ModelAttribute AccountDTO dto,
			HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
//		service.deposit(dto);
		mav.setViewName("redirect:select.do");
		return mav;
	}	
}







