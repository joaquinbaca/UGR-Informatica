# -*- coding: utf-8 -*-
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#encoding: utf-8
require_relative 'card_dealer'
class BadConsequence
  
  attr_reader:text ,:levels 
  private_class_method:new
  @@MAXTREASURES=10
  
   def initialize(aText,someLevels)
    @text=aText
    @levels=someLevels
  end
 
  def isEmpty()
    raise NotImplementedError.new
  end
  
  def substractVisibleTreasure(t)
   raise NotImplementedError.new
  end
  
  def substractHiddenTreasure(t)
   raise NotImplementedError.new
  end
  
  def adjustToFitTreasureLists(v,h)
   raise NotImplementedError.new
  end
  
  def to_s
      raise NotImplementedError.new
  end
end
