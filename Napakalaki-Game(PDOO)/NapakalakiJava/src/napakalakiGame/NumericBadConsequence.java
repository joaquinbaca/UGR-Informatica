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
public class NumericBadConsequence extends BadConsequence {
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
     public NumericBadConsequence(String text,int levels,int nVisible,int nHidden){
         super(text,levels);
         this.nVisibleTreasures=nVisible;
         this.nHiddenTreasures=nHidden;
    
    }
     
    public int getNVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    @Override
    public boolean isEmpty(){
      boolean salida=false;
      if( nVisibleTreasures==0 && nHiddenTreasures==0 )
        salida=true;
      return salida;
    }
    @Override
    public void substractVisibleTreasure(Treasure t){
           if(nVisibleTreasures<0)
              nVisibleTreasures--;
              
              
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
         if(nHiddenTreasures<0)
              nHiddenTreasures--;
    }
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v ,ArrayList<Treasure> h ){
        BadConsequence salida = null;
        int visible = 0;
        int hidden = 0;

        if(nHiddenTreasures!=0 || nVisibleTreasures!=0){
            if(nHiddenTreasures>h.size()){
               hidden=h.size();
            }else{
               hidden = nHiddenTreasures;
            }
            if(nVisibleTreasures>v.size()){
               visible = v.size();
            }else{
               visible = nVisibleTreasures;
            }
            salida = new NumericBadConsequence(super.getText(),super.getLevels(),visible,hidden);
        }
    return salida;
    }
    @Override
    public String toString(){
        return "\ntext = " + super.getText() + "\nlevels = " + Integer.toString(super.getLevels()) + "\nVisible-treasures = " + 
                Integer.toString(this.nVisibleTreasures) + "\nHidden-treasures = " + Integer.toString(this.nHiddenTreasures);
    
    }
}
