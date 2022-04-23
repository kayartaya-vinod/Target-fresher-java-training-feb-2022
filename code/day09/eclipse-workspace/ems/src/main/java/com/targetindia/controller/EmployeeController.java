package com.targetindia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.targetindia.dao.DaoException;
import com.targetindia.dao.EmployeeDao;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao dao;
	
	
	@RequestMapping("/all-employees")
	public String getAllEmployees(Model model) throws DaoException {
		// store the model data in a common storage location (scope), so that
		// JSP (any view) may have access to the same
		model.addAttribute("employees", dao.findAll());
		// forward to the view (templating engine)
		return "show-employees"; // just a view-name; should be resolved to a physical view path, which is /WEB-INF/views/show-employees.jsp
	}
	
	@RequestMapping("/view-details")
	public String getEmployeeDetails(@RequestParam Integer id, Model model) throws DaoException {
		model.addAttribute("emp", dao.findById(id));
		return "employee-details"; //  in /WEB-INF/views/employee-details.jsp
	}
	
	@RequestMapping("/delete-employee")
	public String deleteEmployee(@RequestParam Integer id)throws DaoException {
		dao.delete(id);
		return "redirect:all-employees"; // this time, view resolver sends a redirect notice to the browser to visit "/all-employees"
	}
}
