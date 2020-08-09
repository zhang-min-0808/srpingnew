package com.abc.dao;

import com.abc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public int insert(Employee employee){
        String sql="insert into db_t_employee (name,password,email,role,phone,age) values(:name,:password,:email,:role,:phone,:age)";
        Map<String,Object> param=new HashMap<>();
        param.put("name",employee.getName());
        param.put("password",employee.getPassword());
        param.put("email",employee.getEmail());
        param.put("role",employee.getRole());
        param.put("phone",employee.getPhone());
        param.put("age",employee.getAge());
        return jdbcTemplate.update(sql,param);
    }

    public int hasExists(String name){
        String sql="select count(1) from db_T_employee where name=:name";
        Map<String,Object> param=new HashMap();
        param.put("name",name);
        return jdbcTemplate.queryForObject(sql,param,Integer.class);

    }
    public Employee find(String name,String password){
        String sql="select * from db_T_employee where name=:name and password=:password";
        Map<String,Object> param=new HashMap();
        param.put("name",name);
        param.put("password",password);
        try{
            return jdbcTemplate.queryForObject(sql, param, new RowMapper<Employee>() {
                @Override
                public Employee mapRow (ResultSet resultSet, int i) throws SQLException {
                    Employee employee=new Employee();
                    employee.setRole(resultSet.getString("role"));
                    employee.setPhone(resultSet.getString("phone"));
                    employee.setPassword(resultSet.getString("password"));
                    employee.setEmail(resultSet.getString("email"));
                    employee.setAge(resultSet.getString("age"));
                    employee.setName(resultSet.getString("name"));
                    return employee;
                }
            });
        }catch (Exception e){
            return null;
        }
    }
}
