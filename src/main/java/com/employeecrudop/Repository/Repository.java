package com.employeecrudop.Repository;

import com.employeecrudop.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Repository extends JpaRepository<Employee,Integer> {
}
