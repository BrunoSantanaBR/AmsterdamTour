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
public class OthersFragment extends Fragment {

    public OthersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(getString(R.string.other_one_name), getString(R.string.other_one_description), R.drawable.heineken_experience, getString(R.string.other_one_website), 52.357831, 4.891825));
        places.add(new Place(getString(R.string.other_two_name),getString(R.string.other_two_description),R.drawable.the_amsterdam_dungeon,getString(R.string.other_two_website),52.370176,4.892102));
        places.add(new Place(getString(R.string.other_three_name),getString(R.string.other_three_description),R.drawable.canal_cruise,getString(R.string.other_three_website),52.377843,4.898383));

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

