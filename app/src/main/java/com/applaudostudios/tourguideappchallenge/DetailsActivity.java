package com.applaudostudios.tourguideappchallenge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.applaudostudios.tourguideappchallenge.model.Place;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String EXTRA_DETAIL = "EXTRA_DETAIL";
    private Place mPlace;
    private String mPhoneNumber;
    private String mLatitude;
    private String mLongitude;

    // Method that is implemented in each fragment to pass in the context and place
    public static Intent getInstance(Context context, Place place) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(EXTRA_DETAIL, place);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mPlace = getIntent().getParcelableExtra(EXTRA_DETAIL);
        mPhoneNumber = mPlace.getPhoneNumber();
        int mImage = mPlace.getPhoto();
        String mInformation = mPlace.getInformation();
        mLatitude = mPlace.getLatitude();
        mLongitude = mPlace.getLongitude();

        // Sets the up button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Declaring and initializing views in the DetailsActivity
        // Setting listeners for ImageViews that have to make and action when clicked
        TextView information = findViewById(R.id.information_text_view);
        information.setText(mInformation);

        ImageView image = findViewById(R.id.image_place);
        image.setImageDrawable(getResources().getDrawable(mImage));

        ImageView website = findViewById(R.id.website_button);
        website.setOnClickListener(this);

        ImageView phone = findViewById(R.id.phone_button);
        phone.setOnClickListener(this);

        ImageView location = findViewById(R.id.location_button);
        location.setOnClickListener(this);
    }

    // Up button logic
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

    /**
     * Has a switch case to take care of each button at the top of the activity
     *
     * @param view an ImageView
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.phone_button:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String temp = "tel:" + mPhoneNumber;
                intent.setData(Uri.parse(temp));
                startActivity(intent);
                break;
            case R.id.website_button:
                startActivity(WebViewActivity.getInstance(this, mPlace.getWebsite()));
                break;
            case R.id.location_button:
                Uri gmmIntentUri = Uri.parse("geo:" + mLatitude + "," + mLongitude + "?q=" + mLatitude + "," + mLongitude);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
                break;
        }
    }
}
