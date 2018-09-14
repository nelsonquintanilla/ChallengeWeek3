package com.applaudostudios.tourguideappchallenge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

public class DetailsActivity extends AppCompatActivity {
    private static final String EXTRA_DETAIL = "EXTRA_DETAIL";
    private Place mPlace;
    private String mPhoneNumber;

    public static Intent getInstance(Context context, Place place){
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(EXTRA_DETAIL, place);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mPlace = getIntent().getParcelableExtra(EXTRA_DETAIL);
        mPhoneNumber=mPlace.getPhoneNumber();

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ImageView phone = findViewById(R.id.phone_button);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String temp = "tel:" + mPhoneNumber;
                intent.setData(Uri.parse(temp));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
