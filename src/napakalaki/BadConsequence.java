/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author alexismoga
 */
public abstract class BadConsequence {
    int MAXTREASURES=10;
    protected String text;
    protected int levels;
    
    public BadConsequence(String text,int level){
        this.text=text;
        this.levels=level;
    }
    
    public String getText(){
        return text;
    }
    public int getLevels(){
        return levels;
    }
    
    public abstract boolean isEmpty();
    
    public abstract void substractVisibleTreasure(Treasure t);
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h);
    
    @Override
    public String toString(){
        return "Bad Consequence : " + text;
      }
    /*
    public static void main(String [] args){
        BadConsequence bad = new BadConsequence("Mal rollito", 3,5,4);
        System.out.println(bad.toString());
    }
    */
}
