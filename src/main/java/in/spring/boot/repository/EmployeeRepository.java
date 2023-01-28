package in.spring.boot.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.spring.boot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Serializable>{

}
