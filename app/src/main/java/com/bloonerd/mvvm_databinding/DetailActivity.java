package com.bloonerd.mvvm_databinding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bloonerd.mvvm_databinding.databinding.ActivityDetailBinding;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_CHARACTER = "extra_character";
    private TextView characterDetails;
    private DetailViewModel viewModel;
    public ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        GoTCharacter gotCharacter = getIntent().getParcelableExtra(EXTRA_CHARACTER);
        viewModel = new DetailViewModel(gotCharacter, this);
        binding.setViewModel(viewModel);

        setTitle(viewModel.getTitle());

        ImageView imgCharacter = (ImageView) findViewById(R.id.image_character);
        characterDetails = (TextView) findViewById(R.id.text_character_story);

        Picasso.with(this)
                .load(Uri.parse(gotCharacter.fullUrl))
                .placeholder(R.drawable.profile_placeholder_full)
                .error(R.drawable.profile_placeholder_error_full)
                .into(imgCharacter);

    }

    public void onChangeDescriptionColor(View view) {
        characterDetails.setTextColor(Color.BLUE);
    }
}
