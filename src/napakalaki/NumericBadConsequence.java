/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class NumericBadConsequence extends BadConsequence{
    private int  nVisibleTreasures, nHiddenTreasures;
    
    public NumericBadConsequence(String text, int level, int nVisible, int nHidden){
        super(text, level);
        this.nHiddenTreasures = nHidden;
        this.nVisibleTreasures = nVisible;
    }
    
    public int getNVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    
    @Override
    public boolean isEmpty(){
        return (nVisibleTreasures==0 && nHiddenTreasures==0);
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if(nVisibleTreasures > 0)
            nVisibleTreasures--; 
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures > 0)
            nHiddenTreasures--; 
    }

    @Override
    public NumericBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        NumericBadConsequence resultado;
        int visibles,ocultos;
        levels=0;
            
        visibles=Math.min(v.size(), this.nVisibleTreasures);
        ocultos=Math.min(h.size(), this.nHiddenTreasures);
            
        resultado=new NumericBadConsequence(this.getText(),this.getLevels(),visibles,ocultos);
        
        return resultado;
    }
    
    public String to_s() {
        return text + "\nTesoros visibles: " + nVisibleTreasures + "\nTesoros ocultos" + nHiddenTreasures;
    }
           
}
