package in.spring.boot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.spring.boot.binding.EmployeeForm;
import in.spring.boot.service.EmployeeService;

@RestController
public class ContactRestController {

	@Autowired
	private EmployeeService service;
	@PostMapping("/save")
	public String saveEmployee(@RequestBody EmployeeForm form)
	{
		System.out.println(form);
		String status = service.saveEmployee(form);
		return status;
	}
	
	@GetMapping("/getdetails")
	public List<EmployeeForm> viewAllEmployees()
	{
		return service.viewEmployee();
	}
	
	@GetMapping("/edit/{employeeId}")
	public EmployeeForm editEmployee(@PathVariable Integer employeeId)
	{
		return service.editEmployeeForm(employeeId);
	}
	
	@GetMapping("/delete/{employeeId}")
	public String delEmployee(@PathVariable Integer employeeId)
	{
		return service.deleteEmployee(employeeId);
	}
}
