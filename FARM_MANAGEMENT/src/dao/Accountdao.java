package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

public class Accountdao extends JDBCConnection {

    PreparedStatement ps;

    public Account LogIn(String id, String pass) {
        Account user = null;
        try {
            String query = "Select * from Account where Staff_id COLLATE Latin1_General_CS_AS = ? and password COLLATE Latin1_General_CS_AS = ?";
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new Account();
                user.setStaff_id(rs.getString("Staff_id"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
            getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Accountdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

    public void addAccount(Account acc) {
        String query = "Insert into Account(Staff_id, Password, Role) values(?,?,?)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, acc.getStaff_id());
            ps.setString(2, acc.getPassword());
            ps.setString(3, acc.getRole());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Accountdao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteAccount(String id) {
        String query = "delete from Account where Staff_id = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Accountdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkAccount(String id) {
        String query = "Select * from Staff where Staff_id = ? and isdelete = ?";
        boolean check = false;
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);
            ps.setInt(2, 1);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
            }
            getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Accountdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public List<Account> getAccounts() {
        List<Account> lst = new ArrayList<Account>();
        String query = "Select * from Account where isdelete = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setStaff_id(rs.getString("Staff_id"));
                acc.setPassword(rs.getString("password"));
                acc.setRole(rs.getString("role"));
                lst.add(acc);
            }
            getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Accountdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    public Account getAccount(String id) {
        String query = "Select * from Account where Staff_id = ?";
        Account acc = new Account();
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acc.setStaff_id(rs.getString("Staff_id"));
            acc.setPassword(rs.getString(2));
            acc.setRole(rs.getString(3));
            return acc;
        } catch (SQLException ex) {
            Logger.getLogger(Accountdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateAccount(Account acc) {
        String query = "Update Account"
                + " set password = ?"
                + ", Role = ?"
                + " where Staff_id = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, acc.getPassword());
            ps.setString(2, acc.getRole());
            ps.setString(3, acc.getStaff_id());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Accountdao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void hideAccount(Account acc) {
        String query = "Update Account set isdelete = ? where Staff_id = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(2, acc.getStaff_id());
            ps.setInt(1, 0);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Accountdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Account> getHideAccounts() {
        List<Account> list = new ArrayList<>();
        String query = "Select * from Account where isdelete = 0";
        try {
            ps = getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account();
                acc.setStaff_id(rs.getString(1));
                acc.setPassword(rs.getString(2));
                acc.setRole(rs.getString(3));
                list.add(acc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Staffdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void reAccount(Account acc) {
        String query = "Update Account set isdelete = ? where Staff_id = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, 1);
            ps.setString(2, acc.getStaff_id());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Staffdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearHideAccount() {
        String query = "Delete from Account where isdelete = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, 0);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Staffdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
