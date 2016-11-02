# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative 'card_dealer'
require 'bad_consequence.rb'
class NumericBadConsequence < BadConsequence
  
  attr_reader:nVisibleTreasures ,:nHiddenTreasures
  public_class_method:new
  
  def initialize(aText,someLevels,someVisibleTreasures,someHiddenTreasures)
    super(aText,someLevels)
    @nVisibleTreasures=someVisibleTreasures
    @nHiddenTreasures=someHiddenTreasures
  end
  
  
  def isEmpty()
    salida=false
    if(@nVisibleTreasures==0 && @nHiddenTreasures==0)
      salida=true
    end
    return salida
  end
  
   def substractVisibleTreasure(t)
    if(@nVisibleTreasures<0)
              @nVisibleTreasures= @nVisibleTreasures-1
    end
  end
  
  def substractHiddenTreasure(t)
    if(@nHiddenTreasures<0)
              @nHiddenTreasures= @nHiddenTreasures-1
    end
  end
  
  def adjustToFitTreasureLists(v,h)
        salida = nil
        visible = 0
        hidden = 0
        if(@nHiddenTreasures!=0 || @nVisibleTreasures!=0)
            if(@nHiddenTreasures>h.size())
               hidden=h.size()
            else
               hidden = @nHiddenTreasures
            end
            if(@nVisibleTreasures>v.size())
               visible = v.size()
            else
               visible = @nVisibleTreasures
            end
            salida = NumericBadConsequence.new(text,levels,visible,hidden)
        
        end
    return salida
  end
  
  def to_s
    "texto: #{text} \n niveles: #{levels} \n nVisibleTreasures: #{@nVisibleTreasures} \n nHiddenTreasures: #{@nHiddenTreasures}"
  end
end
