/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import GUI.Dice;

/**
 *
 * @author Alexis
 */
public class Player {
    static final int MAXLEVEL = 10;
    private String name;
    private int level;
    boolean dead=true;
    boolean canISteal=true;
    protected Player enemy;
    protected ArrayList<Treasure> hiddenTreasures;
    protected ArrayList<Treasure> visibleTreasures;
    public BadConsequence pendingBadConsequence;
    
    public Player(String name){
        this.name = name;
        this.level = 1;
        this.hiddenTreasures = new ArrayList();
        this.visibleTreasures = new ArrayList();
    }
    
    //Constructor para poder hacer el super(p) de CultisPlayer
    public Player(Player p){
       this.name=p.name;
       this.level=p.level;
       this.hiddenTreasures=p.hiddenTreasures;
       this.visibleTreasures=p.visibleTreasures;
   }
    
    public String getName(){
        return name;
    }
    
    private void bringToLife(){
        this.dead = false;
    }
    
    public int getCombatLevel(){
       int lev=level;
       for(Treasure t: visibleTreasures){
           lev+=t.getBonus();
       }
        return lev;
    }
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected Player getEnemy(){
        return enemy;
    }
    
    protected boolean shouldConvert(){
        return (Dice.getInstance().nextNumber() == 6);
    }
    
    private void incrementLevels(int l){
        level += l;
    }
    
    private void decrementLevels(int l){
       level=level-l;
       if(level<1){
           level=1;
       }
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequence = b;
    }
    
    private void applyPrize(Monster m){
        int nLevels = m.getLevelsGained();//1
        this.incrementLevels(nLevels);//2
        int nTreasures = m.getTreasuresGained();//3
        if(nTreasures>0){
            CardDealer dealer = CardDealer.getInstance();//4
            for(int i=1;i<nTreasures;i++){
                Treasure treasure = dealer.nextTreasure();//5
                hiddenTreasures.add(treasure);//6
            }      
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        this.decrementLevels(nLevels);
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        this.setPendingBadConsequence(pendingBad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
       int nOnehand=0;
       int nBothhands=0;
       int nArmor=0;
       int nShoes=0;
       int nHelmet=0;
       boolean res=false;
       
       for (Treasure tre : visibleTreasures) {
           if(tre.getType() == TreasureKind.ONEHAND){
               nOnehand++;
           }else if(tre.getType() ==  TreasureKind.BOTHHANDS){
               nBothhands++;
           }else if(tre.getType() == TreasureKind.ARMOR){
               nArmor++;
           }else if(tre.getType() ==  TreasureKind.SHOES){
               nShoes++;
           }else{
               nHelmet++;
           }
       }
       switch(t.getType()){
            case ONEHAND:
                if(nOnehand < 2 && nBothhands == 0)
                    res = true;
                break;
            case BOTHHANDS:
                if(nOnehand == 0 && nBothhands == 0)
                    res = true;
                break;
            case HELMET:
                if(nHelmet == 0)
                    res = true;
                break;
            case SHOES:
                if(nShoes == 0)
                    res = true;
                break;
            case ARMOR:
                if(nArmor == 0)
                    res = true;
                break;
        }
       return res;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
       int i=0;
       for(Treasure t: visibleTreasures){
           if(t.getType()==tKind){
               i++;
           }
       }
       return i;
    }
    
    private void dieIfNoTreasures(){
        if(this.visibleTreasures.isEmpty() && this.hiddenTreasures.isEmpty()){
            this.dead = true;
        }
    }
    
    public boolean isDead(){
        boolean muerto = false;
        if(dead==true){
            muerto = true;
        }
        return muerto;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return this.hiddenTreasures;
    }
    public ArrayList<Treasure> getVisibleTreasures(){
        return this.visibleTreasures;
    }
    public CombatResult combat(Monster m){
        int myLevel = this.getCombatLevel(); // 1.1.1
        int monsterLevel = this.getOponentLevel(m); // 1.1.2
        int enemyLevel = 0;
        boolean should;
        CombatResult result;
        
        if(!canISteal){
            Dice dice = Dice.getInstance(); //1.1.3
            int number = dice.nextNumber(); //1.1.4
            if(number<3){
              enemyLevel = this.getOponentLevel(m);//1.1.5
              monsterLevel += enemyLevel;
            }
        }
        if(myLevel>monsterLevel){
            this.applyPrize(m); //1.1.6
            if(level >=MAXLEVEL)
                result=CombatResult.WINGAME;
            else
                result=CombatResult.WIN;
        }else{
            this.applyBadConsequence(m); //1.1.7
            should=this.shouldConvert();
            if(should==true){
                result=CombatResult.LOSEANDCONVERT;
            }
            else{
                result=CombatResult.LOSE;
            }
        }
        return  result; //1.1.10
    }
    
    public void makeTreasureVisible(Treasure t){
        boolean canI = this.canMakeTreasureVisible(t);//1.2.1
        if(canI){
            visibleTreasures.add(t); //1.2.2
            hiddenTreasures.remove(t); //1.2.3
        } 
    }
    
    public void discardVisibleTreasure(Treasure t){
        this.visibleTreasures.remove(t); //1.2.1
        if((pendingBadConsequence!=null) && (!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractVisibleTreasure(t); //1.2.2
        this.dieIfNoTreasures();  //1.2.3
    }
    
    public void discardHiddenTreasure(Treasure t){
        this.hiddenTreasures.remove(t); //1.2.1
        if((pendingBadConsequence!=null) && (!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractHiddenTreasure(t); //1.2.2
        this.dieIfNoTreasures();  //1.2.3
    }
    
    public boolean validState(){
        boolean estado=false;
        if(pendingBadConsequence==null||pendingBadConsequence.isEmpty() && hiddenTreasures.size()<=4 ){
            estado = true;
        }
        return estado;
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        this.bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber();
        
        if(number>1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if(number==6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    public int getLevels(){
        return this.level;
    }
    
    public Treasure stealTreasure(){
        boolean canI = this.canISteal();
        Treasure treasure=null;
        if(canI){
            boolean canYou = enemy.canYouGiveMeATreasure();
            if(canYou){
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                this.haveStolen();
            }
        }
        return treasure;
        
    }
    
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    private Treasure giveMeATreasure(){
        int aleato = (int) (Math.random()*hiddenTreasures.size());
        
        return hiddenTreasures.get(aleato);
    }
    
    public boolean canISteal(){
        return this.canISteal;
    }
    
    protected boolean canYouGiveMeATreasure(){
        return (!this.getVisibleTreasures().isEmpty() && !this.getHiddenTreasures().isEmpty());
    }
    
    private void haveStolen(){
        this.canISteal = false;
    }
    
    public void discardAllTreasures(){
        ArrayList<Treasure> visibleaux= new ArrayList(visibleTreasures);
        ArrayList<Treasure> hiddenaux= new ArrayList(hiddenTreasures);
        
        for(Treasure t: visibleaux){
            this.discardVisibleTreasure(t);
        }
        for(Treasure t: hiddenaux){
            this.discardHiddenTreasure(t);
        }   
    }
    
    public String toString(){
        return name + " Nivel: " + Integer.toString(this.getCombatLevel());
    }
}

