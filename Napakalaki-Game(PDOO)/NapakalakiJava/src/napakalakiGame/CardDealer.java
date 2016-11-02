/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author joaquin
 */
public class CardDealer {
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Cultist> unusedCultists = new ArrayList();
    
    private CardDealer() {
    }
    
    public static CardDealer getInstance() {
        return CardDealerHolder.INSTANCE;
    }
    
    
    private void initTreasureCardDeck(){   
      unusedTreasures.add(new Treasure("!Si mi amo!",4,TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("botas de investigacion",3,TreasureKind.SHOES));
      unusedTreasures.add(new Treasure("capucha de cthulhu",3,TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("a prueba de babas",2,TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("botas de lluvia acida",1,TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("casco minero",2,TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("ametralladora Thompson",4,TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("camiseta de la ugr",1,TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("clavo de rail ferroviario",3,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("cuchillo de sushi arcano",2,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("fez alopodo",3,TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("hacha prehistorica",2,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("el aparato del pr tesla",4,TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("gaita",4,TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("insecticida",2,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("escopeta de 3 cañones",4,TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("garabato mistico",2,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("la rebeca metalica",2,TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("lanzallamas",4,TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("necro-cromicon",1,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("necronomicon",5,TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("linterna a 2 manos",3,TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("necro-gnomicon",2,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("necrotelecon",2,TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("mazo de los antiguos",3,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("necro-playboycon",3,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("porra preternatural",2,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("shogulador",1,TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("varita de atizamiento",3,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("tentaculo de pega",2,TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("zapato deja-amigos",1,TreasureKind.SHOES));   
      
      
      
      
      
      
      
      
      
    }
    
    private void initMonsterCardDeck(){
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
       
    }
    
    private void shuffleTreasures(){
      Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters(){
      Collections.shuffle(unusedMonsters);
    }
    
    public Treasure nextTreasure(){
        Treasure salida;
        if(unusedTreasures.isEmpty()){
            unusedTreasures.addAll(usedTreasures);
            this.shuffleTreasures();
            usedTreasures.clear();
        }
        salida = unusedTreasures.get(0);
        unusedTreasures.remove(salida);
    return salida;
    }
    
    public Monster nextMonster(){
      Monster salida;
        if(unusedMonsters.isEmpty()){
            unusedMonsters.addAll(usedMonsters);
            this.shuffleMonsters();
            usedMonsters.clear();
        }
        salida = unusedMonsters.get(0);
        unusedMonsters.remove(salida);
    return salida;
    }
    
    public void giveTreasureBack(Treasure t){
       usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
      usedMonsters.add(m);
    }
    
    public void initCards(){
         initTreasureCardDeck();
         initMonsterCardDeck();
         initCultistCardDeck();
    }
    
    private void shuffleCultists(){
       Collections.shuffle(unusedCultists);
    }
    
    private void initCultistCardDeck(){
        
    unusedCultists.add(new Cultist("Sectario",1));
    unusedCultists.add(new Cultist("Sectario",2));
    unusedCultists.add(new Cultist("Sectario",1));
    unusedCultists.add(new Cultist("Sectario",2));
    unusedCultists.add(new Cultist("Sectario",1));
    unusedCultists.add(new Cultist("Sectario",1));
    }
    
    public Cultist nextCultist(){
    Cultist salida;
        Collections.shuffle(unusedCultists);
        salida = unusedCultists.get(0);
    return salida;
    
    }
    
    private static class CardDealerHolder {

        private static final CardDealer INSTANCE = new CardDealer();
    }
}
