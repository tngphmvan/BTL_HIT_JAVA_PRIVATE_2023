/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package abstractClass;

import java.util.List;
import model.Account;
import dao.JDBCConnection;
/**
 *
 * @author 84393
 */
public abstract class AccountAbstract extends JDBCConnection{
    
    public abstract Account LogIn(String id, String pass);

    public abstract void addAccount(Account acc);

    public abstract void deleteAccount(String id);

    public abstract boolean checkAccount(String id);

    public abstract List<Account> getAccounts();

    public abstract Account getAccount(String id);

    public abstract void updateAccount(Account acc);

    public abstract void hideAccount(Account acc);

    public abstract List<Account> getHideAccounts();

    public abstract void reAccount(Account acc);

    public abstract void clearHideAccount();
}
