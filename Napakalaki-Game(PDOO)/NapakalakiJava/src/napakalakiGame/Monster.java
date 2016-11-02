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
public class Monster {
    private String name;
    private int combatLevel;
    private BadConsequence bc;
    private Prize price;
    private int levelChangeAgainstCultistPlayer;
    
    
    public Monster(String name , int level , BadConsequence bc , Prize price){
    this.name = name;
    this.combatLevel = level;
    this.bc= bc;
    this.price = price;
    this.levelChangeAgainstCultistPlayer=0;
    }
    
    public Monster(String n , int l , BadConsequence badConsequence , Prize p , int IC){
    this.name=n;
    this.combatLevel=l;
    this.bc=badConsequence;
    this.price=p;
    this.levelChangeAgainstCultistPlayer=IC;
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        int salida;
        salida= combatLevel+levelChangeAgainstCultistPlayer;
     return salida;
    }
    
    public String getName(){
      return this.name;
    }
    public int getCombatLevel(){
      return this.combatLevel;
    }
    public BadConsequence getBadConsequence(){
      return this.bc;
    }
    public Prize getPrize(){
      return this.price;
    }
    
    public int getLevelsGained(){
    return price.getLevel();
    }
    
    public int getTreasuresGained(){
    return price.getTreasures();
    }
    public String toString(){
        return "\n------------------------------------------------------------------"+ "\nname = " + this.name + "\ncombatLevel = " + Integer.toString(this.combatLevel) + bc.toString() + price.toString() ;
      
    
    }
}
