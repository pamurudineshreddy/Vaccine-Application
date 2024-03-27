package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.dao.RegisterDAOImpl;
import com.tap.vaccine.entity.RegisterEntity;
import com.tap.vaccine.service.RegisterService;

@Controller
public class RegisterController {
	
	
	
	@Autowired
	RegisterService registerService;
	@Autowired
	RegisterDAOImpl registerDAOImpl;
	
	
	public RegisterController() {
		System.out.println(this.getClass().getSimpleName()+ " Created");
	}

	@RequestMapping(value="/registerpage")
	public String returnRegisterPage() {
		return "/WEB-INF/Register.jsp";

	}
	
	@RequestMapping(value="/registerdetails")
	public String registerPage(@RequestParam String username,@RequestParam String password,@RequestParam String confirmpassword,
			@RequestParam long mobilenumber,@RequestParam String gender,@RequestParam String dateofbirth, Model model) {
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(confirmpassword);
		System.out.println(mobilenumber);
		System.out.println(gender);
		System.out.println(dateofbirth);
		
		
		boolean validateRegisterData = registerService.validateRegisterData(username, password, mobilenumber, dateofbirth, gender);
		
		
		if(validateRegisterData) {
			
			
			
			if(password.equals(confirmpassword)) {
				
				RegisterEntity registerEntity = new RegisterEntity(username, username, password, mobilenumber, dateofbirth, gender);
				boolean saveRegisterEntity = registerDAOImpl.saveRegisterEntity(registerEntity);
				
				
				if (saveRegisterEntity) {
					
					model.addAttribute("savedmessage", "saved successfully" );
					
				} else {
					model.addAttribute("savedmessage", " Something went wrong Please try again" );

				}
				
			}
			else {
				model.addAttribute("passwordsmessage", "Passwords dont match");
				
			}
		}
		else {
			model.addAttribute("validatemessage", "Please Enter All details");
		}
		
		
		
		return "/WEB-INF/Register.jsp";

	}

}
