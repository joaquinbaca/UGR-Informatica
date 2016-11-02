/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;
import GUI.Dice;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author joaquin
 */
public class Player {
  final int MAXLEVEL = 10; 
  private String name;
  private int level;
  private boolean dead = true;
  private boolean canISteal = true;
  protected Player enemy;
  protected ArrayList<Treasure> hiddenTreasures = new ArrayList();
  protected ArrayList<Treasure> visibleTreasures = new ArrayList();
  private BadConsequence pendingBadConsequence;
  protected Random generator=new Random();
  
  public Player(String name){
  this.name=name;
  }
  
  public Player(Player p){
    this.name = p.getName();
    this.level=p.getLevels();
    this.dead=p.getDead();
    this.canISteal= p.canISteal();
    this.enemy=p.getEnemy();
    this.visibleTreasures=p.getVisibleTreasures();
    this.hiddenTreasures=p.getHiddenTreasures();
    this.pendingBadConsequence=p.getBC();
  }
  
  protected int getOponentLevel(Monster m){
   return m.getCombatLevel();
  }
  protected boolean shouldConvert(){
     boolean salida = false;
     Dice dado = Dice.getInstance();
     int d= dado.nextNumber();
     if(d==1)
         salida=true;
     return salida;
  }
  public boolean getConvertido(){
  return false;
  }
  public int getTotalCultistPlayers(){
    return 0;
    }
  public String getName(){
   return name;
  }
  public boolean getDead(){
  return this.dead;
  
  }
  public BadConsequence getBC(){
  return this.pendingBadConsequence;
  }
  public Player getEnemy(){
  return this.enemy;
  }
  private void bringToLife(){
  dead=false;
  }
  
  public int getCombatLevel(){
  int nivel=0;
  for(Treasure i:visibleTreasures){
      nivel = nivel + i.getBonus();
  }
  nivel=nivel+level;
  return nivel;
  }
          
  private void incrementLevels(int l){
  level=level+l;
  }
  
  private void decrementLevels(int l){
      if(level!=0){
  level = level -l;}
  }
  
  private void setPendingBadConsequence(BadConsequence bc){
  pendingBadConsequence=bc;
  }
  
  private void applyPrize(Monster m){
      int nLevels = m.getLevelsGained();
      incrementLevels(nLevels);
      int nTreasures = m.getTreasuresGained();
      if(nTreasures>0){
         CardDealer dealer = CardDealer.getInstance();
         for(int i = 0; i<=nTreasures;i++){
           Treasure treasure = dealer.nextTreasure();
           hiddenTreasures.add(treasure);
         }
      
      }
  }
  
  private void applyBadConsequence(Monster m){
      BadConsequence badConsequence = m.getBadConsequence();
      int nLevels = badConsequence.getLevels();
      decrementLevels(nLevels);
      BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
      setPendingBadConsequence(pendingBad);
  }
  
  private boolean canMakeTreasureVisible(Treasure t){
      boolean salida = true;
      int p=0;
      for(Treasure treasure:visibleTreasures)
            if(treasure.getType()==t.getType() && TreasureKind.ONEHAND!=t.getType()){
               salida=false;
            }else if(TreasureKind.ONEHAND==t.getType() && !visibleTreasures.contains(TreasureKind.BOTHHANDS)){
                  for(int i=0;i<visibleTreasures.size();i++){
                      if(visibleTreasures.get(i).getType()==TreasureKind.ONEHAND)
                          p++;
                 }
                 if(p>=2)
                     salida=false;
            }
      return salida;
  
  }
  
  private int howManyVisibleTreasures(TreasureKind tKind){
      int numero=0;
      for(int i=0;i<=visibleTreasures.size();i++){
      if(visibleTreasures.get(i).getType()==tKind)
          numero++;}
  return numero;
  }
  
  private void dielfNoTreasures(){
      dead=true;
  }
  
  public boolean isDead(){
  return dead;
  }
  
  public ArrayList<Treasure> getHiddenTreasures(){
  return hiddenTreasures;
  }
  
  public ArrayList<Treasure> getVisibleTreasures(){
  return visibleTreasures;
  }
  
  public CombatResult combat(Monster m){
      CombatResult resultado;
      boolean conv;
      int myLevel = getCombatLevel();
      int monsterLevel = getOponentLevel(m);
      if(myLevel>monsterLevel){
         applyPrize(m);
         if(level>=MAXLEVEL){
            resultado=CombatResult.WINGAME;
         }else{
            resultado = CombatResult.WIN;
         }
             
      }else{
         applyBadConsequence(m);
         resultado= CombatResult.LOSE;
         conv=shouldConvert();
         if(conv)
         resultado = CombatResult.LOSEANDCONVERT;
      }
  return resultado;
  }
  
  public void makeTreasureVisible(Treasure t){
       boolean canI = canMakeTreasureVisible(t);
       if(canI){
         visibleTreasures.add(t);
         hiddenTreasures.remove(t);
       }
  }
  
  public void discardVisibleTreasure(Treasure t){
         visibleTreasures.remove(t);
         if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
             pendingBadConsequence.substractVisibleTreasure(t);
             dielfNoTreasures();
  }
  
  public void discardHiddenTreasure(Treasure t){
           hiddenTreasures.remove(t);
         if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
             pendingBadConsequence.substractHiddenTreasure(t);
             dielfNoTreasures();
  }
  
  public boolean validState(){
   boolean salida = false;   
      if((pendingBadConsequence==null || pendingBadConsequence.isEmpty()) && hiddenTreasures.size()<4 )
          salida=true;
  return salida;
  }
  
  public void initTreasures(){
      CardDealer dealer = CardDealer.getInstance();
      Dice dice = Dice.getInstance();
      bringToLife();
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
  return level;
  }
  
  public Treasure stealTreasure(){
      boolean canI = canISteal();
      Treasure salida = null;
      if(canI){
        boolean canYou = enemy.canYouGiveMeATreasure();
        if(canYou){
           Treasure treasure = enemy.giveMeATreasure();
           hiddenTreasures.add(treasure);
           haveStolen();
           salida=treasure;
          }
       }
  return salida;
  }
  
  public void setEnemy(Player enemy){
   this.enemy=enemy;
  }
  
  protected Treasure giveMeATreasure(){
      Treasure tesoro;
      int aleatorio = hiddenTreasures.size();
      int numero= (generator.nextInt(aleatorio));
                 tesoro=hiddenTreasures.get(numero);
  return tesoro;
  }
  
  public boolean canISteal(){
  return canISteal;
  }
  
  protected boolean canYouGiveMeATreasure(){
      boolean salida=true;
      if(hiddenTreasures.isEmpty())
          salida=false;
  return salida;
  }
  
  private void haveStolen(){
  canISteal=false;
  }
  
  public void discardAllTreasures(){
      ArrayList<Treasure> copiaVisibleTreasures = new ArrayList(visibleTreasures);
      ArrayList<Treasure> copiaHiddenTreasures = new ArrayList(hiddenTreasures);
      for(Treasure treasure:copiaVisibleTreasures){
         discardVisibleTreasure(treasure);
      }
      for(Treasure treasure:copiaHiddenTreasures){
         discardHiddenTreasure(treasure);
      }
      
  }
          
          
  public String toString(){
   return "\nname = " + this.name + "\nlevel = " + Integer.toString(this.getLevels()) + "\ncombatlevel = " + Integer.toString(this.getCombatLevel());
  
  }        
          
          
          
          
          
}














