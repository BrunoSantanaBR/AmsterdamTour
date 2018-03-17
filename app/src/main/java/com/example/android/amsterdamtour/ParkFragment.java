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

        places.add(new Place("Vondelpark", "The Vondelpark is Amsterdam's most popular park, attracting thousands of tourists, residents and everyone in between every day. Amsterdam's Vondelpark is home to a selection of restaurants and cafés, including the Blauwe Theehuis, Café Vertigo, Vondelpark3, De Vondeltuin and the Groot Melkhuis. You’ll also find a skate rental shop, an open-air theatre and a rose garden with more than 70 types of roses in the park.", R.drawable.vondelpark, "https://www.iamsterdam.com/en/see-and-do/things-to-do/nature/overview/vondelpark", 52.357995, 4.868648));
        places.add(new Place("Westerpark", "Located in Amsterdam West, the Westerpark is a wonderful place to walk, skate, relax or have a picnic with friends. This green expanse dotted with trees and ponds is part of the Westergasfabriek complex, a former gasworks that was completely renovated in recent years. Besides the park, this area is home to a nice selection of cafés, restaurants and bars, as well as an art-house cinema and a variety of small creative businesses.", R.drawable.westerpark, "https://www.iamsterdam.com/en/see-and-do/things-to-do/nature/overview/westerpark", 52.386156, 4.877835));
        places.add(new Place("Amstelpark", "Located the southern edge of Amsterdam, Amstelpark is an expansive park filled with a multitude of flower gardens, a playground and a petting zoo. There is also an on-site gallery with two exhibition spaces: the Glazen Huis (glass house) and the Orangerie.", R.drawable.amstelpark, "https://www.iamsterdam.com/en/see-and-do/things-to-do/nature/overview/amstelpark", 52.330749, 4.893154));
        places.add(new Place("Rembrandtpark", "Located in Amsterdam West, the Rembrandtpark is an ideal place to sit out in the sun and enjoy a picnic. The park is a green oasis with ponds, playgrounds and walking and biking paths. You can also visit De Uylenburg, the oldest petting zoo in Amsterdam.", R.drawable.rembrandtpark, "https://www.iamsterdam.com/en/see-and-do/things-to-do/nature/overview/rembrandtpark", 52.364693, 4.846059));
        places.add(new Place("Flevopark", "Flevopark is situated on the east side of Amsterdam. This large green park is the perfect place to relax, go for a jog, play some sports or enjoy a picnic. During the summer months, you can visit the large outdoor swimming area, with a pool for swimming laps as well as a shallow pool for small children.", R.drawable.flevopark, "https://www.iamsterdam.com/en/see-and-do/things-to-do/nature/overview/flevopark", 52.360063, 4.950345));
        places.add(new Place("Sarphatipark", "Just around the corner from the bustling Albert Cuyp market, the Sarphatipark is a green oasis in the heart of the city with a pond, fountain and enclosed playground. This small park is the perfect place to enjoy the sun, have a picnic with friends or just sit and people watch.", R.drawable.sarphatipark, "https://www.iamsterdam.com/en/see-and-do/things-to-do/nature/overview/sarphatipark", 52.354296, 4.896079));
        places.add(new Place("Oosterpark", "The Oosterpark is a large city park located in Amsterdam Oost. This open green space is filled with ponds and streams, a wading pool for children and plenty of walking paths. Considered Amsterdam’s most multicultural park, it draws a diverse local crowd and hosts a variety of festivals throughout the summer.", R.drawable.oosterpark, "https://www.iamsterdam.com/en/see-and-do/things-to-do/nature/overview/oosterpark", 52.358970, 4.920930));

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
