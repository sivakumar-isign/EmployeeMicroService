package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	
	  @Query("SELECT e FROM Employee e WHERE e.deptId = :deptId")
	    List<Employee> findByDeptId(@Param("deptId") Long deptId);
	 
	 

	    @Query("DELETE FROM Employee e WHERE e.deptId = :deptId")
	    void deleteByDeptId(@Param("deptId") Long deptId);
}
