package com.edmar.restfulcrud.controller;


import com.edmar.restfulcrud.dao.DepartmentDao;
import com.edmar.restfulcrud.dao.EmployeeDao;
import com.edmar.restfulcrud.entities.Department;
import com.edmar.restfulcrud.entities.Employee;
import com.edmar.restfulcrud.exception.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;


    //查询所有员工 返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //到添加页面
    @GetMapping("emp")
    public String toAddPage(Model model) {
        Collection<Department> depts= departmentDao.getDepartments();
        model.addAttribute("depts",depts);
        return "emp/add";
    }

    //添加Action
    @PostMapping("emp")
    public String addEmp(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //来到修改页面，查出当前员工显示
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable Integer id,Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        System.out.println("GET: " + employee);
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts",depts);
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmpoyee(Employee employee) {
        System.out.println("Update: "+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @GetMapping("/testException/{pram}")
    @ResponseBody
    public String testException(@PathVariable("pram") String pram) {
        System.out.println(pram);
        if(pram.equals("aaa")) {
            System.out.println("p::::::::"+pram);
            throw new UserNotFound();
        }
        return "success";
    }
}
