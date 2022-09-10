package com.employeecrudop;

import com.employeecrudop.Repository.Repository;
import com.employeecrudop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class CacheManager {
    @Autowired
    Repository repository;

    public HashMap<Integer, Employee> cashe=new HashMap<>();
    @Scheduled(cron = "*/10 * * * * * ")
    public void LoadCache(){
        System.out.println("The Cache Loading Started");
        List<Employee> employeeList = repository.findAll();
        employeeList.forEach(employee -> cashe.put(employee.getEmpId(),employee));
        System.out.println("The Cache Loading Ended");
    }
}
