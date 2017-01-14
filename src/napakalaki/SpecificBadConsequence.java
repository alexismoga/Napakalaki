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
        BadConsequence bad_ret;
        
        if(!isEmpty()){
                boolean insertado=false;
                
                ArrayList<TreasureKind> sp_v=new ArrayList(), sp_h=new ArrayList();
                
                for(TreasureKind spvi :specificVisibleTreasures){
                    insertado= false;
                    for(Treasure spvp :v){
                        if(!insertado)
                            if(spvi==spvp.getType()){
                                if(!sp_v.contains(spvi)){
                                    sp_v.add(spvi);
                                    insertado=true;
                                }
                            }
                    }
                }
                
                for(TreasureKind sphi :specificHiddenTreasures){
                    insertado= false;
                    for(Treasure sphp :h){
                        if(!insertado)
                            if(sphi==sphp.getType()){
                                if(!sp_h.contains(sphi)){
                                    sp_h.add(sphi);
                                    insertado= true;
                                }
                            }
                    }
                }
                bad_ret= new SpecificBadConsequence(text, levels, sp_v, sp_h);
            
            return bad_ret;
        }
        return this;
    }
    
    @Override
    public boolean isEmpty(){
        return specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty();
    }
}
