package com.example.android.amsterdamtour;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(getString(R.string.restaurant_one_name), getString(R.string.restaurant_one_description), R.drawable.in_de_waag, getString(R.string.restaurant_one_website), 52.372814, 4.900314));
        places.add(new Place(getString(R.string.restaurant_two_name), getString(R.string.restaurant_two_description), R.drawable.me_naam_naan, getString(R.string.restaurant_two_website), 52.372315,4.901920 ));
        places.add(new Place(getString(R.string.restaurant_three_name), getString(R.string.restaurant_three_description), R.drawable.il_sogno, getString(R.string.restaurant_three_website),52.372607 ,4.901661 ));
        places.add(new Place(getString(R.string.restaurant_four_name), getString(R.string.restaurant_four_description), R.drawable.restaurant_van_beeren, getString(R.string.restaurant_four_website), 52.372073,4.902273 ));
        places.add(new Place(getString(R.string.restaurant_five_name), getString(R.string.restaurant_five_description), R.drawable.hoi_tin, getString(R.string.restaurant_five_website), 52.373442, 4.900125));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.place_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Intent placeIntent = new Intent(getContext(), DescriptionPlace.class);
                placeIntent.putExtra("namePlace", places.get(index).getmNamePlace());
                placeIntent.putExtra("descriptionPlace", places.get(index).getmDescriptionPlace());
                placeIntent.putExtra("imagePlaceId", places.get(index).getmImagePlaceId());
                placeIntent.putExtra("webSitePlace", places.get(index).getmWebSitePlace());
                placeIntent.putExtra("latitudePlace", places.get(index).getmLatitudePlace());
                placeIntent.putExtra("longitudePlace", places.get(index).getmLongitudePlace());

                startActivity(placeIntent);
            }
        });

        return rootView;
    }


}


