/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab03_nsc.dto;

import fpt.aptech.lab03_nsc.entities.Student;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BuuBuu
 */
public class StudentServiceImpl implements StudentService{
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet rs;
    public StudentServiceImpl(){
        setConnect();
    }
    public Connection setConnect(){
        try {
            String url="jdbc: sqlserver://localhost:1433;database=NSCDB";
            String user="sa";
            String password="123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        
        try {
            String sql="SELECT * FROM Student";
            statement=connection.prepareStatement(sql); 
            rs=statement.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setStudentId(rs.getString(1));
                student.setStudentName(rs.getString(2));
                student.setAddress(rs.getString(3));
                student.setEmail(rs.getString(4));
                
                list.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;      
    }

    @Override
    public Student findOne(String id) {
        return null;
    }

    @Override
    public boolean addStudent(Student student) {
        return false;
    }
    
}
