/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import abstractClass.AccountAbstract;
import dao.Accountdao;
import java.util.List;
import model.Account;

/**
 *
 * @author 84393
 */
public class AccountService extends AccountAbstract {

    private Accountdao accd;

    public AccountService() {
        this.accd = new Accountdao();
    }

    @Override
    public Account LogIn(String id, String pass) {
        return accd.LogIn(id, pass);
    }

    @Override
    public void addAccount(Account acc) {
        accd.addAccount(acc);
    }

    @Override
    public void deleteAccount(String id) {
        accd.deleteAccount(id);
    }

    @Override
    public boolean checkAccount(String id) {
        return accd.checkAccount(id);
    }

    @Override
    public List<Account> getAccounts() {
        return accd.getAccounts();
    }

    @Override
    public Account getAccount(String id) {
        return accd.getAccount(id);
    }

    @Override
    public void updateAccount(Account acc) {
        accd.updateAccount(acc);
    }

    @Override
    public void hideAccount(Account acc) {
        accd.hideAccount(acc);
    }

    @Override
    public List<Account> getHideAccounts() {
        return accd.getHideAccounts();
    }

    @Override
    public void reAccount(Account acc) {
        accd.reAccount(acc);
    }

    @Override
    public void clearHideAccount() {
        accd.clearHideAccount();
    }
}
