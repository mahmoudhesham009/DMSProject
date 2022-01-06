package com.mahmoudh.dmsproject.controller;

import com.mahmoudh.dmsproject.model.Employee;
import com.mahmoudh.dmsproject.service.EmployeeService;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class EmployeeController {
    private EmployeeService employeeService;
    private Employee editEmployee;

    public EmployeeController() {
        employeeService = EmployeeService.getInstance();
    }

    public String saveEmployee(Employee e) {
        employeeService.save(e);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('success_dlg').show()");
        return "employee";
    }

    public List<Employee> showAllEmployee() {

        return employeeService.getAllEmployee();
    }

    public void createEditEmployee(Employee emp) {
        editEmployee = emp;
        System.out.println(emp.getEmpCode());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('edit_dlg').show()");
    }

    public String updateEmployee(Employee emp) {
        employeeService.updateEmployee(emp);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('success_dlg').show()");
        return "employee";
    }

    public Employee getEditEmployee() {
        return editEmployee;
    }

    public void setEditEmployee(Employee editEmployee) {
        this.editEmployee = editEmployee;
    }

    public String deleteEmployee(Employee e) {
        employeeService.deleteEmployee(e);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('success_dlg').show()");
        return "employee";
    }


}
