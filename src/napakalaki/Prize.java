/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author alexismoga
 */
public class Prize {
    private int treasures, level;
    
    Prize(int treasures, int level){
        this.treasures = treasures;
        this.level = level;
    }
    
    public int getTreasures(){
        return this.treasures;
    }
    
    public int getLevel(){
        return this.level;
    }
    
    public String toString(){
        return "Treasures = " + Integer.toString(treasures) + "Levels = " + 
                Integer.toString(level);
    }
    
    /*
    public static void main(String [] args){
        Prize pri = new Prize(4,7);
        System.out.println(pri.toString());
    }
    */
}