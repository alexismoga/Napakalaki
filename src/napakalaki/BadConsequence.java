/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import static java.lang.Math.min;

/**
 *
 * @author alexismoga
 */
public class BadConsequence {
    static final int MAXTREASURES=10;
    private String tex;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
        levels = Player.MAXLEVEL;
        nVisibleTreasures = MAXTREASURES;
        nHiddenTreasures = MAXTREASURES;
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    }
    
    public boolean isEmpty(){
        return nVisibleTreasures==0 && nHiddenTreasures==0 && 
                specificHiddenTreasures.isEmpty() 
                && specificVisibleTreasures.isEmpty();
    }
    
    public void substactVisibleTreasures(Treasure t){
        if(!specificVisibleTreasures.isEmpty())
            specificVisibleTreasures.remove(t.getType());
        else if(nVisibleTreasures!=0)
            nVisibleTreasures--; 
    }
    
    public void substractHiddenTreasures(Treasure t){
        if(!specificHiddenTreasures.isEmpty())
            specificHiddenTreasures.remove(t.getType());
        else if(nHiddenTreasures!=0)
            nHiddenTreasures--;
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        BadConsequence resultado=null;
        levels=0;
        if(this.specificVisibleTreasures.isEmpty()&&this.specificHiddenTreasures.isEmpty()){
            int visibles,ocultos;
            visibles=Math.min(v.size(), this.nVisibleTreasures);
            ocultos=Math.min(h.size(), this.nHiddenTreasures);
           
            resultado=new BadConsequence(this.getText(),this.getLevels(),visibles,ocultos);
        }//Esta parte no la he escrito yo en la mayoría(no me salia :( )
        else if(!v.isEmpty() || !h.isEmpty()){
            ArrayList<TreasureKind> visiblesArra=new ArrayList();
            ArrayList<TreasureKind> ocultosArra=new ArrayList();
                
            for (TreasureKind tKind : TreasureKind.values()) {
                int min1 = 0, min2 = 0; 
                    // Trabajamos con tesoros visibles para cada TreasureKind
                    for(int i = 0; i < specificVisibleTreasures.size(); i++){
                        if(specificVisibleTreasures.get(i) == tKind)
                            min1++; 
                    }
                    for(int i = 0; i < v.size(); i++){
                        if(v.get(i).getType() == tKind)
                            min2++; 
                    }
                    // Tomamos el mínimo y añadimos ese número de TreasureKind
                    for(int i = 0; i < min(min1, min2);  i++){
                        visiblesArra.add(tKind); 
                    }
                        
                    //Reseteamos los contadores
                    min1 = min2 = 0; 
                        
                    // Trabajamos con tesoros ocultos. 
                    for(int i = 0; i < specificHiddenTreasures.size(); i++){
                        if(specificHiddenTreasures.get(i) == tKind)
                            min1++; 
                    }
                    for(int i = 0; i < h.size(); i++){
                        if(h.get(i).getType() == tKind)
                            min2++; 
                    }
                    // Tomamos el mínimo y añadimos ese número de TreasureKind
                    for(int i = 0; i < min(min1, min2);  i++){
                        ocultosArra.add(tKind); 
                        }
                }
                
                resultado = new BadConsequence(this.getText(),this.getLevels(), visiblesArra, ocultosArra);
            }
        return resultado;
    }
    
    public String getText(){
        return this.text;
    }
    
    public int getLevels(){
        return this.levels;
    }
    
    public int getNVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    
    public boolean getDeath(){
        return this.death;
    }
    
    public ArrayList<TreasureKind> getSpecificVisible(){
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHidden(){
        return specificHiddenTreasures;
    }
    
    public String toString(){
        return " " + text + "\nLevels = " + Integer.toString(levels) + 
                "\nnVisibleTreasures = " + Integer.toString(nVisibleTreasures) +
                "\nnHiddenTreasures = " + Integer.toString(nHiddenTreasures) +
                "\nDeath = " + Boolean.toString(death) + "\nSpecificVisible =" +
                specificVisibleTreasures + "\nSpecificHidden = " + specificHiddenTreasures + "\n";
    }
    /*
    public static void main(String [] args){
        BadConsequence bad = new BadConsequence("Mal rollito", 3,5,4);
        System.out.println(bad.toString());
    }
    */
}
