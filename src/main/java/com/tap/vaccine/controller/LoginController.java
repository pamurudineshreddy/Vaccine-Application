package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.dao.LoginDAOImpl;
import com.tap.vaccine.entity.RegisterEntity;
import com.tap.vaccine.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private  LoginService loginService;
	@Autowired
	private LoginDAOImpl loginDAOImpl;
	
	 final  static int loginCount =4;
	
	@RequestMapping(value="/loginpage")
	public String loginPage( @RequestParam String email,@RequestParam String password,Model model) {
		
		boolean validateLoginDetails = loginService.validateLoginDetails(email,password);
		
		
		if(validateLoginDetails ) {
			RegisterEntity registerEntityByEmail = loginDAOImpl.getRegisterEntityByEmail(email);
			
			if(registerEntityByEmail!=null) {
				
				if(registerEntityByEmail.getLoginAttempts()<loginCount) {
					
					boolean verifyLoginDetails = loginService.verifyLoginDetails(email,password);
					
					if(verifyLoginDetails) {
						model.addAttribute("login", email);
						
						return "/WEB-INF/HomePage.jsp";  
					}else {
						boolean updateLoginCount = loginDAOImpl.updateLoginCount(email);
						int loginAttempts = loginDAOImpl.getRegisterEntityByEmail(email).getLoginAttempts();
						int c = loginCount-loginAttempts;
						
						model.addAttribute("login", "User name or password incorrect "+ c+" attempts left");
						
					}
				}else {
					model.addAttribute("accblock","Account Blocked ! Please reset yout password");
				}
				
			}else {
				model.addAttribute("unregistered", "Account Doesn't exist  please Sign-up ");
			}
			
		}else {
			model.addAttribute(password, model);
			
		}
	
		return "/index.jsp";
	}

}
