package com.example.binusuas.MainApp.Models;

public class Heroes {
    private int level;
    private String heroesClass;

    public Heroes(int level) {
        setLevel(level);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level > 0 && level < 51){
            this.level = level;
        }
        else {
            System.out.println("Level tidak valid");
        }
    }

}

class Infantry extends Heroes{
    private final String heroesClass = "Infantry";

    public Infantry(int level) {
        super(level);
    }
}

class Cavalry extends Heroes{
    private final String heroesClass = "Cavalry";

    public Cavalry(int level) {
        super(level);
    }
}

class Archer extends Heroes{
    private final String heroesClass = "Archer";

    public Archer(int level) {
        super(level);
    }
}

class Catapult extends Heroes{
    private final String heroesClass = "Catapult";

    public Catapult(int level) {
        super(level);
    }
}