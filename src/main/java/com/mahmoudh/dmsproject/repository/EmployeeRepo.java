package com.mahmoudh.dmsproject.repository;

import com.mahmoudh.dmsproject.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class EmployeeRepo {

    private static EmployeeRepo instance;
    private final SessionFactory sessionFactory;
    Session session;

    private EmployeeRepo() {
        Configuration config = new Configuration().configure();
        sessionFactory = config.addAnnotatedClass(Employee.class).buildSessionFactory();
    }

    //singleton pattern
    public static EmployeeRepo getInstance() {
        if (instance == null) {
            instance = new EmployeeRepo();
        }
        return instance;
    }

    public void saveNewEmployee(Employee emp) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(emp);
        session.getTransaction().commit();
        session.close();
    }

    public List<Employee> getAllEmployee() {
        session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery("select e from Employee e", Employee.class).getResultList();
        session.close();
        return employees;
    }

    public List<Employee> getEmployeeByCode(String code) {
        session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery("select e from Employee e where e.empCode=" + code + " order by e.empCode desc", Employee.class).getResultList();
        session.close();
        return employees;
    }

    public void updateEmployee(Employee emp) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Employee currentEmp = session.get(Employee.class, emp.getEmpId());
        currentEmp.setEmpCode(emp.getEmpCode());
        currentEmp.setEmpName(emp.getEmpName());
        currentEmp.setEmpAddress(emp.getEmpAddress());
        currentEmp.setEmpEmail(emp.getEmpEmail());
        session.getTransaction().commit();
        session.close();

    }

    public void deleteEmployee(Employee emp) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.remove(emp);
        session.getTransaction().commit();
        session.close();
    }
}
