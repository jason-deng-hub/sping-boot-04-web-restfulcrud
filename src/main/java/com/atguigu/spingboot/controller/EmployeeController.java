package com.atguigu.spingboot.controller;

import com.atguigu.spingboot.dao.DepartmentDao;
import com.atguigu.spingboot.dao.EmployeeDao;
import com.atguigu.spingboot.entities.Department;
import com.atguigu.spingboot.entities.Employee;
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

    //查询所有员工
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();

        model.addAttribute("emps", employees);
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象进行一一绑定:要求请求参数的名字和javaBean入参的对象的属性名相同
    @PostMapping("/emp")
    public String addEmp(Employee employee) {

        employeeDao.save(employee);
        System.out.println(employee);
        //redirect: 表示重定向一个地址 /代表当前项目路径
        //forward: 表示转发到一个地址
        return "redirect:/emps";
    }

    //来到员工编辑页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        //查询所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //修改添加二合一
        return "/emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);

        return "redirect:/emps";
    }
}
