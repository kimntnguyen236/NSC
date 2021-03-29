/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab05_nsc.entities.dbo;

import java.util.List;
import fpt.aptech.lab05_nsc.entities.Account;

/**
 *
 * @author ThienKim
 */
public interface AccountService {
    List<Account> findAll();
    Account findOne(String code);
    boolean saveAccount (Account account);
    boolean deleteAccount (String code);
}
