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
public class Napakalaki {
    private static final Napakalaki instance = new Napakalaki();
    private CardDealer dealer;
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList<Player> players;
    
    private Napakalaki(){ 
        players = new ArrayList();
        currentMonster = new Monster(" ",0,null,null);
        dealer = CardDealer.getInstance();
    }
    
    private void initPlayers(ArrayList<String> names){
        for(String pla: names)
            players.add(new Player(pla));
    }
    
    private Player nextPlayer(){
        Player next_p;
        int indice;
        
        if(currentPlayer == null){
            indice = (int) (Math.random()*players.size());
            next_p=players.get(indice);
        }else
            indice = players.indexOf(this.currentPlayer);//indexOf devuelve una posicion
            if(indice==players.size()-1){
                next_p=players.get(0);
            }
            else{
                next_p=players.get(indice+1);
            }
        this.currentPlayer=next_p;
        return currentPlayer;
         
    }
    
    private boolean nextTurnAllowed(){
        boolean cumple;

        if (this.currentPlayer == null)
            cumple = true; 
        else 
            cumple= this.currentPlayer.validState(); //1.1.1
 
        return cumple;
    }
    
    private void setEnemies(){
        for(int i=0;i<players.size();i++){
            int numero= (int) (Math.random()*players.size());
            while(numero==i){//evitar que sea enemigo de el mismo
                 numero= (int) (Math.random()*players.size());
            }
            players.get(i).setEnemy(players.get(numero));
        }
    }
    
    public static final Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult developCombat(){
        Monster m = currentMonster;
        CombatResult result;
        result = currentPlayer.combat(m); // 1.1
        if(result == CombatResult.LOSEANDCONVERT){
            Cultist unicaInsta = this.dealer.nextCultist();
            CultistPlayer newplayer=new CultistPlayer(currentPlayer,unicaInsta);
            int currentpind=players.indexOf(currentPlayer);
            Player enemy=currentPlayer.enemy;
            this.players.set(currentpind, newplayer);
            this.currentPlayer=newplayer;
            newplayer.setEnemy(enemy);
        }
        dealer.giveMonsterBack(m); //1.2
        
        return result;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for(Treasure t: treasures){  //1.1
            currentPlayer.discardVisibleTreasure(t);  //1.2
            dealer.giveTreasureBack(t);  //1.3
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for(Treasure t: treasures){  //1.1
            currentPlayer.discardHiddenTreasure(t);  //1.2
            dealer.giveTreasureBack(t);  //1.3
        }
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for(Treasure t: treasures){ //1.1
            currentPlayer.makeTreasureVisible(t); //1.2   
        }
    }
    
    public void initGame(ArrayList<String> players){
        this.initPlayers(players); //1.1
        this.setEnemies();  //1.2
        dealer.initCards();  //1.3
        this.nextTurn();  //1.4
        
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOk = this.nextTurnAllowed(); //1.1
        
        if(stateOk){
            this.currentMonster = dealer.nextMonster(); //1.2
            this.currentPlayer = this.nextPlayer();  //1.3
            boolean dead = currentPlayer.isDead();  //1.4
            if(dead){
                currentPlayer.initTreasures();  //1.5
            }
        }
        return stateOk;  //1.6
    }
    
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINGAME;
    }
}
