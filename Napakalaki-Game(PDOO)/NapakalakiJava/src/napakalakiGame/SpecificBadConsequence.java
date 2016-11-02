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
public class SpecificBadConsequence extends BadConsequence{
    private ArrayList<TreasureKind> specificHiddenTreasures= new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures= new ArrayList();
    
    public SpecificBadConsequence(String text , int levels , ArrayList<TreasureKind> tVisible , ArrayList<TreasureKind> tHidden){
         super(text,levels);
         this.specificVisibleTreasures=tVisible;
         this.specificHiddenTreasures=tHidden;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return this.specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return this.specificHiddenTreasures;
    }
    @Override
    public boolean isEmpty(){
      boolean salida=false;
      if(specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty())
        salida=true;
      return salida;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
      if(specificVisibleTreasures.contains(t))
              specificVisibleTreasures.remove(t);
    }
    @Override
    public void substractHiddenTreasure(Treasure t){
      if(specificHiddenTreasures.contains(t))
              specificHiddenTreasures.remove(t);
     }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v ,ArrayList<Treasure> h ){
        BadConsequence salida = null;
        ArrayList<TreasureKind> copiaVisible = new ArrayList();
        ArrayList<TreasureKind> copiaHidden = new ArrayList();
        ArrayList<TreasureKind> specificVisible = new ArrayList(specificVisibleTreasures);
        ArrayList<TreasureKind> specificHidden = new ArrayList(specificHiddenTreasures);

        if(!specificVisibleTreasures.isEmpty()){
            boolean salir= false;
        for(Treasure pv:v){
            if(salir){
            specificVisible.remove(pv.getType());
            salir=false;
            }
            for(TreasureKind bv:specificVisible){
                if(pv.getType()==bv && !salir){
                    copiaVisible.add(bv);
                    salir=true;
                }
            }
        }}
        if(!specificHiddenTreasures.isEmpty()){
            boolean salir=false;
        for(Treasure ph:h){
            if(salir){
            specificHidden.remove(ph.getType());
            salir=false;
            }
            for(TreasureKind bh:specificHidden){
                if(ph.getType()==bh && !salir){
                    copiaHidden.add(bh);
                    salir=true;
                }
            }
        }}
        salida=new SpecificBadConsequence(super.getText(),super.getLevels(),copiaVisible,copiaHidden);
        
    return salida;
    }
    @Override
    public String toString(){
        return "\ntext = " + super.getText() + "\nlevels = " + Integer.toString(super.getLevels()) +  "\nSpecific-Visible-treasures = " + specificVisibleTreasures.toString()
                + "\nSpecific-hidden-treasures = " + specificHiddenTreasures.toString();
    
    }
}
