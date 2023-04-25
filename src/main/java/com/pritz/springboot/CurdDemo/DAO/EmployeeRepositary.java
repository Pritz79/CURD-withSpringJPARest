package com.pritz.springboot.CurdDemo.DAO;

import com.pritz.springboot.CurdDemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepositary  extends JpaRepository<Employee,Integer> {


}
