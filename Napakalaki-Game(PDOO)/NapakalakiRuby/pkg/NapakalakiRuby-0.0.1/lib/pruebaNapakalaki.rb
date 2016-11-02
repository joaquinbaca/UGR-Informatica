# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#encoding: utf-8
require_relative 'monster.rb'
require_relative 'prize.rb'
require_relative 'bad_consequence'
require_relative 'treasure_kind.rb'
require_relative 'player.rb'
monsters = Array.new


badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura visible y otra oculta',0,[TreasureKind::ARMOR],[TreasureKind::ARMOR])
prize = Prize.new(2,1)
monsters << Monster.new("3 Byakhees de bonanza" , 8 , badConsequence , prize)

badConsequence = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible",0,[TreasureKind::HELMET],[])
prize = Prize.new(1,1)
monsters << Monster.new("Chibithulhu",2,badConsequence,prize)

badConsequence = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso.Pierdes el calzado visible",0,[TreasureKind::SHOES],[])
prize = Prize.new(1,1)
monsters << Monster.new("El sopor de Dunwith",2,badConsequence,prize)

badConsequence = BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo.Descarta una mano visible y 1 mano oculta",0,[TreasureKind::ONEHAND],[TreasureKind::ONEHAND])
prize = Prize.new(4,1)
monsters << Monster.new("Angeles de la noche ibicenca",14,badConsequence,prize)

badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles",0,100,0)
prize = Prize.new(3,1)
monsters << Monster.new("El gorron del umbral",10,badConsequence,prize)

badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible",0,[TreasureKind::HELMET],[])
prize = Prize.new(2,1)
monsters << Monster.new("H.P Munchcraf",6,badConsequence,prize)

badConsequence = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa.Descarta tu armdadura visible",0,[TreasureKind::ARMOR],[])
prize = Prize.new(1,1)
monsters << Monster.new("bichgooth",2,badConsequence,prize)

badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y tres tesoros visibles",6,3,0)
prize = Prize.new(4,2)
monsters << Monster.new("El rey de rosa",13,badConsequence ,prize)

badConsequence = BadConsequence.newLevelNumberOfTreasures("toses los pulmones y pierdes 2 niveles",2,0,0)
prize = Prize.new(1,1)
monsters << Monster.new("La que redacta en las tinieblas",2,badConsequence,prize)

badConsequence = BadConsequence.newDeath("Estos Monstruos resultan bastantes superficiales y te aburren mortalmente.Estas Muerto")
prize = Prize.new(2,1)
monsters << Monster.new("Los hondos",8,badConsequence,prize)

badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2)
prize = Prize.new(2,1)
monsters << Monster.new("Semillas cthulhu",4,badConsequence,prize)

badConsequence = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear.Pierdes una mano visible",0,[TreasureKind::ONEHAND],[])
prize = Prize.new(2,1)
monsters << Monster.new("Dameargo",1,badConsequence,prize)

badConsequence = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito.Pierdes 3 niveles",3,0,0)
prize = Prize.new(1,1)
monsters << Monster.new("pollipolipo volante",3,badConsequence,prize)
       
badConsequence = BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre.Estas muerto")
prize = Prize.new(3,1)
monsters << Monster.new("y hsfjask-goth",12,badConsequence,prize)

badConsequence = BadConsequence.newDeath("la familia te atrapa estas muerto")
prize = Prize.new(4,1)
monsters << Monster.new("Familia feliz",1,badConsequence,prize)

badConsequence = BadConsequence.newLevelSpecificTreasures("la quinta directiva primera te obliga a perder 2 niveles y un tesoro 2 manos visibles",2,[TreasureKind::BOTHHANDS],[])
prize = Prize.new(2,1)
monsters<<Monster.new("robogoth",8,badConsequence,prize)

badConsequence = BadConsequence.newLevelSpecificTreasures("te asusta en la noche .Pierdes un casco visible",0,[TreasureKind::HELMET],[])
prize = Prize.new(1,1)
monsters << Monster.new("El espia",5,badConsequence,prize)

badConsequence = BadConsequence.newLevelNumberOfTreasures("menudo susto te llevas.Pierdes 2 niveles y 5 tesoros visibles",2,5,0)
prize = Prize.new(1,1)
monsters << Monster.new("El lenguas",20,badConsequence,prize)

badConsequence = BadConsequence.newLevelSpecificTreasures("te faltan manos para tanta cabeza .pierdes 3 niveles y tus tesoros visibles de las manos",3,[TreasureKind::BOTHHANDS,TreasureKind::ONEHAND,TreasureKind::ONEHAND],0);
prize = Prize.new(1,1)
monsters << Monster.new("Bicefalo",20,badConsequence,prize)
#------------------------------------------------------------------------------------------

v=Array.new
h=Array.new
q=Array.new
q.push(TreasureKind::HELMET)
q.push(TreasureKind::HELMET)
q.push(TreasureKind::HELMET)
bc = BadConsequence.newLevelSpecificTreasures("te asusta en la noche .Pierdes un casco visible",0,q,[])
v << Treasure.new("!Si mi amo!",4,TreasureKind::ARMOR)
h << Treasure.new("!Si mi amo!",4,TreasureKind::HELMET)
ac=bc.adjustToFitTreasureLists(v, h)
puts ac.to_s
#price = Prize.new(2,3)
#monster=Monster.new("tito-yayo",3,bc,price)
#P = Player.new("pepe")
#puts P.isDead()
#monsters.each do |i|
#  if (!i.bc.specificVisibleTreasures.empty? && !i.bc.specificHiddenTreasures.empty?)
   
  #puts i.to_s
#end
#end