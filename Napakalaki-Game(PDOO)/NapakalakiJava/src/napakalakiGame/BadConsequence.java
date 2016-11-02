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
public abstract class BadConsequence {
    final int MAXTREASURES = 10;
    private String text;
    private int levels; 
   // private int nVisibleTreasures;
   // private int nHiddenTreasures;
    //private boolean death;
   // private ArrayList<TreasureKind> specificHiddenTreasures= new ArrayList();
    //private ArrayList<TreasureKind> specificVisibleTreasures= new ArrayList();
    
    public BadConsequence(String text ,int levels){
         this.text=text;
         this.levels=levels;
    }
    /*public BadConsequence(String text,int levels,int nVisible,int nHidden){
         this.text=text;
         this.levels=levels;
         this.nVisibleTreasures=nVisible;
         this.nHiddenTreasures=nHidden;
    
    }*/
    
   /* public BadConsequence(String text , int levels , ArrayList<TreasureKind> tVisible , ArrayList<TreasureKind> tHidden){
         this.text=text;
         this.levels=levels;
         this.specificVisibleTreasures=tVisible;
         this.specificHiddenTreasures=tHidden;
    }*/
    /*
    public BadConsequence(String text, boolean death){
        this.text=text;
        this.death=death;
        this.levels=10;
        this.nHiddenTreasures=MAXTREASURES;
        this.nVisibleTreasures=MAXTREASURES;
    }
    */
    public abstract boolean isEmpty();
    /*public boolean isEmpty(){
      boolean salida=false;
      if(levels==0 && nVisibleTreasures==0 && nHiddenTreasures==0 && death==false && specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty())
        salida=true;
      return salida;
    }*/
    public String getText(){
        return this.text;
    }
    
    public int getLevels(){
        return this.levels;   
    }
    
 /*   public int getNVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    */
   /* public boolean getDeath(){
        return this.death;
    }
    */
   /* public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return this.specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return this.specificHiddenTreasures;
    }
    */
     public abstract void substractVisibleTreasure(Treasure t);
     public abstract void substractHiddenTreasure(Treasure t);
     /*
    public void substractVisibleTreasure(Treasure t){
          if(specificVisibleTreasures.contains(t))
              specificVisibleTreasures.remove(t);
          else if(nVisibleTreasures<0)
              nVisibleTreasures--;
              
              
    }
    
    public void substractHiddenTreasure(Treasure t){
         if(specificHiddenTreasures.contains(t))
              specificHiddenTreasures.remove(t);
          else if(nHiddenTreasures<0)
              nHiddenTreasures--;
    }
    */
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v ,ArrayList<Treasure> h );
    /*public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v ,ArrayList<Treasure> h ){
        BadConsequence salida = null;
        int visible = 0;
        int hidden = 0;
        ArrayList<TreasureKind> copiaVisible = new ArrayList();
        ArrayList<TreasureKind> copiaHidden = new ArrayList();
        ArrayList<TreasureKind> specificVisible = new ArrayList(specificVisibleTreasures);
        ArrayList<TreasureKind> specificHidden = new ArrayList(specificHiddenTreasures);
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
            salida = new BadConsequence(this.text,this.levels,visible,hidden);
        }else{
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
        salida=new BadConsequence(this.text,this.levels,copiaVisible,copiaHidden);
        }
    return salida;
    }
    
    
    
    */
    
    
    
    public abstract String toString();
  /*  public String toString(){
        return "\ntext = " + this.text + "\nlevels = " + Integer.toString(this.levels) + "\nVisible-treasures = " + 
                Integer.toString(this.nVisibleTreasures) + "\nHidden-treasures = " + Integer.toString(this.nHiddenTreasures)
                + "\nDeath = " + Boolean.toString(death) + "\nSpecific-Visible-treasures = " + specificVisibleTreasures.toString()
                + "\nSpecific-hidden-treasures = " + specificHiddenTreasures.toString();
    
    }*/
}
