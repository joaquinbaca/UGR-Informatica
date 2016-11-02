# -*- coding: utf-8 -*-
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative 'dice.rb'
require_relative 'treasure.rb'
require_relative 'combat_result.rb'
class Player
  attr_reader :name ,:MAXLEVEL , :enemy , :pendingBadConsequence , :enemy
  MAXLEVEL=10
  def initialize(name)
    @name=name
    @level=0
    @dead=true
    @canISteal=true
    @enemy=nil
    @hiddenTreasures=Array.new
    @visibleTreasures=Array.new
    @pendingBadConsequence=nil
    
  end
  
  def Player.newCopia(p)
    new(p.name)
    @level=p.getLevels
    @dead=p.isDead
    @canISteal=p.canISteal
    @enemy=p.enemy
    @hiddenTreasures=p.getHiddenTreasures
    @visibleTreasures=p.getVisibleTreasures
    @pendingBadConsequence=p.pendingBadConsequence
  end
  
  protected
  def getOponentLevel(m)
    return m.combatLevel
  end
  
  def shouldConvert()
     salida = false
     dado = Dice.instance
     d= dado.nextNumber()
     if(d==1)
         salida=true
     end
     return salida
  end
  
  
  def getCombatLevel()
    nivel=0
    @visibleTreasures.each do |i|
    nivel = nivel + i.bonus
    end
    nivel = nivel+@level
    return nivel
  end
  
  private
  
   def bringToLife()
    @dead=false
  end
  
  def incrementLevels(l)
    @level=@level+l
  end
  
  def decrementLevels(l)
    if(@level-l>0)
    @level = @level-l
    end
  end
  
  def setPendingBadConsequence(b)
    @pendingBadConsequence=b
  end
  
  def applyPrize(m)
     nLevels = m.getLevelsGained()
      incrementLevels(nLevels)
      nTreasures = m.getTreasuresGained();
      if(nTreasures>0)
         dealer = CardDealer.instance
         for i in 0..nTreasures
           treasure = dealer.nextTreasure()
           @hiddenTreasures.insert(treasure)
         end
      
      end
  end

  def applyBadConsequence(m)
      badConsequence = m.bc
      nLevels = badConsequence.levels
      decrementLevels(nLevels)
      pendingBad = badConsequence.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
      setPendingBadConsequence(pendingBad)
  end
  
  def canMakeTreasureVisible(t)
      salida = true
      p=0 
      @visibleTreasures.each do |treasure|
            if(treasure.getType()==t.getType() && TreasureKind::ONEHAND!=t.getType())
               salida=false
             else if(TreasureKind::ONEHAND==t.getType() && !@visibleTreasures.include?(TreasureKind::BOTHHANDS))
                  @visibleTreasures.each do |i|
                      if(i.getType()==TreasureKind::ONEHAND)
                          p=p+1
                      end
                  end
                 if(p>=2)
                     salida=false
                 end
            end
            end
      end
      return salida
  end
  
  def howManyVisibleTreasures(tKind)
      numero=0
      @visibleTreasures.each do |i| 
      if(i.getType()==tKind)
         numero=numero+1
      end
      end
     return numero 
  end
  
  def dielfNoTreasures()
    @dead=true
  end
  
  public
  
  def isDead()
     return @dead
  end
  
  def getMAXLEVEL()
    MAXLEVEL
  end
  def getHiddenTreasures()
    @hiddenTreasures
  end
  
  def getVisibleTreasures()
    @visibleTreasures
  end
  
  def combat(m)
      myLevel = getCombatLevel()
      monsterLevel = getOponentLevel(m)
      if(myLevel>monsterLevel)
         applyPrize(m)
         if(@level>=MAXLEVEL)
            resultado=NapakalakiGame::CombatResult::WINGAME
         else
            resultado = NapakalakiGame::CombatResult::WIN
         end
             
      else
         applyBadConsequence(m)
         resultado= NapakalakiGame::CombatResult::LOSE
         conv=shouldConvert()
         if(conv)
         resultado = NapakalakiGame::CombatResult::LOSEANDCONVERT
         end
      end
  return resultado
  end
  
  def makeTreasureVisible(t)
      canI = canMakeTreasureVisible(t)
       if(canI)
         @visibleTreasures.push(t)
         @hiddenTreasures.delete(t)
         
       end
  end
  
  def discardVisibleTreasure(t)
    @visibleTreasures.delete(t)
    if(@pendingBadConsequence!=nil && !@pendingBadConsequence.isEmpty())
             @pendingBadConsequence.substractVisibleTreasure(t)
      end
      dielfNoTreasures()
             
  end
  
  def discardHiddenTreasure(t)
      @hiddenTreasures.delete(t)
      if(@pendingBadConsequence!=nil && !@pendingBadConsequence.isEmpty())
             @pendingBadConsequence.substractHiddenTreasure(t)
      end
      dielfNoTreasures()
  end
  
  def validState()
    salida = false   
    if((@pendingBadConsequence==nil || @pendingBadConsequence.isEmpty) && @hiddenTreasures.size()<4)
          salida=true
      end
  return salida
  end
  
  def initTreasures()
      dealer = CardDealer.instance
      dice = Dice.instance
      bringToLife()
      treasure = dealer.nextTreasure()
      @hiddenTreasures.push(treasure)
      number = dice.nextNumber()
      if(number>1)
         treasure = dealer.nextTreasure()
         @hiddenTreasures.push(treasure)
      end
      if(number==6)
         treasure = dealer.nextTreasure()
         @hiddenTreasures.push(treasure)
      end
  end
  
  def getLevels()
    return @level
  end
  
  def stealTreasure()
      canI = canISteal()
      salida = nil
      if(canI)
        canYou = @enemy.canYouGiveMeATreasure()
        if(canYou)
           treasure = @enemy.giveMeATreasure()
           @hiddenTreasures.push(treasure)
           haveStolen()
           salida=treasure
        end
      end
  return salida
  end
  
  def setEnemy(enemy)
    @enemy=enemy
  end
  
  def canISteal()
    return @canISteal
  end
  
  def discardAllTreasures()
      copiaVisibleTreasures =Array.new(@visibleTreasures)
      copiaHiddenTreasures = Array.new(@hiddenTreasures)
      
      copiaVisibleTreasures.each do |treasure|
         discardVisibleTreasure(treasure)
      end
      
      copiaHiddenTreasures.each do |treasure|
         discardHiddenTreasure(treasure)
      end
      
  end
  
 
  public
  def giveMeATreasure()
      r = Random.new
      numero = r.rand(0..@hiddenTreasures.size())
      tesoro= @hiddenTreasures.at(numero)
    return tesoro
  end
  
  def canYouGiveMeATreasure()
     salida=true
     if(@visibleTreasures.empty? && @hiddenTreasures.empty?)
          salida=false
      end
    return salida
  end
  private
  def haveStolen()
    @canISteal=false
  end
  
  public
   def to_s() 
    
    "#{@name} (Nivel #{@level}) \nnivel de combate #{getCombatLevel}"

  end

 
  
end
