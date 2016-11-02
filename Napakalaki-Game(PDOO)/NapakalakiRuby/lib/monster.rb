# -*- coding: utf-8 -*-
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
class Monster
  attr_reader:name,:combatLevel,:bc,:price 
  
  def initialize(name,level,bc,price)
    @name=name
    @combatLevel=level
    @bc=bc
    @price=price
    @levelChangeAgainstCultistPlayer=0
  end
  
  def Monster.newMonsterCultist(name,level,bc,price,levelChange)
    g= new(name,level,bc,price)
    @levelChangeAgainstCultistPlayer=levelChange
    g
  end
  
  def getCombatLevelChangeAgainstCultistPlayer()
        salida= @combatLevel+@levelChangeAgainstCultistPlayer
    return salida
  end
  
  def getLevelsGained()
    @price.level
  end
  
  def getTreasuresGained()
    @price.treasures
  end
  
  def to_s
    "\n--------------------------------------------\n Nombre: #{@name}\n Nivel de combate: #{@combatLevel} \n #{@bc} \n #{@price} \n nivel de cultist #{@levelChangeAgainstCultistPlayer}"
  end
end
