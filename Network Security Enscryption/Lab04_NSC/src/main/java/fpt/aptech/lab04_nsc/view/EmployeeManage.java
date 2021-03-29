/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab04_nsc.view;

import fpt.aptech.lab04_nsc.service.*;
import java.util.Scanner;
import fpt.aptech.lab04_nsc.entities.Employee;

/**
 *
 * @author BuuBuu
 */
public class EmployeeManage {

    private static void menu() {
        System.out.println("----- Employee Management System------");
        System.out.println("1. Add employee");
        System.out.println("2. Login employee");
        System.out.println("3. Exit");
        System.out.println("---------------------------------------");

    }

    public static void main(String[] args) {
        int opt = 0;
        Scanner scr = new Scanner(System.in);
        EmployeeServiceImpl emp = new EmployeeServiceImpl();
        Employee employee = new Employee();
        do {
            menu();
            System.out.println("Enter an option: ");
            opt = scr.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("Enter information: ");
                    System.out.println("Enter Code: ");
                    String code = scr.next();
                    employee.setEmployeeCode(code);

                    System.out.println("Enter Name: ");
                    String name = scr.next();
                    employee.setEmployeeName(name);

                    System.out.println("Enter Pass: ");
                    String pass = scr.next();
                    employee.setPassword(pass);

                    System.out.println("Enter Salary: ");
                    float salary = scr.nextFloat();
                    employee.setSalary(salary);

                    emp.addEmployee(employee);
                    System.out.println("Add Employee Completed...");

                    break;
                case 2:
                    System.out.println("Chua lam....");
                    break;
                case 3:
                    System.exit(0);
                    break;
            }

        } while (opt != 3);

    }
}
