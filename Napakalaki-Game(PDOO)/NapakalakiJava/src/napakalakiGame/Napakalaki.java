/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author joaquin
 */
public class Napakalaki {
    
    private static final Napakalaki instance = new Napakalaki();
    
    private ArrayList<Player> players = new ArrayList();
    private Player currentPlayer;
    private CardDealer dealer = CardDealer.getInstance();
    private Monster currentMonster;
    
    
    private Napakalaki(){
    
    }
    
    private void initPlayers(ArrayList<String>names){
      for (String name:names){
        players.add(new Player(name));
      }
    }
    
    private Player nextPlayer(){
        Random generator=new Random();
        Player jugador;
        int pos;
        if(currentPlayer==null){
           int numero= (generator.nextInt(players.size()));
           jugador=players.get(numero);
        }else{
           pos=players.indexOf(currentPlayer);
           if(pos==players.size()-1){
               pos=0;
           }else{
               pos++;
           }
           jugador=players.get(pos);
        }
        currentPlayer=jugador;
    return jugador;
    }
    
    private boolean nextTurnAllowed(){
        boolean puede;
        if(currentPlayer==null)
            puede=true;
        else
           puede=currentPlayer.validState();
    return puede;
    }
    
    private void setEnemies(){
       Player jugador;
       int numero;
       for (Player player:players){
             do{ 
                 Random generator=new Random();
                 numero= generator.nextInt(players.size());
                 jugador=players.get(numero);
             }while(jugador==player);
             player.setEnemy(player);
      }
    }
    
    public static Napakalaki getInstance(){
    return Napakalaki.instance;
    }
    
    public CombatResult developCombat(){
        CombatResult resultado;
        Cultist carta;
        CultistPlayer nuevo;
        resultado= currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        if(resultado==CombatResult.LOSEANDCONVERT){
          carta=dealer.nextCultist();
          nuevo =new CultistPlayer(currentPlayer,carta);
          for (Player player:players){
             if(player.getEnemy()==currentPlayer)
             player.setEnemy(nuevo);
          }
          players.remove(currentPlayer);
          currentPlayer=nuevo;
          players.add(currentPlayer);
          
        }
    return resultado;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure>treasures){
          for(Treasure treasure:treasures){
              currentPlayer.discardVisibleTreasure(treasure);
              dealer.giveTreasureBack(treasure);
          }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure>treasures){
           for(Treasure treasure:treasures){
              currentPlayer.discardHiddenTreasure(treasure);
              dealer.giveTreasureBack(treasure);
          }       
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure>treasures){
        for(Treasure t:treasures){
           currentPlayer.makeTreasureVisible(t);
           
        }
            
    }
    
    public void initGame(ArrayList<String> names){
        initPlayers(names);
        setEnemies();
        dealer.initCards();
        nextTurn();
    }
    
    public Player getCurrentPlayer(){
    return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
    return currentMonster;
    }
    
    public boolean nextTurn(){
        boolean dead;
        boolean stateOK = nextTurnAllowed();
        if(stateOK){
           currentMonster=dealer.nextMonster();
           currentPlayer = nextPlayer();
           dead= currentPlayer.isDead();
           if(dead){
              currentPlayer.initTreasures();
             }
        
        }
    return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        boolean salida= false;
        if(result==CombatResult.WINGAME)
            salida=true;
    return salida;
    }
}
