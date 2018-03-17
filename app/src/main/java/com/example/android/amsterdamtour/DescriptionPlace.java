package com.example.android.amsterdamtour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by bruno on 16/03/2018.
 */

public class DescriptionPlace extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_place);

        Intent descriptionPlaceIntent = getIntent();

        String namePlace = descriptionPlaceIntent.getStringExtra("namePlace");
        String descriptionPlace = descriptionPlaceIntent.getStringExtra("descriptionPlace");
        int imagePlaceId = descriptionPlaceIntent.getIntExtra("imagePlaceId", 0);
        String webSitePlace = descriptionPlaceIntent.getStringExtra("webSitePlace");
        double latitudePlace = descriptionPlaceIntent.getDoubleExtra("latitudePlace", 0);
        double longitudePlace = descriptionPlaceIntent.getDoubleExtra("longitudePlace", 0);

        String location = "maps.google.com/?q="+latitudePlace+","+longitudePlace;

        ((TextView) findViewById(R.id.name_place_text_view)).setText(namePlace);
        ((TextView) findViewById(R.id.description_place_text_view)).setText(descriptionPlace);
        ((TextView) findViewById(R.id.website_place_text_view)).setText(webSitePlace);
        ((ImageView) findViewById(R.id.place_image_view)).setImageResource(imagePlaceId);
        ((TextView)findViewById(R.id.location_text_view)).setText(location);


        }
}
