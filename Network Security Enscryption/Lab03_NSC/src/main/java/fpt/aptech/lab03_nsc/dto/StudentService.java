/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab03_nsc.dto;
import java.util.List;
import fpt.aptech.lab03_nsc.entities.*;

/**
 *
 * @author BuuBuu
 */
public interface StudentService {
    List <Student> findAll();
    Student findOne(String id);
    boolean addStudent(Student student);
       
}
