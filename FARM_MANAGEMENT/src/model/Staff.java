/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84393
 */
public class Staff {
    private String Staff_id;
    private String Name;
    private String Role;
    private Double Salary;
    private String workplace_id; 
    private static int nextID ;

    public String getStaff_id() {
        return Staff_id;
    }

    public void setStaff_id(String Staff_id) {
        this.Staff_id = Staff_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double Salary) {
        this.Salary = Salary;
    }

    public String getWorkplace_id() {
        return workplace_id;
    }

    public void setWorkplace_id(String workplace_id) {
        this.workplace_id = workplace_id;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        Staff.nextID = nextID;
    }

    public Staff() {
    }

    @Override
    public String toString() {
        return "Staff{" + "Staff_id=" + Staff_id + ", Name=" + Name + ", Role=" + Role + ", Salary=" + Salary + ", workplace_id=" + workplace_id + '}';
    }
    
    
}
