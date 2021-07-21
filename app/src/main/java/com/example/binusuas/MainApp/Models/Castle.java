package com.example.binusuas.MainApp.Models;

public class Castle {
    public String getCastleType() {
        return "";
    }
}

class HorseCastle extends Castle {
    @Override
    public String getCastleType() {
        return "Horse Castle";
    }
}

class WoodCastle extends Castle {
    @Override
    public String getCastleType() {
        return "Wood Castle";
    }
}

class SteelCastle extends Castle {
    @Override
    public String getCastleType() {
        return "Steel Castle";
    }
}

class StoneCastle extends Castle {
    @Override
    public String getCastleType() {
        return "Stone Castle";
    }
}