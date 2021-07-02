package id.dicka.kubernetes.springdockerkubernetes.controller;

import id.dicka.kubernetes.springdockerkubernetes.exception.MessageException;
import id.dicka.kubernetes.springdockerkubernetes.model.Employee;
import id.dicka.kubernetes.springdockerkubernetes.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employee/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(value = "/save-employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee responseEmployeeSave = employeeRepository.save(employee);
        return new ResponseEntity<Employee>(responseEmployeeSave, HttpStatus.OK);
    }

    @GetMapping(value = "/list-employee")
    public ResponseEntity<List<Employee>> listEmployee(){
        List<Employee> employeeList = employeeRepository.findAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping(value = "/get-employee/{id}")
    public ResponseEntity<Employee> getEmployeeId(@PathVariable("id")Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new MessageException("sorry user id "+id+" not found"));
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


}
