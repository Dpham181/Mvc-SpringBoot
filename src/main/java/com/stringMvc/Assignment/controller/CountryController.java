package com.stringMvc.Assignment.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stringMvc.Assignment.model.Country;
import com.stringMvc.Assignment.services.Country_Service;


@Controller
public class CountryController {
	
	@Autowired
	Country_Service  CountryService;
	// home page 
	@RequestMapping("/")
	public String index(Model model) {
		
		//HashMap<String,String> des = new HashMap<String,String>();
		//des.put("title", "Basic Web MVC Spring Boot");
		//des.put("context", "The Web will use to display the detail of a contry!!");
		
		model.addAttribute("title", "Basic Web MVC Spring Boot");
		model.addAttribute("context", "The Web will use to display the detail of a contry!!");
		CountryService.showAll(); 
		model.addAttribute("ListofCountries", CountryService.showAll() );
		return "home";
	}
	// create page 
	
	@RequestMapping("/create")
	public String create(Model model) {
		
		model.addAttribute("title", "Add New Country");
		model.addAttribute("context", "New Country Form");
        model.addAttribute(new Country());
		return "form";
	}
	// save to db
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(@ModelAttribute("country") Country country) {
		CountryService.addNew(country);

		return "redirect:/";
	}
	
	// view  a record
		@RequestMapping(value="/view/{id}",method = RequestMethod.GET)
		public String view(@PathVariable(name="id") int id, Model model) {
			model.addAttribute("title", "View Country Details");
			model.addAttribute("context", "Country Details");
			model.addAttribute("country", CountryService.searchbyId(id));
			return "view";
		}
		
		// edit  a record
				@RequestMapping(value="/edit/{id}")
				public ModelAndView edit(@PathVariable(name="id") int id, Model model) {
					model.addAttribute("title", "Edit Country Details");
					model.addAttribute("context", "Edit Country Form");
					ModelAndView mav = new ModelAndView("form1");
					mav.addObject("country",CountryService.searchbyId(id));
					
					return mav;
				}
}
