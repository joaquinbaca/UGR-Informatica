# -*- coding: utf-8 -*-
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require 'singleton'
require_relative 'treasure.rb'
require_relative 'treasure_kind'
require_relative 'bad_consequence.rb'
require_relative 'prize.rb'
require_relative 'monster.rb'
require_relative 'cultist.rb'
require_relative 'specific_bad_consequence.rb'
require_relative 'numeric_bad_consequence.rb'
require_relative 'death_bad_consequence.rb'
class CardDealer
  include Singleton
  
  def initialize
    @unusedMonsters = Array.new
    @usedMonsters = Array.new
    @unusedTreasures = Array.new
    @usedTreasures = Array.new
    @unusedCultists = Array.new
  end
  private
  def initTreasureCardDeck()
      @unusedTreasures << Treasure.new("!Si mi amo!",4,TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("botas de investigacion",3,TreasureKind::SHOES)
      @unusedTreasures << Treasure.new("capucha de cthulhu",3,TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("a prueba de babas",2,TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("botas de lluvia acida",1,TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("casco minero",2,TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("ametralladora Thompson",4,TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("camiseta de la ugr",1,TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("clavo de rail ferroviario",3,TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("cuchillo de sushi arcano",2,TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("fez alopodo",3,TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("hacha prehistorica",2,TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("el aparato del pr tesla",4,TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("gaita",4,TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("insecticida",2,TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("escopeta de 3 canones",4,TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("garabato mistico",2,TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("la rebeca metalica",2,TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("lanzallamas",4,TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("necro-cromicon",1,TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("necronomicon",5,TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("linterna a 2 manos",3,TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("necro-gnomicon",2,TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("necrotelecon",2,TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("mazo de los antiguos",3,TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("necro-playboycon",3,TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("porra preternatural",2,TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("shogulador",1,TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("varita de atizamiento",3,TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("tentaculo de pega",2,TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("zapato deja-amigos",1,TreasureKind::SHOES) 
  end
  
  def initMonsterCardDeck()
badConsequence = SpecificBadConsequence.new('Pierdes tu armadura visible y otra oculta',0,[TreasureKind::ARMOR],[TreasureKind::ARMOR])
prize = Prize.new(2,1)
@unusedMonsters << Monster.new("3 Byakhees de bonanza" , 8 , badConsequence , prize)

badConsequence = SpecificBadConsequence.new("Embobados con el lindo primigenio te descartas de tu casco visible",0,[TreasureKind::HELMET],[])
prize = Prize.new(1,1)
@unusedMonsters << Monster.new("Chibithulhu",2,badConsequence,prize)

badConsequence = SpecificBadConsequence.new("El primordial bostezo contagioso.Pierdes el calzado visible",0,[TreasureKind::SHOES],[])
prize = Prize.new(1,1)
@unusedMonsters << Monster.new("El sopor de Dunwith",2,badConsequence,prize)

badConsequence = SpecificBadConsequence.new("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo.Descarta una mano visible y 1 mano oculta",0,[TreasureKind::ONEHAND],[TreasureKind::ONEHAND])
prize = Prize.new(4,1)
@unusedMonsters << Monster.new("Angeles de la noche ibicenca",14,badConsequence,prize)

badConsequence = NumericBadConsequence.new("Pierdes todos tus tesoros visibles",0,10,0)
prize = Prize.new(3,1)
@unusedMonsters << Monster.new("El gorron del umbral",10,badConsequence,prize)

badConsequence = SpecificBadConsequence.new("Pierdes la armadura visible",0,[TreasureKind::HELMET],[])
prize = Prize.new(2,1)
@unusedMonsters << Monster.new("H.P Munchcraf",6,badConsequence,prize)

badConsequence = SpecificBadConsequence.new("Sientes bichos bajo la ropa.Descarta tu armdadura visible",0,[TreasureKind::ARMOR],[])
prize = Prize.new(1,1)
@unusedMonsters << Monster.new("bichgooth",2,badConsequence,prize)

badConsequence = NumericBadConsequence.new("Pierdes 5 niveles y tres tesoros visibles",6,3,0)
prize = Prize.new(4,2)
@unusedMonsters << Monster.new("El rey de rosa",13,badConsequence ,prize)

badConsequence = NumericBadConsequence.new("toses los pulmones y pierdes 2 niveles",2,0,0)
prize = Prize.new(1,1)
@unusedMonsters << Monster.new("La que redacta en las tinieblas",2,badConsequence,prize)

badConsequence = DeathBadConsequence.new("Estos Monstruos resultan bastantes superficiales y te aburren mortalmente.Estas Muerto")
prize = Prize.new(2,1)
@unusedMonsters << Monster.new("Los hondos",8,badConsequence,prize)

badConsequence = NumericBadConsequence.new("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2)
prize = Prize.new(2,1)
@unusedMonsters << Monster.new("Semillas cthulhu",4,badConsequence,prize)

badConsequence = SpecificBadConsequence.new("Te intentas escaquear.Pierdes una mano visible",0,[TreasureKind::ONEHAND],[])
prize = Prize.new(2,1)
@unusedMonsters << Monster.new("Dameargo",1,badConsequence,prize)

badConsequence = NumericBadConsequence.new("Da mucho asquito.Pierdes 3 niveles",3,0,0)
prize = Prize.new(1,1)
@unusedMonsters << Monster.new("pollipolipo volante",3,badConsequence,prize)
       
badConsequence = DeathBadConsequence.new("No le hace gracia que pronuncien mal su nombre.Estas muerto")
prize = Prize.new(3,1)
@unusedMonsters << Monster.new("y hsfjask-goth",12,badConsequence,prize)

badConsequence = DeathBadConsequence.new("la familia te atrapa estas muerto")
prize = Prize.new(4,1)
@unusedMonsters << Monster.new("Familia feliz",1,badConsequence,prize)

badConsequence = SpecificBadConsequence.new("la quinta directiva primera te obliga a perder 2 niveles y un tesoro 2 manos visibles",2,[TreasureKind::BOTHHANDS],[])
prize = Prize.new(2,1)
@unusedMonsters <<Monster.new("robogoth",8,badConsequence,prize)

badConsequence = SpecificBadConsequence.new("te asusta en la noche .Pierdes un casco visible",0,[TreasureKind::HELMET],[])
prize = Prize.new(1,1)
@unusedMonsters << Monster.new("El espia",5,badConsequence,prize)

badConsequence = NumericBadConsequence.new("menudo susto te llevas.Pierdes 2 niveles y 5 tesoros visibles",2,5,0)
prize = Prize.new(1,1)
@unusedMonsters << Monster.new("El lenguas",20,badConsequence,prize)

badConsequence = SpecificBadConsequence.new("te faltan manos para tanta cabeza .pierdes 3 niveles y tus tesoros visibles de las manos",3,[TreasureKind::BOTHHANDS,TreasureKind::ONEHAND,TreasureKind::ONEHAND],0);
prize = Prize.new(1,1)
@unusedMonsters << Monster.new("Bicefalo",20,badConsequence,prize)   

       badConsequence = SpecificBadConsequence.new("pierdes 1 mano visible",0,[TreasureKind::ONEHAND],[])
       prize = Prize.new(3,1)
       @unusedMonsters << Monster.newMonsterCultist("El mal indecible impronunciable",10,badConsequence,prize,-2)
       
       badConsequence = NumericBadConsequence.new("pierdes tus tesoros visibles.jajajaj",2,10,0)
       prize = Prize.new(2,1)
       @unusedMonsters << Monster.newMonsterCultist("Testigos oculares",6,badConsequence,prize,2)
       
       badConsequence = DeathBadConsequence.new("hoy no es tu dia de suerte mueres")
       prize = Prize.new(2,5)
       @unusedMonsters << Monster.newMonsterCultist("El gran cthulhu",20,badConsequence,prize,4)
       
       badConsequence = NumericBadConsequence.new("tu gobierno te recorta 2 niveles",2,0,0)
       prize = Prize.new(2,1)
       @unusedMonsters << Monster.newMonsterCultist("serpiente politico",8,badConsequence,prize,-2)
       
       badConsequence = SpecificBadConsequence.new("pierdes tu casco y tu armadura visible.pierdes tus manos ocultas",0,[TreasureKind::HELMET,TreasureKind::ARMOR],[TreasureKind::ONEHAND,TreasureKind::ONEHAND])
       prize = Prize.new(1,1)
       @unusedMonsters << Monster.newMonsterCultist("felpugoht",2,badConsequence,prize,5)
       
       badConsequence = NumericBadConsequence.new("pierdes 2 niveles",2,0,0)
       prize = Prize.new(4,2)
       @unusedMonsters << Monster.newMonsterCultist("shoggoth",16,badConsequence,prize,-4)
       
       badConsequence = NumericBadConsequence.new("pintalabios negro pierdes 2 niveles",2,0,0)
       prize = Prize.new(1,1)
       @unusedMonsters << Monster.newMonsterCultist("lolitahgoth",2,badConsequence,prize,3)

    
  end
  
  def shuffleTreasures()
    @unusedTreasures.shuffle!
  end
  
  def shuffleMonsters()
    @unusedMonsters.shuffle!
  end
  
  public
  
  def nextTreasure()
      
    if(@unusedTreasures.empty?)
            @unusedTreasures << @usedTreasures
            shuffleTreasures()
            @usedTreasures.clear
        end
        salida = @unusedTreasures.at(0)
        @unusedTreasures.delete(salida)
    return salida
  end
  
  def nextMonster()
     if(@unusedMonsters.empty?)
            @unusedTreasures << @usedMonsters
            shuffleMonsters()
            @usedMonsters.clear
        end
        salida = @unusedMonsters.at(0)
        @unusedMonsters.delete(salida)  
    return salida
  end
  
  def giveTreasureBack(t)
    @usedTreasures << t
  end
  
  def giveMonsterBack(m)
    @usedMonsters << m
  end
  
  def initCards()
    initTreasureCardDeck()
    initMonsterCardDeck()
    initCultistCardDeck()
    shuffleTreasures()
    shuffleMonsters()
    shuffleCultist()
  end
  
  private
  def shuffleCultist()
    @unusedCultists.shuffle!
  end
  
  def initCultistCardDeck()
    @unusedCultists << Cultist.new("Sectario",1)
    @unusedCultists << Cultist.new("Sectario",2)
    @unusedCultists << Cultist.new("Sectario",1)
    @unusedCultists << Cultist.new("Sectario",2)
    @unusedCultists << Cultist.new("Sectario",1)
    @unusedCultists << Cultist.new("Sectario",1)
  end
  
  public
  def nextCultist()
    @unusedCultists.shuffle!
    salida = @unusedCultists.at(0) 
    return salida
  end
  
end

