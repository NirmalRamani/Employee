package in.spring.boot.service;

import java.util.List;

import in.spring.boot.binding.EmployeeForm;

public interface EmployeeService {

	public String saveEmployee(EmployeeForm form);
	
	public List<EmployeeForm> viewEmployee();
	
	public EmployeeForm editEmployeeForm(Integer employeeId);
	
	public String deleteEmployee(Integer employeeId);
}
