package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pig {

    private String Pig_id;
    private String gender;
    private LocalDate date_in;
    private LocalDate date_out;
    private int weigh;
    private int age;
    private String cage_id;
    private static int nextID = 0;

    public Pig() {
    }

    public String getPig_id() {
        return Pig_id;
    }

    public void setPig_id(String pig_id) {
        this.Pig_id = pig_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDate_in() {
        return date_in;
    }

    public void setDate_in(LocalDate date_in) {
        this.date_in = date_in;
    }

    public LocalDate getDate_out() {
        return date_out;
    }

    public void setDate_out(LocalDate date_out) {
        this.date_out = date_out;
    }

    public String getCage_id() {
        return cage_id;
    }

    public void setCage_id(String cage_id) {
        this.cage_id = cage_id;
    }

    public int getWeigh() {
        return weigh;
    }

    public void setWeigh(int weigh) {
        this.weigh = weigh;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(date_in, currentDate);
        return (int) daysBetween;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCage() {
        return cage_id;
    }

    public void setCage(String cage) {
        this.cage_id = cage;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        Pig.nextID = nextID;
    }

    @Override
    public String toString() {
        return "Pig{" + "Pig_id=" + Pig_id + ", gender=" + gender + ", date_in=" + date_in + ", date_out=" + date_out + ", weigh=" + weigh + ", age=" + age + ", cage_id=" + cage_id + '}';
    }

}
