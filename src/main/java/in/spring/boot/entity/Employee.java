package in.spring.boot.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "EMPLOYEE_DTLS")
public class Employee {

	@Id
	@Column(name = "EMP_ID")
	@GeneratedValue
	private Integer employeeId;
	@Column(name = "EMP_NAME")
	private String employeeName;
	@Column(name = "EMP_Email")
	private String employeeEmail;
	@Column(name = "employee_Number")
	private Long employeeNumber;
	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private LocalDate createdDate;
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	
}
