/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Alexis
 */
public class Cultist {
    private String name;
    private int gainedLevels;
    
    public Cultist(String name, int gLevels){
        this.name = name;
        this.gainedLevels = gLevels;
    }
    
    int getGainedLevels(){
        return gainedLevels;
    }
}
