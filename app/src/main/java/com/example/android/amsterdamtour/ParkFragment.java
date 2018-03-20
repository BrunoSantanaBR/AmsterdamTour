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
public class ParkFragment extends Fragment {


    public ParkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(getString(R.string.park_one_name), getString(R.string.park_one_description), R.drawable.vondelpark, getString(R.string.park_one_website), 52.357995, 4.868648));
        places.add(new Place(getString(R.string.park_two_name), getString(R.string.park_two_description), R.drawable.westerpark, getString(R.string.park_two_website), 52.386156, 4.877835));
        places.add(new Place(getString(R.string.park_three_name), getString(R.string.park_three_description), R.drawable.amstelpark, getString(R.string.park_three_website), 52.330749, 4.893154));
        places.add(new Place(getString(R.string.park_four_name), getString(R.string.park_four_description), R.drawable.rembrandtpark, getString(R.string.park_four_website), 52.364693, 4.846059));
        places.add(new Place(getString(R.string.park_five_name), getString(R.string.park_five_description), R.drawable.flevopark, getString(R.string.park_five_website), 52.360063, 4.950345));
        places.add(new Place(getString(R.string.park_six_name), getString(R.string.park_six_description), R.drawable.sarphatipark, getString(R.string.park_six_website), 52.354296, 4.896079));
        places.add(new Place(getString(R.string.park_seven_name), getString(R.string.park_seven_description), R.drawable.oosterpark, getString(R.string.park_seven_website), 52.358970, 4.920930));

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
