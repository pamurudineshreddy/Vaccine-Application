package com.tap.vaccine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tap.vaccine.entity.FamilyMemberEntity;
import com.tap.vaccine.service.AddMemberService;
import com.tap.vaccine.service.ViewAllMembersService;


@Controller
public class AddMemberController {
	
	
	@Autowired
	AddMemberService addMemberService;
	
	@Autowired
	ViewAllMembersService viewAllMembersService;

	@RequestMapping(value="/addmember")
	public String returnAddmemberPage() {
		
		return "/WEB-INF/AddMember.jsp";
		
	}

	@RequestMapping(value="/addfamilymember")
	public String addMemberPage( @RequestParam String name,@RequestParam String gender,@RequestParam String dateofbirth,
			@RequestParam String govtid,@RequestParam String idtext,@RequestParam long mobilenumber,
			@RequestParam String vaccine,@RequestParam String dose, Model model
			) {
		System.out.println(name + " "+gender + " "+dateofbirth + " "+govtid + " "+idtext + " "+mobilenumber + " "+vaccine + " "+ dose );
		
		
		FamilyMemberEntity familyMemberEntity = new FamilyMemberEntity(name, gender, dateofbirth, govtid, idtext, mobilenumber, vaccine, dose);
		
		
		boolean insertData = addMemberService.insertData(familyMemberEntity);
		
		if (insertData) {
			model.addAttribute("saved", "Family Member Added Successfully");
			
		} else {
			
			model.addAttribute("saved", "Something Went Wrong Please try again");

		}
		
		
		return "/WEB-INF/AddMember.jsp";
	}
	
	@RequestMapping(value = "/allmembers")
	public String allMemebrs(Model model) {
		
		
		List<FamilyMemberEntity> allData = viewAllMembersService.getAllData();
		
		if (allData!=null) {
			
			model.addAttribute("familydata", allData);
			
			
		} else {
			
			model.addAttribute("nofamilydata", "No Family Data Available");
			

		}
		
		
		return "/WEB-INF/AddMember.jsp";
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
