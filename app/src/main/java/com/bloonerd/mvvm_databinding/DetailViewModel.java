package com.bloonerd.mvvm_databinding;

import android.graphics.Color;

public class DetailViewModel {


    private final GoTCharacter gotCharacter;

    public DetailViewModel(GoTCharacter gotCharacter) {
        this.gotCharacter = gotCharacter;
    }


    public String getTitle() {
        return gotCharacter.getFullName() != null && gotCharacter.getFullName().startsWith("A") ?
                "Sir " + gotCharacter.getFullName() : gotCharacter.getFullName();
    }

    public String getHouseName() {
        return gotCharacter.house != null && gotCharacter.house.equals("Stark") ?
                "Chateau " + gotCharacter.house : gotCharacter.house;
    }

    public int getCharacterDetailsColor() {
        return gotCharacter.alive ? Color.GREEN : Color.RED;
    }

    public String getCharacterDetails() {
        return gotCharacter.description != null ? gotCharacter.description : "";
    }
}
