package dao;

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84393
 */
public class JDBCConnection {

    public Connection getConnection() {
        String user = "sa";
        String password = "Tung2902";
        String databaseName = "FARM_MANAGEMENT";
        String url = "jdbc:sqlserver://RUVIZNORACO:1433;"
                + "databaseName=" + databaseName
                + ";user=" + user
                + ";password=" + password;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getRow(String id, String table) {
        String query = "Select count(" + id + ") as count from " + table;
        int result = 0;
        try {
            PreparedStatement ps = getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            result = rs.getInt("count");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
