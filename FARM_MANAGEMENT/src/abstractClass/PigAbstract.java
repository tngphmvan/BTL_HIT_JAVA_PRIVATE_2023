/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractClass;

import dao.JDBCConnection;
import java.util.List;
import model.Pig;

/**
 *
 * @author 84393
 */
public abstract class PigAbstract extends JDBCConnection{
    
    public abstract List<Pig> getPigs();

    public abstract void addPig(Pig pig);

    public abstract void hidePig(Pig pig);

    public abstract void rePig(Pig st);

    public abstract void deletePig(Pig pig);

    public abstract void updatePig(Pig pig);

    public abstract List<Pig> getHidePigs();

    public abstract void clearHidePig();

    public abstract int getNoPig();

    public abstract void removePig();

    public abstract void setday(Pig pig);

    public abstract int setAge(Pig pig);

    public abstract List<Pig> filterPigs(String key, String value);
}
