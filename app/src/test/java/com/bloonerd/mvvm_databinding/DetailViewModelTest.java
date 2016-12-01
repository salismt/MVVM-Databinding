package com.bloonerd.mvvm_databinding;

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
}