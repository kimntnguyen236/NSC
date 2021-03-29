/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab04_nsc.service;
import fpt.aptech.lab04_nsc.entities.Employee;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import fpt.aptech.lab04_nsc.PassEncrypt.PasswordSecurity;
/**
 *
 * @author BuuBuu
 */
public class EmployeeServiceImpl implements EmployeeService {
    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    private Connection setCon() {
       
            String url="jdbc:sqlserver://localhost:1433;database=NSCDB";
            String user="sa";
            String password="123";
            try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmployeeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    public EmployeeServiceImpl(){
        setCon();
    }
    PasswordSecurity ps = new PasswordSecurity();
       
    @Override   
    public void addEmployee(Employee employee) {
        String sql ="INSERT Employee VALUES(?,?,?,?)";
try{
    pstmt = connection.prepareStatement(sql);
    pstmt.setString(1,employee.getEmployeeCode());
    pstmt.setString(2,employee.getEmployeeName());
    pstmt.setString(3,ps.dataEncryption(employee.getPassword()));
    pstmt.setFloat(4,employee.getSalary()); // set int or set float
    
   pstmt.executeUpdate();
            
      System.out.println("Add Employee completed..");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean checkLogin(String code, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
