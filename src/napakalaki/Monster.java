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
public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badCon;
    
    public Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        this.combatLevel = level;
        this.badCon = bc;
        this.prize = prize;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return this.combatLevel;
    }
    
    public Prize getPrize(){
        return this.prize;
    }
    
    public BadConsequence getBadConsequence(){
        return this.badCon;
    }
    
    public int getLevelsGained(){
        return this.prize.getLevel();
    }
    
    public int getTreasuresGained(){
        return this.prize.getTreasures();
    }
    
    public String toString(){
        return "Name = " + name + "\nCombatLevel = " + Integer.toString(combatLevel)
                + "\nPrize = " + prize + "\nBadConsequence = " + badCon;
    }
/*
    public static void main(String [] args){
        System.out.println(mo.toString());
    }
*/
}
