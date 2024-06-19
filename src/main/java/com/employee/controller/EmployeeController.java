package com.employee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	    @Autowired
	    private EmployeeService employeeService;

	    
	    @PostMapping
	    public Employee createEmployee(@RequestBody Employee employee) {
	        return employeeService.saveEmployee(employee);
	    }

	    
	    @GetMapping
	    public List<Employee> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }

	    
	    @GetMapping("/{id}")
	    public Employee getEmployeeById(@PathVariable Long id) {
	        return employeeService.getEmployeeById(id);
	    }
	    
	    
	    @DeleteMapping("/{id}")
	    public void deleteEmployee(@PathVariable Long id) {
	    	employeeService.deleteEmployee(id);
	    }

	    
	    //working
	    @GetMapping("/department/{deptId}")
	    public List<Employee> getEmployeesByDeptId(@PathVariable Long deptId) {
	        return employeeService.getEmployeesByDeptId(deptId);
	    }

	    

	    
	    // Not Working
	    @DeleteMapping("/department/{deptId}")
	    public void deleteEmployeesByDeptId(@PathVariable Long deptId) {
	        employeeService.deleteEmployeesByDeptId(deptId);
	    }
	    

	    //working
	    @GetMapping("/details/{id}")  
	    public Map<String, Object> getEmployeeWithDepartment(@PathVariable Long id) {
	        return employeeService.getEmployeeWithDepartment(id);
	    }
	    

	    //working
	    @GetMapping("/all/details")
	    public List<Map<String, Object>> getAllEmployeesWithDepartments() {
	        return employeeService.getAllEmployeesWithDepartments();
	    }

	    
	    //not working
	    @GetMapping("/dept/details/{deptId}")
	    public Map<String, Object> getEmployeesByDeptWithDepartment(@PathVariable Long deptId) {
	        return employeeService.getEmployeesByDeptWithDepartment(deptId);
	    }

}
