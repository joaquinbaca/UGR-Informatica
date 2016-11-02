/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author joaquin
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArrayList<Monster> unusedMonsters = new ArrayList();

       
       BadConsequence badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta",0,
        new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
       Prize prize = new Prize(2,1);
       unusedMonsters.add(new Monster("3 Byakhees de bonanza" , 8 , badConsequence , prize));
       
       badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible",0,
        new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList(Arrays.asList()));
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Chibithulhu",2,badConsequence,prize));
       
       badConsequence = new SpecificBadConsequence("El primordial bostezo contagioso.Pierdes el calzado visible",0,
        new ArrayList(Arrays.asList(TreasureKind.SHOES)),new ArrayList(Arrays.asList()));
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("El sopor de Dunwith",2,badConsequence,prize));
       
       badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo.Descarta una mano visible y 1 mano oculta",0,
        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
       prize = new Prize(4,1);
       unusedMonsters.add(new Monster("Angeles de la noche ibicenca",14,badConsequence,prize));
       
       badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles",0,badConsequence.MAXTREASURES,0);
       prize = new Prize(3,1);
       unusedMonsters.add(new Monster("El gorron del umbral",10,badConsequence,prize));
       
       badConsequence = new SpecificBadConsequence("Pierdes la armadura visible",0,
        new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList(Arrays.asList()));
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("H.P Munchcraf",6,badConsequence,prize));
       
       badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa.Descarta tu armdadura visible",0,
        new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList(Arrays.asList()));
       prize =new Prize(1,1);
       unusedMonsters.add(new Monster("bichgooth",2,badConsequence,prize));
       
       badConsequence = new NumericBadConsequence("Pierdes 5 niveles y tres tesoros visibles",6,3,0);
       prize = new Prize(4,2);
       unusedMonsters.add(new Monster("El rey de rosa",13,badConsequence ,prize));
       
       badConsequence = new NumericBadConsequence("toses los pulmones y pierdes 2 niveles",2,0,0);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("La que redacta en las tinieblas",2,badConsequence,prize));
       
       badConsequence = new DeathBadConsequence("Estos Monstruos resultan bastantes superficiales y te aburren mortalmente.Estas Muerto",true);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Los hondos",8,badConsequence,prize));
       
       badConsequence = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Semillas cthulhu",4,badConsequence,prize));
       
       badConsequence = new SpecificBadConsequence("Te intentas escaquear.Pierdes una mano visible",0,
        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList()));
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Dameargo",1,badConsequence,prize));
       
       badConsequence = new NumericBadConsequence("Da mucho asquito.Pierdes 3 niveles",3,0,0);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("pollipolipo volante",3,badConsequence,prize));
       
       badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre.Estas muerto",true);
       prize = new Prize(3,1);
       unusedMonsters.add(new Monster("y hsfjask-goth",12,badConsequence,prize));
       
       badConsequence = new DeathBadConsequence("la familia te atrapa estas muerto",true);
       prize = new Prize(4,1);
       unusedMonsters.add(new Monster("Familia feliz",1,badConsequence,prize));
       
       badConsequence = new SpecificBadConsequence("la quinta directiva primera te obliga a perder 2 niveles y un tesoro 2 manos visibles",2,
        new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),new ArrayList(Arrays.asList()));
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("robogoth",8,badConsequence,prize));
       
       badConsequence = new SpecificBadConsequence("te asusta en la noche .Pierdes un casco visible",0,
        new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList(Arrays.asList()));
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("El espia",5,badConsequence,prize));
       
       badConsequence = new NumericBadConsequence("menudo susto te llevas.Pierdes 2 niveles y 5 tesoros visibles",2,5,0);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("El lenguas",20,badConsequence,prize));
       
       badConsequence = new SpecificBadConsequence("te faltan manos para tanta cabeza .pierdes 3 niveles y tus tesoros visibles de las manos",3,new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND)),new ArrayList(Arrays.asList()));
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Bicefalo",20,badConsequence,prize));
       
       badConsequence = new SpecificBadConsequence("pierdes 1 mano visible",0,
        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList()));
       prize = new Prize(3,1);
       unusedMonsters.add(new Monster("El mal indecible impronunciable",10,badConsequence,prize,-2));
       
       badConsequence = new NumericBadConsequence("pierdes tus tesoros visibles.jajajaj",2,badConsequence.MAXTREASURES,0);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Testigos oculares",6,badConsequence,prize,2));
       
       badConsequence = new DeathBadConsequence("hoy no es tu dia de suerte mueres",true);
       prize = new Prize(2,5);
       unusedMonsters.add(new Monster("El gran cthulhu",20,badConsequence,prize,4));
       
       badConsequence = new NumericBadConsequence("tu gobierno te recorta 2 niveles",2,0,0);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("serpiente politico",8,badConsequence,prize,-2));
       
       badConsequence = new SpecificBadConsequence("pierdes tu casco y tu armadura visible.pierdes tus manos ocultas",0,
        new ArrayList(Arrays.asList(TreasureKind.HELMET,TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND)));
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("felpugoht",2,badConsequence,prize,5));
       
       badConsequence = new NumericBadConsequence("pierdes 2 niveles",2,0,0);
       prize = new Prize(4,2);
       unusedMonsters.add(new Monster("shoggoth",16,badConsequence,prize,-4));
       
       badConsequence = new NumericBadConsequence("pintalabios negro pierdes 2 niveles",2,0,0);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("lolitahgoth",2,badConsequence,prize,3));
       
       
       
       
       
       ArrayList<TreasureKind>f= new ArrayList();
       ArrayList<TreasureKind>d= new ArrayList();
       f.add(TreasureKind.HELMET);
       f.add(TreasureKind.HELMET);
        f.add(TreasureKind.HELMET);
        d.add(TreasureKind.ARMOR);
        BadConsequence ce = new NumericBadConsequence("te asusta en la noche .Pierdes un casco visible",0,
        3,5);
       
       System.out.println(ce.toString());
       
       BadConsequence salida ;
       ArrayList<Treasure>v= new ArrayList();
       ArrayList<Treasure>h= new ArrayList();
       v.add(new Treasure("!Si mi amo!",4,TreasureKind.HELMET));
       v.add(new Treasure("!Si mi amo!",4,TreasureKind.HELMET));
       //v.add(new Treasure("!Si mi amo!",4,TreasureKind.HELMET));
        h.add(new Treasure("!Si mi amo!",4,TreasureKind.HELMET));
       salida = ce.adjustToFitTreasureLists(v, h);
       
       System.out.println(salida.toString());
        
      /* for(int i=0;i<=monstruos.size()-1;i++){
          BadConsequence bc = monstruos.get(i).getBadConsequence();
          if(!bc.getSpecificHiddenTreasures().isEmpty() || !bc.getSpecificVisibleTreasures().isEmpty()){
          
           System.out.println(monstruos.get(i).toString());
          }
       
    }*/
    
    }
}
