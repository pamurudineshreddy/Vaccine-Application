package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.dao.LoginDAOImpl;
import com.tap.vaccine.dao.NewPasswordDAOImpl;
import com.tap.vaccine.entity.RegisterEntity;
import com.tap.vaccine.service.ForgotPasswordService;


@Controller
public class ForgotPasswordController {
	
	@Autowired
	LoginDAOImpl loginDAOImpl;
	@Autowired
	ForgotPasswordService forgotPasswordService;
	@Autowired
	NewPasswordDAOImpl newPasswordDAOImpl;
	
	@RequestMapping(value="/forgotpassword")
	public String password() {
		
		 
		return "/WEB-INF/ForgotPassword.jsp";
		
	}
	
	@RequestMapping(value = "/sendotp")
	public String sendEmail(@RequestParam String email,Model model) {
		System.out.println(email);
		
		RegisterEntity registerEntityByEmail = loginDAOImpl.getRegisterEntityByEmail(email);
		if(registerEntityByEmail!=null) {
			
			
			boolean newPassword = forgotPasswordService.newPassword(email);
			
			if (newPassword) {
				model.addAttribute("validmail", email);
				model.addAttribute("sentotp", "Successfully otp sent");
				
				
				return "/WEB-INF/OtpValidation.jsp";
				
			} else {
				model.addAttribute("validmail", "Something went wrong please try again");

			}
			
		}
		else {
			model.addAttribute("notvalidmail", "Please enter valid mail or Register Now");
			
		}
		
		return "/WEB-INF/ForgotPassword.jsp";
		
	}
	
	@RequestMapping(value="/newpassword")
	public String sendOtp( @RequestParam String email, @RequestParam int otp,@RequestParam String password,@RequestParam String confirmpassword,Model model) {
		
		int otpReturn = newPasswordDAOImpl.otpReturn();
		
		System.out.println(otp+" "+password+" "+ confirmpassword);
		
		System.out.println(otpReturn);
		
		
		
		
		if(otpReturn==otp) {
			if(password.equals(confirmpassword)) {
				
				
				boolean updatePassword = forgotPasswordService.updatePassword(email,password);
				
				if (updatePassword) {
					model.addAttribute("otpconfirmation", "Password changed Successfully");
					
				} else {
					model.addAttribute("otpconfirmation", "something went wrong Please try again !");

				}
				
				
				
				
				
			}else {
				model.addAttribute("otpconfirmation", "otp is correct but password is wrong");
			}
			
		}
		else {
			
			model.addAttribute("otpconfirmation", "Incorrect OTP please Try Again");
			
		}
		
		return "/WEB-INF/OtpValidation.jsp";
		
		
	}

}
