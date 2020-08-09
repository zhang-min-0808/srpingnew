package com.abc.servie;

import com.abc.dao.EmployeeDao;
import com.abc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public int insert(Employee employee){
        return employeeDao.insert(employee);
    }

    public int hasExists(String name){
        return employeeDao.hasExists(name);
    }

    public Employee find(String name,String password){
        return employeeDao.find(name,password);
    }
}
