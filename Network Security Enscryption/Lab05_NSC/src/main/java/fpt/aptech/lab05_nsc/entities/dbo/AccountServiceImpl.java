/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab05_nsc.entities.dbo;

import fpt.aptech.lab05_nsc.entities.Account;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThienKim
 */
public class AccountServiceImpl implements AccountService{
    private Connection connection;
    private CallableStatement cstmt;
    private ResultSet rs;

    public AccountServiceImpl() {
        setCon();
    }
    
    private Connection setCon(){
        String url ="jdbc:sqlserver://localhost:1433;database=NSCDB";
        String user = "sa";
        String password ="123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection=DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccountServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    @Override
    public List<Account> findAll() {
        List<Account> list = new ArrayList<Account>();
        try {
            String sql = "{CALL sp_ShowAccount}";
            cstmt = connection.prepareCall(sql);
            rs = cstmt.executeQuery();
            while (rs.next()) {                
                Account account = new Account();
                account.setAccountcode(rs.getString(1));
                account.setAccountname(rs.getString(2));
                account.setPincode(rs.getString(3));
                account.setBalance(Double.parseDouble(rs.getString(4)));
                
                list.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Account findOne(String code) {             
        Account account = new Account();
        try {
            String sql = "{CALL sp_FindAccount(?)}";
            cstmt = connection.prepareCall(sql);
            cstmt.setString(1, code);
            rs = cstmt.executeQuery();
            if (rs.next()) {
                account.setAccountcode(rs.getString(1));
                account.setAccountname(rs.getString(2));
                account.setPincode(rs.getString(3));
                account.setBalance(Double.parseDouble(rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }

    @Override
    public boolean saveAccount(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAccount(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
