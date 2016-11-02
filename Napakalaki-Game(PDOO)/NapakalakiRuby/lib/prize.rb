# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#encoding: utf-8
class Prize
  attr_reader:treasures
  attr_reader:level
  
  def initialize(treasures,level)
    @treasures=treasures
    @level=level
  end
  
  
  
  def to_s
    "tesoros ganados: #{@treasures}\n Niveles Ganados: #{@level}"
  end
  
end
