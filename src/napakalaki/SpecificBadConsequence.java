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
public class SpecificBadConsequence extends BadConsequence {
    private ArrayList<TreasureKind> specificHiddenTreasures= new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures= new ArrayList();
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
        super(text, levels);
        this.specificHiddenTreasures = tHidden;
        this.specificVisibleTreasures = tVisible;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return this.specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return this.specificVisibleTreasures;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
            if(!specificVisibleTreasures.isEmpty())
                specificVisibleTreasures.remove(t.getType());
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
            if(!specificHiddenTreasures.isEmpty())
                specificHiddenTreasures.remove(t.getType());
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        SpecificBadConsequence resultado=null;
        levels=0;
         if(!v.isEmpty() || !h.isEmpty()){
            ArrayList<TreasureKind> visiblesR=new ArrayList();
            ArrayList<TreasureKind> ocultosR=new ArrayList();
            
            visiblesR=interseccion(v, this.specificVisibleTreasures);
            ocultosR=interseccion(h, this.specificHiddenTreasures);
            
            resultado=new SpecificBadConsequence(this.getText(),this.getLevels(),visiblesR,ocultosR);
        }
        
        return resultado;
    }
    
    //Creamos este método que hace la interseccion entre las listas de tesoros
    private ArrayList<TreasureKind> interseccion(ArrayList<Treasure> tesoros, ArrayList<TreasureKind> tipos){
        ArrayList<TreasureKind> resultado=new ArrayList();
        ArrayList<Treasure> copiaTesoros=new ArrayList();
        
        copiaTesoros.addAll(tesoros);
        
        for(Treasure t : tesoros){
            if(tipos.contains(t.getType())){
                resultado.add(t.getType());
                copiaTesoros.remove(t);
            }
        }
        return resultado;
    }
    
    @Override
    public boolean isEmpty(){
        return specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty();
    }
}
