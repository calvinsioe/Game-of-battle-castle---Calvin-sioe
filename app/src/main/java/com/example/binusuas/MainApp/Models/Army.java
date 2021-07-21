package com.example.binusuas.MainApp.Models;

public class Army {
    private String armyType;
    private int totalArmy = 0;

    public int getTotalArmy() {
        return totalArmy;
    }

    public void setTotalArmy(int totalArmy) {
        this.totalArmy = totalArmy;
    }

    public String getArmyType() {
        return armyType;
    }
}

class InfantryArmy extends Army {
    private String armyType = "Infantry";
}

class CavalryArmy extends Army {
    private String armyType = "Cavalry";

}

class ArcherArmy extends Army {
    private String armyType = "Archer";
}

class CatapultArmy extends Army {
    private String armyType = "Catapult";
}