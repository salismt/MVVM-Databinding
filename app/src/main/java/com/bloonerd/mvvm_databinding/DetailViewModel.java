package com.bloonerd.mvvm_databinding;

public class DetailViewModel {


    private final GoTCharacter gotCharacter;

    public DetailViewModel(GoTCharacter gotCharacter) {
        this.gotCharacter = gotCharacter;
    }


    public String getTitle() {
        return gotCharacter.getFullName() != null && gotCharacter.getFullName().startsWith("A") ?
                "Sir " + gotCharacter.getFullName() : gotCharacter.getFullName();
    }
}
