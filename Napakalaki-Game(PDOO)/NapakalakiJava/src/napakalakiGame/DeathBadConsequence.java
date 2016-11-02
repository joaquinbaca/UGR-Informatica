/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author joaquin
 */
public class DeathBadConsequence extends NumericBadConsequence{
    private boolean death;
    
      public DeathBadConsequence(String text, boolean death){
      super(text,10,10,10);
      this.death=death;
      }
      
      public boolean getDeath(){
        return this.death;
      }
    @Override
    public boolean isEmpty(){
      boolean salida=false;
      if(super.getNVisibleTreasures()==0 && super.getNHiddenTreasures()==0 && death==false)
        salida=true;
      return salida;
    }
    @Override
    public void substractVisibleTreasure(Treasure t){
     
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
       
    }
      
      @Override
      public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v ,ArrayList<Treasure> h ){
        BadConsequence salida = null;
        int visible = 0;
        int hidden = 0;

        if(super.getNHiddenTreasures()!=0 || super.getNVisibleTreasures()!=0){
            if(super.getNHiddenTreasures()>h.size()){
               hidden=h.size();
            }else{
               hidden = super.getNHiddenTreasures();
            }
            if(super.getNVisibleTreasures()>v.size()){
               visible = v.size();
            }else{
               visible = super.getNVisibleTreasures();
            }
            salida = new NumericBadConsequence(super.getText(),super.getLevels(),visible,hidden);
        }
    return salida;
    }
    @Override
    public String toString(){
        return "\ntext = " + super.getText() +  "\nDeath = " + Boolean.toString(death) ;
    
    }
}
