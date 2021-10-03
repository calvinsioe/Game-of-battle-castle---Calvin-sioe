package com.example.binusuas.MainApp.Models;
import java.util.ArrayList;

public class Player {
    private double infantryPower = 0, cavalryPower = 0, archerPower = 0, catapultPower = 0;
    private double deadInfantry = 0, deadCavalry = 0, deadArcher = 0;

    //army
    private InfantryArmy infantryArmy = new InfantryArmy();
    private CavalryArmy cavalryArmy = new CavalryArmy();
    private ArcherArmy archerArmy = new ArcherArmy();
    private CatapultArmy catapultArmy = new CatapultArmy();

    //heroes
    private ArrayList<Archer> archers = new ArrayList<>();
    private ArrayList<Catapult> catapults = new ArrayList<>();
    private ArrayList<Cavalry> cavalries = new ArrayList<>();
    private ArrayList<Infantry> infantries = new ArrayList<>();

    //castle
    private String castleType;
    private HorseCastle horseCastle = new HorseCastle();
    private WoodCastle woodCastle = new WoodCastle();
    private SteelCastle steelCastle = new SteelCastle();
    private StoneCastle stoneCastle = new StoneCastle();

    // menambahkan heroes
    public void addArchers(int level){
        archers.add(new Archer(level));
    }
    public void addCatapults(int level){
        catapults.add(new Catapult(level));
    }
    public void addCavalries(int level){
        cavalries.add(new Cavalry(level));
    }
    public void addInfantries(int level){
        infantries.add(new Infantry(level));
    }

    // reset heroes
    public void resetHeroes(){
        archers.clear();
        catapults.clear();
        cavalries.clear();
        infantries.clear();
    }

    // menentukan castle
    public void setCastleType(String castleType) {
        checkCastle(castleType);
    }

    // mengambil data Castle
    public String getCastleType() {
        return castleType;
    }

    // constructor
    public Player(int infantryArmyTotal,int cavalryArmyTotal, int archerArmyTotal, int catapultArmyTotal,
                  String castleType) {
        setCastleType(castleType);
        setArmy(archerArmyTotal, infantryArmyTotal, catapultArmyTotal, cavalryArmyTotal);
    }

    // set army
    public void setArmy(int archers, int infantries, int catapults, int cavalries){
        resetArmy();
        cavalryArmy.setTotalArmy(cavalries);
        catapultArmy.setTotalArmy(catapults);
        infantryArmy.setTotalArmy(infantries);
        archerArmy.setTotalArmy(archers);
    }

    // reset army
    public void resetArmy(){
        archerArmy.setTotalArmy(0);
        infantryArmy.setTotalArmy(0);
        catapultArmy.setTotalArmy(0);
        cavalryArmy.setTotalArmy(0);
    }

    // mengecek castle
    public void checkCastle(String castleType){
        if (castleType.equals(horseCastle.getCastleType())||castleType.equals(woodCastle.getCastleType())||
                castleType.equals(steelCastle.getCastleType())||castleType.equals(stoneCastle.getCastleType())){
            this.castleType = castleType;
        } else {
            System.out.println("Error Castle Not Found");
        }
    }

    // set power
    public void setPower(){
        if (castleType.equals(woodCastle.getCastleType())) {
            archerPower += archerArmy.getTotalArmy()/100*20;
        }else if(castleType.equals(steelCastle.getCastleType())){
            infantryPower += infantryArmy.getTotalArmy()/100*20;
        }else if(castleType.equals(horseCastle.getCastleType())){
            cavalryPower += cavalryArmy.getTotalArmy()/100*20;
        }else if(castleType.equals(stoneCastle.getCastleType())){
            catapultPower += catapultArmy.getTotalArmy()/100*20;
        }else{
            System.out.println("Error Castle Not Found");
        }

        infantryPower += (infantries.size()*40*infantryArmy.getTotalArmy()/100)+infantryArmy.getTotalArmy();
        cavalryPower += (cavalries.size()*40*cavalryArmy.getTotalArmy()/100)+cavalryArmy.getTotalArmy();
        archerPower += (archers.size()*40*archerArmy.getTotalArmy()/100)+archerArmy.getTotalArmy();
        catapultPower += (catapults.size()*40*catapultArmy.getTotalArmy()/100)+catapultArmy.getTotalArmy();
    }

    public double getInfantryPower() {
        return infantryPower;
    }

    public double getCavalryPower() {
        return cavalryPower;
    }

    public double getArcherPower() {
        return archerPower;
    }

    public double getCatapultPower() {
        return catapultPower;
    }

    //attack
    public void setDead(double cavalryPower, double archerPower, double infantryPower){
        if (infantryArmy.getTotalArmy()>0){
            setDeadInfantry(cavalryPower, archerPower);
            if (deadInfantry>50000){
                deadInfantry = 50000;
            }
        }
        if (archerArmy.getTotalArmy()>0){
            setDeadArcher(cavalryPower, infantryPower);
            if (deadArcher>50000){
                deadArcher = 50000;
            }
        }
        if (cavalryArmy.getTotalArmy()>0){
            setDeadCavalry(archerPower, infantryPower);
            if (deadCavalry>50000){
                deadCavalry = 50000;
            }
        }
    }

    private void setDeadArcher(double cavalryPower, double infantryPower){
        deadArcher = cavalryPower * 0.4 + infantryPower * 0.4;
    }

    private void setDeadCavalry(double archerPower, double infantryPower){
        deadCavalry = infantryPower * 0.1 + archerPower * 0.4;
    }

    private void setDeadInfantry(double cavalryPower, double archerPower){
        deadInfantry = cavalryPower * 0.4 + archerPower * 0.1;
    }

    public double getDeadInfantry() {
        return deadInfantry;
    }

    public double getDeadCavalry() {
        return deadCavalry;
    }

    public double getDeadArcher() {
        return deadArcher;
    }
}
