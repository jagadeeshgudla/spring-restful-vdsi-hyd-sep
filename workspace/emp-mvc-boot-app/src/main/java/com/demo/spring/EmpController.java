package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@Controller
public class EmpController {

	@Autowired
	EmpRepository repo;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getMainPage() {
		return "main";
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String getAddPage(Model model) {
		Emp emp1 = new Emp();
		model.addAttribute("emp", emp1);
		return "addEmp";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ModelAndView addEmp(@ModelAttribute("emp") Emp e) {
		ModelAndView mv = new ModelAndView();
		
		if (repo.existsById(e.getEmpid())) {
			mv.setViewName("failure");
			mv.addObject("status", "Employee Exists");
		} else {
			repo.save(e);
			mv.setViewName("success");
			mv.addObject("status", "Employee Added Successfully");
		}
		return mv;
	}

}
