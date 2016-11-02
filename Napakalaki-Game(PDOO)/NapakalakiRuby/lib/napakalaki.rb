# -*- coding: utf-8 -*-
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require 'singleton'
require_relative 'player.rb'
require_relative 'card_dealer.rb'
require_relative 'combat_result.rb'
require_relative 'cultist_player.rb'
class Napakalaki
  include Singleton
  
private
  
  def initialize()
    @currentPlayer=nil
    @players = Array.new
    @dealer = CardDealer.instance
    @currentMonster=nil
    
  end
  
  def initPlayers(names)
      names.each do |name|
      jugador = Player.new(name)
      
      @players.push(jugador) 
    end

  end
  
  def nextPlayer()
        if(@currentPlayer==nil)
           r = Random.new
           numero = r.rand(0...@players.size())
           jugador= @players.at(numero)
        else
           pos=@players.index(@currentPlayer)
           if(pos==@players.size()-1)
               pos=0
           else
               pos=pos+1
           end
           jugador=@players.at(pos)
        end
        @currentPlayer=jugador
    return jugador
  end
  
  def nextTurnAllowed()
        if(@currentPlayer==nil)
            puede=true
        else
           puede=@currentPlayer.validState()
        end
    return puede
  end
  def setEnemies()
           @players.each do |player|
             loop do
                 r = Random.new
                 numero = r.rand(0..@players.size()) 
                 jugador=@players.at(numero)
             break if jugador==player
             end
             player.setEnemy(player)
             
           end
  end
  
  public
  
  def developCombat()
        resultado= @currentPlayer.combat(@currentMonster)
        @dealer.giveMonsterBack(@currentMonster)
        if(resultado==NapakalakiGame::CombatResult::LOSEANDCONVERT)
          carta=@dealer.nextCultist()
          nuevo =CultistPlayer.new(@currentPlayer,carta)
          @players.each do|player|
             if(player.enemy==@currentPlayer)
             player.setEnemy(nuevo)
             end
          end
          @players.delete(@currentPlayer)
          @currentPlayer=nuevo
          @players.push(@currentPlayer)
        end
    return resultado
  end
  
  def discardVisibleTreasures(treasures)
      treasures.each do |treasure|
              @currentPlayer.discardVisibleTreasure(treasure)
              @dealer.giveTreasureBack(treasure)
      end
  end
  
  def discardHiddenTreasures(treasures)
    treasures.each do |treasure|
              @currentPlayer.discardHiddenTreasure(treasure)
              @dealer.giveTreasureBack(treasure)
      end
  end
  
  def makeTreasuresVisible(treasures)
    treasures.each do |t|
           @currentPlayer.makeTreasureVisible(t)
           
    end
  end
  
  def initGame(names)
       initPlayers(names)
       setEnemies()
       @dealer.initCards()
       nextTurn()
  end
  
  def getCurrentPlayer()
    return @currentPlayer
  end
  
  def getCurrentMonster()
    return @currentMonster
  end
  
  def nextTurn()
     
        stateOK = nextTurnAllowed()
        if(stateOK)
           @currentMonster=@dealer.nextMonster()
           @currentPlayer = nextPlayer()
           dead= @currentPlayer.isDead()
           if(dead)
              @currentPlayer.initTreasures()
           end
        
        end
    return stateOK
  end
  
  def endOfGame(result)
    salida= false
        if(result==CombatResult::WINGAME)
            salida=true
        end
    return salida
  end
end
