/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;

/**
 * @author joaquin
 */
public class Prize {
    private int treasures;
    private int level;
    
    public Prize(int treasures, int level){
       this.treasures=treasures;
       this.level=level;
    
    }
    
    public int getTreasures(){
        
        
       return this.treasures;
    }
    
    public int getLevel(){
        
        
       return this.level;
    }

    public String toString(){
    
    return "\nTreasures = " + Integer.toString(treasures)+ " \nlevels = " + Integer.toString(level);
    }

}
