
package model;


public class Cage {
    private String cage_id;
    private int age_of_pig;
    private double area;
    private String Staff_id;
    private String type_of_pig;
    private int No_Pig;
    private static int nextID = 0;

    public Cage(int age_of_pig, double area, String Staff_id, String type_of_pig, int No_Pig) {
        this.cage_id = String.format("Chuong_%d", nextID++);
        this.age_of_pig = age_of_pig;
        this.area = area;
        this.Staff_id = Staff_id;
        this.type_of_pig = type_of_pig;
        this.No_Pig = No_Pig;
    }

    public Cage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getCage_id() {
        return cage_id;
    }

    public void setCage_id(String cage_id) {
        this.cage_id = cage_id;
    }

    public int getAge_of_pig() {
        return age_of_pig;
    }

    public void setAge_of_pig(int age_of_pig) {
        this.age_of_pig = age_of_pig;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getStaff_id() {
        return Staff_id;
    }

    public void setStaff_id(String Staff_id) {
        this.Staff_id = Staff_id;
    }

    public String getType_of_pig() {
        return type_of_pig;
    }

    public void setType_of_pig(String type_of_pig) {
        this.type_of_pig = type_of_pig;
    }

    public int getNo_Pig() {
        return No_Pig;
    }

    public void setNo_Pig(int No_Pig) {
        this.No_Pig = No_Pig;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        Cage.nextID = nextID;
    }
    
    
}
