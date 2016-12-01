package com.bloonerd.mvvm_databinding;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_CHARACTER = "extra_character";
    private TextView characterDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        GoTCharacter gotCharacter = getIntent().getParcelableExtra(EXTRA_CHARACTER);

        if (gotCharacter.getFullName().startsWith("A"))
            setTitle("Sir " + gotCharacter.getFullName());
        else
            setTitle(gotCharacter.getFullName());

        ImageView imgCharacter = (ImageView) findViewById(R.id.image_character);
        ImageView imgHouse = (ImageView) findViewById(R.id.image_house);
        TextView textHouseName = (TextView) findViewById(R.id.text_house_name);
        characterDetails = (TextView) findViewById(R.id.text_character_story);

        Picasso.with(this)
                .load(Uri.parse(gotCharacter.fullUrl))
                .placeholder(R.drawable.profile_placeholder_full)
                .error(R.drawable.profile_placeholder_error_full)
                .into(imgCharacter);

        characterDetails.setText(gotCharacter.description);
        imgHouse.setImageResource(gotCharacter.houseResId);

        if (gotCharacter.house != null && gotCharacter.house.equals("Stark"))
            textHouseName.setText("Chateau " + gotCharacter.house);
        else
            textHouseName.setText(gotCharacter.house);

        int color = gotCharacter.alive ? Color.GREEN : Color.RED;
        characterDetails.setTextColor(color);
    }

    public void onChangeDescriptionColor(View view) {
        characterDetails.setTextColor(Color.BLUE);
    }
}
