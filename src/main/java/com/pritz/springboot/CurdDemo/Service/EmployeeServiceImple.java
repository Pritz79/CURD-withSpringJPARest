package com.pritz.springboot.CurdDemo.Service;

import com.pritz.springboot.CurdDemo.DAO.EmployeeRepositary;
import com.pritz.springboot.CurdDemo.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImple implements EmployeeService{
    private EmployeeRepositary employeeRepositary;
    @Autowired
    public EmployeeServiceImple(EmployeeRepositary employeeRepositary) {
        this.employeeRepositary = employeeRepositary;
    }



    @Override
    public List<Employee> findAll() {
        return employeeRepositary.findAll();
    }

    @Override

    public Employee findById(int id) {
        Optional<Employee> result= employeeRepositary.findById(id);
        Employee theemployee = null;
        if(result.isPresent()){
            theemployee=result.get();
        }
        else{
            throw new RuntimeException("There is no emplyee of this id "+id);
        }
    return theemployee;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepositary.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepositary.deleteById(id);
    }


}
