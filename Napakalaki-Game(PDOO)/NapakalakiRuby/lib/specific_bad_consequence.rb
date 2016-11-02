# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative 'card_dealer'
require 'bad_consequence.rb'
class SpecificBadConsequence < BadConsequence
  
  attr_reader:specificVisibleTreasures ,:specificHiddenTreasures
  public_class_method:new
  
  def initialize(aText,someLevels,someSpecificVisibleTreasures,someSpecificHiddenTreasures)
    super(aText,someLevels)
    @specificVisibleTreasures=someSpecificVisibleTreasures
    @specificHiddenTreasures= someSpecificHiddenTreasures
  end
  
  def isEmpty()
    salida=false
    if(@specificVisibleTreasures.empty? && @specificHiddenTreasures.empty?)
      salida=true
    end
    return salida
  end
  
   def substractVisibleTreasure(t)
    if(@specificVisibleTreasures.include?(t))
              @specificVisibleTreasures.remove(t)
    end
  end
  
  def substractHiddenTreasure(t)
    if(@specificHiddenTreasures.include?(t))
              @specificHiddenTreasures.remove(t)
    end
  end
  
  def adjustToFitTreasureLists(v,h)
        salida = nil
        copiaVisible = Array.new
        copiaHidden = Array.new
        specificVisible = Array.new(@specificVisibleTreasures)
        specificHidden = Array.new(@specificHiddenTreasures)
          if(!@specificVisibleTreasures.empty?)
            salir= false
            v.each do |pv|
            if(salir)
            specificVisible.delete(pv.getType())
            salir=false
            end
            specificVisible.each do |bv|
                if(pv.getType()==bv && !salir)
                    copiaVisible.push(bv)
                    salir=true
                end
            end
        end
      end
      if(!@specificHiddenTreasures.empty?)
            salir=false
            h.each do |ph|
            if(salir)
            specificHidden.delete(ph.getType())
            salir=false
            end
            specificHidden.each do |bh|
                if(ph.getType()==bh && !salir)
                    copiaHidden.push(bh)
                    salir=true
                end
            end
        end
        end
        salida=SpecificBadConsequence.new(text,levels,copiaVisible,copiaHidden)
    return salida
  end
  
  def to_s
    "texto: #{text} \n niveles: #{levels} \n nSpecificHiddenTreassures: #{@specificHiddenTreasures} \n nSpecificVisibleTreasures: #{@specificVisibleTreasures}"
  end
end
