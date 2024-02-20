/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import abstractClass.PigAbstract;
import dao.Pigdao;
import java.util.List;
import model.Pig;

/**
 *
 * @author 84393
 */
public class PigService extends PigAbstract {

    private Pigdao pigdao;

    public PigService() {
        this.pigdao = new Pigdao();
    }

    @Override
    public List<Pig> getPigs() {
        return pigdao.getPigs();
    }

    @Override
    public void addPig(Pig pig) {
        // Validate pig data
        pigdao.addPig(pig);
    }

    @Override
    public void hidePig(Pig pig) {
        pigdao.hidePig(pig);
    }

    @Override
    public void deletePig(Pig pig) {
        pigdao.deletePig(pig);
    }

    @Override
    public void updatePig(Pig pig) {
        // Validate pig data
        pigdao.updatePig(pig);
    }

    public List<Pig> getHiddenPigs() {
        return pigdao.getHidePigs();
    }

    @Override
    public void rePig(Pig pig) {
        pigdao.rePig(pig);
    }

    public void clearHiddenPigs() {
        pigdao.clearHidePig();
    }

    @Override
    public List<Pig> filterPigs(String key, String value) {
        return pigdao.filterPigs(key, value);
    }

    public int getNoPigs() {
        return pigdao.getNoPig();
    }

    @Override
    public void removePig() {
        pigdao.removePig();
    }

    @Override
    public void setday(Pig pig) {
        pigdao.setday(pig);
    }

    @Override
    public int setAge(Pig pig) {
        return pigdao.setAge(pig);
    }

    @Override
    public List<Pig> getHidePigs() {
        return pigdao.getHidePigs();
    }

    @Override
    public void clearHidePig() {
        pigdao.clearHidePig();
    }

    @Override
    public int getNoPig() {
        return pigdao.getNoPig();
    }
}
