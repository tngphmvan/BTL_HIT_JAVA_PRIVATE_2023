/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import abstractClass.StaffAbstract;
import dao.Staffdao;
import java.util.List;
import model.Staff;

/**
 *
 * @author 84393
 */
public class StaffService extends StaffAbstract {

    private Staffdao staffdao;

    public StaffService() {
        this.staffdao = new Staffdao();
    }

    @Override
    public List<Staff> getStaffs() {
        return staffdao.getStaffs();
    }

    @Override
    public void addStaff(Staff staff) {
        staffdao.addStaff(staff);
    }

    @Override
    public void hideStaff(Staff staff) {
        staffdao.hideStaff(staff);
    }

    @Override
    public void deleteStaff(Staff staff) {
        staffdao.deleteStaff(staff);
    }

    @Override
    public void updateStaff(Staff staff) {
        staffdao.updateStaff(staff);
    }

    public List<Staff> getHiddenStaffs() {
        return staffdao.getHideStaffs();
    }

    @Override
    public void reStaff(Staff staff) {
        staffdao.reStaff(staff);
    }

    public void clearHiddenStaff() {
        staffdao.clearHideStaff();
    }

    @Override
    public List<Staff> filterStaffs(String key, String value) {
        return staffdao.filterStaffs(key, value);
    }

    @Override
    public int getNoStaff(String role) {
        return staffdao.getNoStaff(role);
    }

    @Override
    public List<Staff> getHideStaffs() {
        return staffdao.getHideStaffs();
    }

    @Override
    public void clearHideStaff() {
        staffdao.clearHideStaff();
    }

}
