package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Staff;

/**
 *
 * @author 84393
 */
public class Staffdao extends JDBCConnection {

    PreparedStatement ps;

    public List<Staff> getStaffs() {
        List<Staff> list = new ArrayList<>();
        String query = "Select * from Staff where isdelete = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Staff st = new Staff();
                st.setStaff_id(rs.getString(1));
                st.setName(rs.getString(2));
                st.setRole(rs.getString(3));
                st.setSalary(rs.getDouble(4));
                st.setWorkplace_id(rs.getString(5));
                list.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Staffdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void addStaff(Staff st) {
        String query = "insert into Staff(Staff_id, Name, role, Salary, workplace) values(?,?,?,?,?)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, st.getStaff_id());
            ps.setString(2, st.getName());
            ps.setString(3, st.getRole());
            ps.setDouble(4, st.getSalary());
            ps.setString(5, st.getWorkplace_id());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Staffdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hideStaff(Staff st) {
        String query = "Update Staff set isdelete = ? where Staff_id = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, 0);
            ps.setString(2, st.getStaff_id());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Staffdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStaff(Staff st) {
        String query = "Delete from Staff where Staff_id = ? and isdelete = 0";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, st.getStaff_id());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Staffdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStaff(Staff st) {
        String query = "Update Staff set name = ?"
                + ", ROle = ?"
                + ", salary = ?"
                + ", workplace = ?"
                + " where Staff_id = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, st.getName());
            ps.setString(2, st.getRole());
            ps.setDouble(3, st.getSalary());
            ps.setString(4, st.getWorkplace_id());
            ps.setString(5, st.getStaff_id());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Staffdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Staff> getHideStaffs() {
        List<Staff> list = new ArrayList<>();
        String query = "Select * from Staff where isdelete = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, 0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Staff st = new Staff();
                st.setStaff_id(rs.getString(1));
                st.setName(rs.getString(2));
                st.setRole(rs.getString(3));
                st.setSalary(rs.getDouble(4));
                st.setWorkplace_id(rs.getString(5));
                list.add(st);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Staffdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void reStaff(Staff st) {
        String query = "Update Staff set isdelete = ? where Staff_id = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, 1);
            ps.setString(2, st.getStaff_id());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Staffdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearHideStaff() {
        String query = "Delete from Staff where isdelete = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, 0);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Staffdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Staff> filterStaffs(String key, String value) {
        String query = "Select * from Staff where ? = ? and isdelete = ?";
        List<Staff> list = new ArrayList<>();
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, key);
            ps.setString(2, value);
            ps.setInt(3, 1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Staff st = new Staff();
                st.setStaff_id(rs.getString(1));
                st.setName(rs.getString(2));
                st.setRole(rs.getString(3));
                st.setSalary(rs.getDouble(4));
                st.setWorkplace_id(rs.getString(5));
                list.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Staffdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getNoStaff(String role) {
        String query = "select count(Staff_id) as count from Staff where role = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, role);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt("count");
        } catch (SQLException ex) {
            Logger.getLogger(Staffdao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 1;
    }
}
