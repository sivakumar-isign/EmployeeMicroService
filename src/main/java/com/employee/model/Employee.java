package com.employee.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employeservice")
public class Employee {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String firstName;
	    private String lastName;
	    private Long deptId;
	    private LocalDateTime createdDateTime;
	    private String createdByUsername;
	    private LocalDateTime updatedDateTime;
	    private String updatedByUsername;
	    
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Employee(Long id, String firstName, String lastName, Long deptId, LocalDateTime createdDateTime,
				String createdByUsername, LocalDateTime updatedDateTime, String updatedByUsername) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.deptId = deptId;
			this.createdDateTime = createdDateTime;
			this.createdByUsername = createdByUsername;
			this.updatedDateTime = updatedDateTime;
			this.updatedByUsername = updatedByUsername;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Long getDeptId() {
			return deptId;
		}

		public void setDeptId(Long deptId) {
			this.deptId = deptId;
		}

		public LocalDateTime getCreatedDateTime() {
			return createdDateTime;
		}

		public void setCreatedDateTime(LocalDateTime createdDateTime) {
			this.createdDateTime = createdDateTime;
		}

		public String getCreatedByUsername() {
			return createdByUsername;
		}

		public void setCreatedByUsername(String createdByUsername) {
			this.createdByUsername = createdByUsername;
		}

		public LocalDateTime getUpdatedDateTime() {
			return updatedDateTime;
		}

		public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
			this.updatedDateTime = updatedDateTime;
		}

		public String getUpdatedByUsername() {
			return updatedByUsername;
		}

		public void setUpdatedByUsername(String updatedByUsername) {
			this.updatedByUsername = updatedByUsername;
		}
	    
	    

}
