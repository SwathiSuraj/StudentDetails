package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	
	@GetMapping("Customers")
	
	public String customerDetails() {
		return "Customers";
	}
	
	@PostMapping("/View")
	public String viewDetails(@RequestParam("id")String id,@RequestParam("name")String name,
			@RequestParam("email")String email, @RequestParam("place")String place,ModelMap model) {
		
		model.put("id",id);
		model.put("name", name);
		model.put("email", email);
		model.put("place", place);
		
		return "ViewCustomers";
	}
}
