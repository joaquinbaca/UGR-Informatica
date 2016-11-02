# Toc change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative 'card_dealer'
require 'numeric_bad_consequence.rb'
class DeathBadConsequence < NumericBadConsequence
  
  attr_reader:death
  public_class_method:new
  
  def initialize(aText)
    super(aText,10,10,10)
    @death=true
  end
  
  def isEmpty()
    salida=false
    if(super.nVisibleTreasures==0 && super.nHiddenTreasures==0 && @death==false)
      salida=true
    end
    return salida
  end
  
  def substractVisibleTreasure(t)
    super
  end
  
  def substractHiddenTreasure(t)
    super
  end
  
  def adjustToFitTreasureLists(v,h)
   super
  end
  
   def to_s
    "texto: #{text} \n muerte: #{@death} "
  end
end
