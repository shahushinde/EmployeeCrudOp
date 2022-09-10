package com.employeecrudop.controller;

import com.employeecrudop.CacheManager;
import com.employeecrudop.Repository.Repository;
import com.employeecrudop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {
// This is the controller which handles the all rest api related to employee
   @Autowired
    CacheManager cacheManager;
    @Autowired
    private Repository repository;

    @GetMapping("/getMsg")
    public String getMessage(){
        return "Hello World";
    }

    @GetMapping ("/emp/{name}")
    public String Greet(@PathVariable String name){
        // This is a real time greeting function
        String greetings;
        Calendar today=Calendar.getInstance();
        int time=today.get(Calendar.HOUR_OF_DAY);
        if(time >= 0 && time < 12){
            greetings="Good Morning "+ name;
        } else if (time >= 12 && time < 18) {
           greetings="Good Afternoon "+ name;
        }else{
           greetings="Good Evening "+ name;
        }
         return greetings;
        }


    @PostMapping("/addEmp")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return repository.save(employee);
    }

    @GetMapping("/getAll")
    public String getAll(){
       return cacheManager.cashe.values().toString();
    }

    @GetMapping("/getWithId/{empId}")
    public Employee getbyId(@PathVariable int empId){
        return cacheManager.cashe.get(empId);
    }

    @PutMapping("/update/{empId}")
    public String updateEmp(@PathVariable int empId,@RequestBody Employee employee){
       Optional<Employee> employee1= repository.findById(empId);
       if(employee1.isPresent()){
           return repository.save(employee).toString();
       }else{
           return "For empId "+empId+" no Employee Present";
       }
    }

    @DeleteMapping("/deleteById/{empId}")
    public ResponseEntity<String> deleteById (@PathVariable int empId){
        Optional<Employee> employee1= repository.findById(empId);
        String msg = null;
        if(employee1.isPresent()){
             repository.deleteById(empId);
             msg="Employee Deleted Successfully";
        }else{
           msg= "For empId "+empId+" no Employee Present";
        }
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
}
