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

        places.add(new Place("Heineken Experience", "Born in Amsterdam, raised by the world! For Heineken® fans like yourself, our original brewery in the city centre has been transformed into a sensational interactive tour.", R.drawable.heineken_experience, "https://www.heineken.com/Heineken-Experience", 52.357831, 4.891825));
        places.add(new Place("The Amsterdam Dungeon","A uniquely thrilling attraction that will whisk you way back into the Netherlands’ most perilous past. See, hear, feel and (ahem) smell the chillingly amusing characters of the ‘bad old days’ as they come to life before you. Will you lose yourself in fear or in mirth? Which ever way, it’s not looking good for your underwear.",R.drawable.the_amsterdam_dungeon,"https://www.thedungeons.com/amsterdam/en/",52.370176,4.892102));
        places.add(new Place("The Canal Cruise","Amsterdam Canal Cruises is an online platform for all canal cruises in Amsterdam. A day in Amsterdam isn’t complete without a cruise through the canals of Amsterdam: romantic during the evening with dinner or during the day with the kids. The best way to start of your journey in Amsterdam is by boat. Amsterdam Canal Cruises is a local expert and we love to share our insiders knowledge of the city with you. Since 2002 we help you experience the real Amsterdam. Together with you we continu to make great memories; the best souvenir to take home!",R.drawable.canal_cruise,"https://amsterdamcanalcruises.nl/",52.377843,4.898383));

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

