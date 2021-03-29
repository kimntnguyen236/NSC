/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab06;

import fpt.aptech.lab06_nsc.entities.Account;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author ThienKim
 */
public class AccountManage {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("fpt.aptech_Lab06_NSC_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    public void deleteAccount(String id) {
        em.getTransaction().begin();
        Account acc = em.find(Account.class, id);
        em.remove(acc);
        em.getTransaction().commit();
    }
    
    public void AddAccount(Account account) {
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
    }

    public void findAll() {
        // Query q = em.createQuery("SELECT a FROM Account a", Account.class); // hiểu là truy vấn trên lớp Account
        // Query q = em.createNamedQuery("Account.findAll", Account.class);
        Query q = em.createNativeQuery("SELECT * FROM Account", Account.class);
        List<Account> list = q.getResultList(); // lấy q ra -> trả về list -> lưu vô 1 cái list
        // dùng foreach lấy list ra
        for (Account account : list) {
            System.out.println("--- Account Information ---");
            System.out.println("Account Code: " + account.getAccountCode());
            System.out.println("Account Name: " + account.getAccountName());
            System.out.println("Account Balance: " + account.getBalance());
            System.out.println("===========================");
        }
    }

    public void persist(Object object) {
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
