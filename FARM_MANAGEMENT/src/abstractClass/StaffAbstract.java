/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractClass;

import dao.JDBCConnection;
import java.util.List;
import model.Staff;

/**
 *
 * @author 84393
 */
public abstract class StaffAbstract extends JDBCConnection {

    public abstract List<Staff> getStaffs();

    public abstract void addStaff(Staff st);

    public abstract void hideStaff(Staff st);

    public abstract void deleteStaff(Staff st);

    public abstract void updateStaff(Staff st);

    public abstract List<Staff> getHideStaffs();

    public abstract void reStaff(Staff st);

    public abstract void clearHideStaff();

    public abstract List<Staff> filterStaffs(String key, String value);

    public abstract int getNoStaff(String role);
}
