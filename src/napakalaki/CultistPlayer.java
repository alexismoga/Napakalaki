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
public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        this.myCultistCard = c;
        this.totalCultistPlayers ++;
    }
    
    @Override
    public int getCombatLevel(){
        int combtL;
        int nivelaso = super.getCombatLevel();
        int  porci = nivelaso * 70/100;
        int nivelcultis = this.myCultistCard.getGainedLevels()*this.getTotalCultistPlayers();
        
        combtL = nivelaso + porci + nivelcultis;
        
        return combtL; 
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    protected Treasure giveMeATreasure(){
        int rand = (int) (Math.random()*this.visibleTreasures.size());
        return this.visibleTreasures.get(rand);
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        return (this.enemy.visibleTreasures.size()>0);
    }
    
    public static int  getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
}   

