/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab03_nsc.view;
import fpt.aptech.lab03_nsc.dto.*;
import fpt.aptech.lab03_nsc.entities.Student;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author BuuBuu
 */
public class StudentManage {

    private static void menu(){
        System.out.println("======Student Management System=======");
        System.out.println("1.Student List");
        System.out.println("2.Find by student code");
        System.out.println("3. Save student");
        System.out.println("4. Exit");
        System.out.println("=======================================");
    } 
    StudentServiceImpl serviceImpl = new StudentServiceImpl();
    private void viewAll(){
        List<Student> list = serviceImpl.findAll();
        System.out.println("----- Student List-----");
        
        for (Student student : list) {
            System.out.println("Student Code: " + student.getStudentId());
            System.out.println("Student Name: "+ student.getStudentName());
            System.out.println("Student Address: " +student.getAddress());
            System.out.println("Student Email: "+ student.getEmail());
        }
    }
    public static void main(String[] args) {
       StudentManage manage = new StudentManage();
       
        int opt = 0;
        Scanner scr = new Scanner(System.in);
        do{
            menu();
        System.out.println("Enter an option[1-4] :");
        opt = scr.nextInt();
           switch (opt) {
                    case 1:
                    manage.viewAll();
                    break;
                     case 2:
                         System.out.println("Chua lam");
                    break;
                      case 3:
                         System.out.println("Chua lam");
                    break;
                      case 4:
                         System.exit((0));
                    break;
               
            }
        }while(opt!=4);
        // TODO code application logic here
    }
    
}
