package com.bloonerd.mvvm_databinding;

import android.graphics.Color;

import org.junit.Test;

import static com.bloonerd.mvvm_databinding.DataBaseHelper.SERVER_URL;
import static org.junit.Assert.*;

public class DetailViewModelTest {

    @Test
    public void shouldGetTitleWithSirPrefix() throws Exception {

        GoTCharacter goTCharacter = new GoTCharacter("Arya", "Stark", SERVER_URL + "arya_full.jpg", true, "Stark", R.drawable.stark, "Arya Stark is the third child and second daughter of Lord Eddard Stark and Lady Catelyn Tully", SERVER_URL + "arya.jpg");
        DetailViewModel viewModel = new DetailViewModel(goTCharacter);
        assertEquals("Sir Arya Stark", viewModel.getTitle());

    }

    @Test
    public void shouldGetHouseWithChateauPrefix() throws Exception {

        GoTCharacter goTCharacter = new GoTCharacter("Arya", "Stark", SERVER_URL + "arya_full.jpg", true, "Stark", R.drawable.stark, "Arya Stark is the third child and second daughter of Lord Eddard Stark and Lady Catelyn Tully", SERVER_URL + "arya.jpg");
        DetailViewModel viewModel = new DetailViewModel(goTCharacter);
        assertEquals("Chateau Stark", viewModel.getHouseName());

    }

    @Test
    public void shouldGetCharacterDetailsGreenIfAlive() throws Exception {

        GoTCharacter goTCharacter = new GoTCharacter("Arya", "Stark", SERVER_URL + "arya_full.jpg", true, "Stark", R.drawable.stark, "Arya Stark is the third child and second daughter of Lord Eddard Stark and Lady Catelyn Tully", SERVER_URL + "arya.jpg");
        DetailViewModel viewModel = new DetailViewModel(goTCharacter);
        assertEquals(Color.GREEN, viewModel.getCharacterDetailsColor());

    }

    @Test
    public void shouldGetCharacterDetailsRedIfDead() throws Exception {

        GoTCharacter goTCharacter = new GoTCharacter("Catelyn", "Stark", SERVER_URL + "catelyn_full.jpg", false, "Stark", R.drawable.stark, "Lady Catelyn Stark, also called Catelyn Tully, is the wife of Lord Eddard Stark and Lady of Winterfell.", SERVER_URL + "catelyn.jpg");
        DetailViewModel viewModel = new DetailViewModel(goTCharacter);
        assertEquals(Color.RED, viewModel.getCharacterDetailsColor());

    }
}