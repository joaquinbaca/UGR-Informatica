# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative 'monster.rb'
class CultistPlayer < Player
  
  @@totalCultistPlayers=0
  
  def initialize(p,c)
    super(p)
       @myCultistCard=c
       @@totalCultistPlayers=@@totalCultistPlayers+1
  end
  
    def getCombatLevel()
       salida=((super+super*0.2 + @myCultistCard.getGainedLevels())*@@totalCultistPlayers).to_i
       return salida
    end
    
    def getOponentLevel(m)
        salida=m.getCombatLevelChangeAgainstCultistPlayer()
    return salida
    end
    
    def shouldConvert()
        salida=false
        return salida
    end
 
    def giveMeATreasure()
        r = Random.new
        numero = r.rand(0..@visibleTreasures.size())
        tesoro= @visibleTreasures.at(numero)
       return tesoro
    end
    
    def canYouGiveMeATreasure()
       salida=true
      if(@visibleTreasures.empty? && @hiddenTreasures.empty?)
          salida=false
      end
     return salida
    end
    
    public
    def getTotalCultistPlayers()
      return @totalCultistPlayers;
    end
end
