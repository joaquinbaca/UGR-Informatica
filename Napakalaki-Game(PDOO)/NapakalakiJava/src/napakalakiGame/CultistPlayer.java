/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;

/**
 *
 * @author joaquin
 */
public class CultistPlayer extends Player {
    private Cultist myCultistCard;
    private static int totalCultistPlayers=0;
    
    public CultistPlayer(Player p ,Cultist c){
       super(p);
       this.myCultistCard=c;
       totalCultistPlayers++;
    }
    
    @Override
    public int getCombatLevel(){
    double salida=0;
    salida=(super.getCombatLevel()+super.getCombatLevel()*0.2 + myCultistCard.getGainedLevels())*totalCultistPlayers;
    return (int) salida;
    }
    @Override
    protected int getOponentLevel(Monster m){
        int salida;
        salida=m.getCombatLevelAgainstCultistPlayer();
    return salida;
    }
    @Override
    protected boolean shouldConvert(){
    return false;
    }
    @Override
    protected Treasure giveMeATreasure(){
           Treasure tesoro;
      int aleatorio = visibleTreasures.size();
      int numero= (generator.nextInt(aleatorio));
                 tesoro=visibleTreasures.get(numero);
  return tesoro;
    
    }
    @Override
    protected boolean canYouGiveMeATreasure(){
    boolean salida=true;
      if(visibleTreasures.isEmpty()&&hiddenTreasures.isEmpty())
          salida=false;
  return salida;
    
    }
    @Override
    public boolean getConvertido(){
  return true;
  }
    @Override
    public int getTotalCultistPlayers(){
    return totalCultistPlayers;
    }
    
}
