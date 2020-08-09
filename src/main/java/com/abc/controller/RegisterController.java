package com.abc.controller;

import com.abc.entity.Employee;
import com.abc.servie.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("register")
    public ModelAndView register(HttpServletRequest request, ModelAndView mv){
        boolean success=false;
        if(request.getParameter("name")!=null && request.getParameter("password")!=null){
            if(employeeService.hasExists(request.getParameter("name"))>0){
                mv.addObject("error","user duplicate");
            }else{
                Employee employee=new Employee();
                employee.setName(request.getParameter("name"));
                employee.setAge(request.getParameter("age"));
                employee.setEmail(request.getParameter("email"));
                employee.setPassword(request.getParameter("password"));
                employee.setPhone(request.getParameter("phone"));
                employee.setRole(request.getParameter("role"));
                int result=employeeService.insert(employee);
                success=result>0;
            }
        }
        mv.setViewName(success?"login":"register");
        return mv;

    }

    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, ModelAndView mv, HttpSession session){
        String username=request.getParameter("name");
        String password=request.getParameter("password");
        boolean success=false;
        Employee employee=null;
        if(username!=null){
            employee=employeeService.find(username,password);
            success=employee!=null;
        }else{
            mv.setViewName("login");
            return mv;
        }
        if(success){
            session.setAttribute("currentUser",username);
            session.setAttribute("currentUserRole",employee.getRole());
            mv.setViewName("redirect:list");
        }else{
            mv.addObject("error","no user,please register");
            mv.setViewName("login");
        }
        return mv;
    }
    @RequestMapping("logout")
    public ModelAndView logout(ModelAndView mv,HttpSession session){
        session.removeAttribute("currentUser");
        session.removeAttribute("currentUserRole");
        mv.setViewName("login");
        return mv;
    }
}

