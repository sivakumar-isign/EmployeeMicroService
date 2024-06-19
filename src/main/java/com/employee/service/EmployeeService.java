package com.employee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.department.model.Department;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService { 
	
	   @Autowired
	    private EmployeeRepository employeeRepository;

	    @Autowired
	    private RestTemplate restTemplate;

	    
	    // CRUD operations
	    public Employee saveEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    public Employee getEmployeeById(Long id) {
	        return employeeRepository.findById(id).orElse(null);
	    }
	    
	    public void deleteEmployee(Long id) {
	    	employeeRepository.deleteById(id);
	    }

	    
	    //deleted(by using dept id we should deleted all employees)
	    
	    public List<Employee> getEmployeesByDeptId(Long deptId) {
	        return employeeRepository.findByDeptId(deptId);
	    }

       //get employee id(get employee details) and department id (get department details )
	    public void deleteEmployeesByDeptId(Long deptId) {
	        employeeRepository.deleteByDeptId(deptId);
	    }

	    //getempid (get employee +department details)
	    public Map<String, Object> getEmployeeWithDepartment(Long employeeId) {
	        Employee employee = getEmployeeById(employeeId);
	        if (employee == null) return null;

	        Department department = restTemplate.getForObject("http://localhost:8081/departments/" + employee.getDeptId(), Department.class);

	        Map<String, Object> response = new HashMap<>();
	        response.put("employee", employee);
	        response.put("department", department);

	        return response;
	    }

	    
	    //findAll(get employees + correspond department details)
	    public List<Map<String, Object>> getAllEmployeesWithDepartments() {
	        List<Employee> employees = getAllEmployees();
	        List<Map<String, Object>> response = new ArrayList<>();

	        for (Employee employee : employees) {
	            Department department = restTemplate.getForObject("http://localhost:8081/departments/" + employee.getDeptId(), Department.class);

	            Map<String, Object> map = new HashMap<>();
	            map.put("employee", employee);
	            map.put("department", department);

	            response.add(map);
	        }

	        return response;
	    }

	    
	    // if deptid (dept details + employees details)
	    public Map<String, Object> getEmployeesByDeptWithDepartment(Long deptId) {
	        List<Employee> employees = getEmployeesByDeptId(deptId);
	        Department department = restTemplate.getForObject("http://localhost:8081/departments/" + deptId, Department.class);

	        Map<String, Object> response = new HashMap<>();
	        response.put("department", department);
	        response.put("employees", employees);

	        return response;
	    }

}
