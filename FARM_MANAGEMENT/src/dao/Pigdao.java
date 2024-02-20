package dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pig;

public class Pigdao extends JDBCConnection {

    PreparedStatement ps;

    public List<Pig> getPigs() {
        List<Pig> list = new ArrayList<>();
        String query = "Select * from PIG where isdelete = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pig pig = new Pig();
                pig.setPig_id(rs.getString(1));
                pig.setGender(rs.getString(2));
                pig.setDate_in(rs.getDate(3).toLocalDate());
                pig.setDate_out(rs.getDate(4).toLocalDate());
                pig.setWeigh(rs.getInt(5));
                pig.setAge(pig.getAge());
                pig.setCage(rs.getString(7));
                list.add(pig);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pigdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void addPig(Pig pig) {
        String query = "insert into Pig(pig_id, gender, date_in, date_out, weigh, age, cage_id) values(?,?,?,?,?,?,?)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, pig.getPig_id());
            ps.setString(2, pig.getGender());
            ps.setDate(3, Date.valueOf(pig.getDate_in()));
            ps.setDate(4, Date.valueOf(pig.getDate_out()));
            ps.setInt(5, pig.getWeigh());
            ps.setInt(6, pig.getAge());
            ps.setString(7, pig.getCage());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Pigdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hidePig(Pig pig) {
        String query = "Update Pig set isdelete = ? where Pig_id = ?";
        try {
            ps = ps.getConnection().prepareStatement(query);
            ps.setInt(1, 0);
            ps.setString(2, pig.getPig_id());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Pigdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletePig(Pig pig) {
        String query = "Delete from Pig where Pig_id = ? and isdelete = 0";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, pig.getPig_id());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Pigdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePig(Pig pig) {
        String query = "Update Pig set gender = ?"
                + ", date_in = ?"
                + ", date_out = ?"
                + ", weigh = ?"
                + ", age = ?"
                + ", cage_id = ?"
                + " where Pig_id = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, pig.getGender());
            ps.setDate(2, Date.valueOf(pig.getDate_in()));
            ps.setDate(3, Date.valueOf(pig.getDate_out()));
            ps.setInt(4, pig.getWeigh());
            ps.setInt(5, pig.getAge());
            ps.setString(6, pig.getCage());
            ps.setString(7, pig.getPig_id());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Pigdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Pig> getHidePigs() {
        List<Pig> list = new ArrayList<>();
        String query = "Select * from Pig where isdelete = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, 0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pig pig = new Pig();
                pig.setPig_id(rs.getString(1));
                pig.setGender(rs.getString(2));
                pig.setDate_in(rs.getDate(3).toLocalDate());
                pig.setDate_out(rs.getDate(4).toLocalDate());
                pig.setWeigh(rs.getInt(5));
                pig.setAge(rs.getInt(6));
                pig.setCage(rs.getString(7));
                list.add(pig);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pigdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void rePig(Pig st) {
        String query = "Update Pig set isdelete = ? where Pig_id = ?";
        try {
            ps = ps.getConnection().prepareStatement(query);
            ps.setInt(1, 1);
            ps.setString(2, st.getPig_id());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Pigdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearHidePig() {
        String query = "Delete from Pig where isdelete = ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, 0);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Pigdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getNoPig() {
        String query = "select count(pig_id) from pig ";
        try {
            ps = getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Pigdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    public void removePig() {
        String query = "update pig set isDelete = ?\n"
                + "where date_out not like ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, 0);
            ps.setString(2, "9999-01-01");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Pigdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setday(Pig pig){
        String query = "update pig set date_out = '9999-01-01' where pig_id =?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, pig.getPig_id());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Pigdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int setAge(Pig pig){
        String query = "select DATEDIFF(day,date_in, date_out) from pig where pig_id = ?";
        int result = pig.getAge();
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, pig.getPig_id());
            ResultSet rs = ps.executeQuery();
            rs.next();
            result = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Pigdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<Pig> filterPigs(String key, String value) {
        String query = "Select * from Pig where ? = ? and isdelete = ?";
        List<Pig> list = new ArrayList<>();
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, key);
            ps.setString(2, value);
            ps.setInt(3, 1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pig pig = new Pig();
                pig.setPig_id(rs.getString(1));
                pig.setGender(rs.getString(2));
                pig.setDate_in(rs.getDate(3).toLocalDate());
                pig.setDate_out(rs.getDate(4).toLocalDate());
                pig.setWeigh(rs.getInt(5));
                pig.setAge(rs.getInt(6));
                pig.setCage(rs.getString(7));
                list.add(pig);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pigdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
