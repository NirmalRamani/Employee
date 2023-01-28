package in.spring.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.spring.boot.binding.EmployeeForm;
import in.spring.boot.entity.Employee;
import in.spring.boot.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	
	@Override
	public String saveEmployee(EmployeeForm form)
	{
	
		Employee entity=new Employee();
		
		BeanUtils.copyProperties(form, entity);
		
		
		entity=empRepo.save(entity);
		
		if(entity.getEmployeeId()!=null)
		{
			return "Employee Saved";
		}
			
	return "Employee Not Saved";
	}

	@Override
	public List<EmployeeForm> viewEmployee() {
		// TODO Auto-generated method stub
		ArrayList<EmployeeForm> dataList = new ArrayList<>();
		List<Employee> findAll = empRepo.findAll();
		
		
		for(Employee entity:findAll)
		{
			EmployeeForm form=new EmployeeForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}

	@Override
	public EmployeeForm editEmployeeForm(Integer employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> findById = empRepo.findById(employeeId);
		if(findById.isPresent())
		{
			Employee entity = findById.get();
			EmployeeForm form=new EmployeeForm();
			BeanUtils.copyProperties(entity, form);
			return form;
		}
		return null;
	}

	@Override
	public String deleteEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		if(empRepo.getById(employeeId)!=null)
		{
			empRepo.deleteById(employeeId);
			return "User deleted successfully";
		}
		
		return "User not found";
		
		
	}

}
