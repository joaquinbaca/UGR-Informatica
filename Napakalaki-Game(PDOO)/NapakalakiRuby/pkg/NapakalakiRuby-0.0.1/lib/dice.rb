# -*- coding: utf-8 -*-
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require 'singleton'
class Dice
  
  include Singleton
  private
  def initialize
    
  end
  
  public
  
  def nextNumber()
    r = Random.new
    n = r.rand(1..6)
    
    return n

  end
end
