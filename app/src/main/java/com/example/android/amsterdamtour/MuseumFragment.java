package com.example.android.amsterdamtour;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumFragment extends Fragment {


    public MuseumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(getString(R.string.museum_one_name), getString(R.string.museum_one_description), R.drawable.anne_frank_house, getString(R.string.museum_one_website),52.375218, 4.883977));
        places.add(new Place(getString(R.string.museum_two_name),getString(R.string.museum_two_description),R.drawable.rijks_museum,getString(R.string.museum_two_website),52.359998,4.885219 ));
        places.add(new Place(getString(R.string.museum_three_name),getString(R.string.museum_three_description),R.drawable.van_gogh,getString(R.string.museum_three_website),52.358416,4.881076));
        places.add(new Place(getString(R.string.museum_four_name),getString(R.string.museum_four_description),R.drawable.stedelijk_museum,getString(R.string.museum_four_website),52.358011,4.879755));
        places.add(new Place(getString(R.string.museum_five_name),getString(R.string.museum_five_description),R.drawable.rembrandthouse_museum,getString(R.string.museum_five_website),52.369369,4.901235));
        places.add(new Place(getString(R.string.museum_six_name),getString(R.string.museum_six_description),R.drawable.amsterdam_museum,getString(R.string.museum_six_website),52.369987,4.889974));
        places.add(new Place(getString(R.string.museum_seven_name),getString(R.string.museum_seven_description),R.drawable.nationaal_holocaust_museum,getString(R.string.museum_seven_website),52.366903,4.910931));
        places.add(new Place(getString(R.string.museum_eight_name),getString(R.string.museum_eight_description),R.drawable.maritime_museum,getString(R.string.museum_eight_website),52.371708,4.914880));
        places.add(new Place(getString(R.string.museum_nine_name),getString(R.string.museum_nine_description),R.drawable.nemo_museum,getString(R.string.museum_nine_website),52.374211,4.912339));

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
                placeIntent.putExtra("longitudePlace",places.get(index).getmLongitudePlace());

                startActivity(placeIntent);
            }
        });

        return rootView;
    }

}
