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
public class DeathBadConsequence extends NumericBadConsequence{
    
    private final boolean death;
    
    public DeathBadConsequence(String txt,int level, int nVisible, int nHidden, boolean dth) {
        super(txt,level,nVisible,nHidden);
        death=dth;
    }
    
    public boolean isDeath(){
        return death;
    }
    
    @Override
    public String toString(){
        return " " + text;
    }
}
