/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Alexis
 */
public class CardDealer {
    private static final CardDealer instance= new CardDealer();
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Cultist> unusedCultists;
    private ArrayList<Cultist> usedCultists;
    
    private CardDealer(){ }
    
    private void initTreasureCardDeck(){
        this.unusedTreasures=new ArrayList();
        this.usedTreasures=new ArrayList();
       
        unusedTreasures.add(new Treasure("¡Si mi amo!", 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigacion", 3, TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia acida", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora ACME", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la ETSIIT", 1, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alopodo", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistorica", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del PR. Tesla", 4, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato mistico", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metalica", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-comicón", 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-gnomicón", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro-playboycón", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));
        
        
    }
    private void initMonsterCardDeck(){
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        //Construcción de los monstruos
        
        //3 Byakhees de bonanza
        BadConsequence bad1 = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, 1, 1);
        Prize prize1 = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, bad1, prize1));
        
        //Tenochtilan
        BadConsequence bad2 = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        Prize prize2 =  new Prize(1,1);
        unusedMonsters.add(new Monster("Tenochtilan", 2, bad2, prize2));
        
        //El sopor de Dunwich
        BadConsequence bad3 = new BadConsequence("El primordial bostezo contagioso. Pierdes el casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        Prize prize3 = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, bad3, prize3));
        
        //Demonios de Magaluf
        BadConsequence bad4 = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize4 = new Prize(4,1);
        unusedMonsters.add(new Monster("Demonios de Magaluf", 2, bad4, prize4));
        
        //El gorrón en el umbral
        BadConsequence bad5 = new BadConsequence("Pierdes todos tus tesoros visibles", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR, 
                TreasureKind.BOTHHANDS, TreasureKind.HELMET, TreasureKind.ONEHAND, TreasureKind.SHOES)), 
                new ArrayList(Arrays.asList()));
        Prize prize5 = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 13, bad5, prize5));
        
        //H.P Munchraft
        BadConsequence bad6 = new BadConsequence("Pierdes la armadura visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList(Arrays.asList()));
        Prize prize6 = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P Munchraft", 6 , bad6, prize6));
        
        //Necrófago
        BadConsequence bad7 = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        Prize prize7 = new Prize(1,1);
        unusedMonsters.add(new Monster("Necrófago", 13, bad7, prize7));
        
        //El rey de rosado
        BadConsequence bad8 = new BadConsequence("Pierders 5 niveles y 3 tesoros visibles", 5,3,0);
        Prize prize8 = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosado", 13 , bad8, prize8));
        
        //Flecher
        BadConsequence bad9 = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2 , 0 , 0);
        Prize prize9 = new Prize(1,1);
        unusedMonsters.add(new Monster("Flecher", 2, bad9, prize9));
        
        //Los hondos
        BadConsequence bad10 = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        Prize prize10 = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos", 8, bad10, prize10));
        
        //Semillas Cthulhu
        BadConsequence bad11 = new BadConsequence("Pierdes dos niveles y 2 tesoros ocultos", 2, 0, 2);
        Prize prize11 = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, bad11, prize11));
        
        //Dameargo
        BadConsequence bad12 = new BadConsequence("Te intentas escaquear. Pierdes una mano visible",
                0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        Prize prize12 = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, bad12, prize12));
        
        //Pollipólipo volante
        BadConsequence bad13 = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        Prize prize13 = new Prize(2,1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, bad13, prize13));
        
        //Yskhtihyssg-Goth
        BadConsequence bad14 = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        Prize prize14 = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 14, bad14, prize14));
        
        //Familia feliz
        BadConsequence bad15 = new BadConsequence("La familia te atrapa. Estas muerto", true);
        Prize prize15 = new Prize(3,1);
        unusedMonsters.add(new Monster("Familia feliz", 1, bad15, prize15));
        
        //Roboggoth
        BadConsequence bad16 = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, 
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        Prize prize16 = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, bad16, prize16));
        
        //El espía sordo
        BadConsequence bad17 = new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        Prize prize17 = new Prize(1,1);
        unusedMonsters.add(new Monster("El espía sordo", 5, bad17, prize17));
        
        //Tongue
        BadConsequence bad18 = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        Prize prize18 = new Prize(2,1);
        unusedMonsters.add(new Monster("Tongue", 19, bad18, prize18));
        
        //Bicéfalo
        BadConsequence bad19 = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 nivles y tus tesoros visibles de las manos",
                3, 10, 0);
        Prize prize19 = new Prize(2,1);
        unusedMonsters.add(new Monster("Bicéfalo", 21, bad19, prize19)); 
        
        //MONSTRUOS SECTARIOS
        
        //El mal indecible impronunciable
        BadConsequence bad20 = new BadConsequence("Pierdes 1 mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                 new ArrayList(Arrays.asList()));
        Prize prize20 = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, bad20, prize20, -2));
    
        //Testigos Oculares
        BadConsequence bad21 = new BadConsequence("Pierdes tus tesoros visibles", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR, 
                TreasureKind.BOTHHANDS, TreasureKind.HELMET, TreasureKind.ONEHAND, TreasureKind.SHOES)), new ArrayList(Arrays.asList()));
        Prize prize21 = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos Oculares", 6, bad21, prize21, 2));
        
        //El gran cthulhu
        BadConsequence bad22 = new BadConsequence("Hoy no es tu día de suerte. Mueres", true);
        Prize prize22 = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, bad22, prize22, 4));
        
        //Serpiente Político
        BadConsequence bad23 = new BadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        Prize prize23 = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Politico", 8, bad23, prize23, -2));
        
        //Felpuggoth
        BadConsequence bad24 = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR, TreasureKind.HELMET)), 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR, TreasureKind.BOTHHANDS, TreasureKind.HELMET, TreasureKind.ONEHAND, 
                        TreasureKind.SHOES)));
        Prize prize24 = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, bad24, prize24, 5));
        
        //Shoggoth
        BadConsequence bad25 = new BadConsequence("Pierdes 2 niveles", 2, 0, 0);
        Prize prize25 = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth", 16, bad25, prize25, -4));
        
        //Lolitagooth
        BadConsequence bad26 = new BadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
        Prize prize26 = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, bad26, prize26, 3));
    }
    private void initCultistCardDeck(){
        this.unusedCultists=new ArrayList();
        this.usedCultists=new ArrayList();
       
        unusedCultists.add(new Cultist("El mal indecible impronunciable",-2));
        unusedCultists.add(new Cultist("Testigos Oculares",2));
        unusedCultists.add(new Cultist("El gran cthulhu",4));
        unusedCultists.add(new Cultist("Serpiente politico",-2));
        unusedCultists.add(new Cultist("Felpuggoth",5));
        unusedCultists.add(new Cultist("Shoggoth",-4));
        unusedCultists.add(new Cultist("Lolitagooth",3));
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    
    public static final CardDealer getInstance(){
        return instance;
    }
    
    public Treasure nextTreasure(){
        Treasure devuelta;
        
        if(unusedTreasures.isEmpty()){
            for (Treasure usedTreasure : usedTreasures) {
                this.unusedTreasures.add(usedTreasure);
            }
            this.usedTreasures.clear();
            this.shuffleTreasures();
        }
        
        devuelta = unusedTreasures.get(0);
        usedTreasures.add(devuelta);
        unusedTreasures.remove(0);
        
        return devuelta;
    }
    public Monster nextMonster(){
        Monster devuelta;
        
        if(!unusedMonsters.isEmpty()){
            for (Monster usedMonster : usedMonsters) {
                this.unusedMonsters.add(usedMonster);
            }
            this.usedMonsters.clear();
            this.shuffleMonsters();
        }
        
        devuelta = unusedMonsters.get(0);
        usedMonsters.add(devuelta);
        unusedMonsters.remove(0);
        
        return devuelta;      
    }
    public Cultist nextCultist(){
        Cultist devuelta;
        
        if(!unusedCultists.isEmpty()){
            for (Cultist usedCultist : usedCultists) {
                this.unusedCultists.add(usedCultist);
            }
            this.usedCultists.clear();
            this.shuffleCultists();
        }
        
        devuelta = unusedCultists.get(0);
        usedCultists.add(devuelta);
        unusedCultists.remove(0);
        
        return devuelta;
    }
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    public void initCards(){
        this.initTreasureCardDeck(); //1.3.1
        this.initMonsterCardDeck();  //1.3.2
        this.initCultistCardDeck();
    }
}
