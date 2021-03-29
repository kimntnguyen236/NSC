/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab04_nsc.service;

import fpt.aptech.lab04_nsc.entities.Employee;

/**
 *
 * @author BuuBuu
 */
public interface EmployeeService {
     void addEmployee(Employee emp );
    boolean checkLogin(String code, String pass );
   
    
}
