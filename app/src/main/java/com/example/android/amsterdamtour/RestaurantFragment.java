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

        places.add(new Place("In de Waag", "In the part of Amsterdam that never sleeps you’ll find a square called ‘Nieuwmarkt’. This square has one gorgeous looking castle right in the centre, called ‘De Waag’ or formerly known as the St. Anthony’s Gate. Originally built in 1488, this characteristic monumental structure now houses Restaurant-Café. This magnificent historical building is illuminated by 300 candles.", R.drawable.in_de_waag, "https://www.indewaag.nl/", 52.372814, 4.900314));
        places.add(new Place("Me Naam Naan", "In a warm ambiance you can enjoy our authentic Thai dishes that are served with a smile by our friendly Thai staff, dressed in Thai costumes.Thai restaurant Me Naam Naan is located in the centre of Amsterdam in the Koningsstraat 29, in a historical building dating back to 1604.", R.drawable.me_naam_naan, "http://www.menaamnaan.nl/", 52.372315,4.901920 ));
        places.add(new Place("Il Sogno", "Best pizza in the Netherlands! I am a frequent visitor to Italy and know really good pizza restaurants there, and Il Sogno would fit right in at the top. The chef is indeed Italian but the non-Italian staff are just as good! It's a very nice place too, though it can be difficult to find a place to sit at the busiest hours.", R.drawable.il_sogno, "https://il-sogno.nl/",52.372607 ,4.901661 ));
        places.add(new Place("Restaurant Van Beeren", "Eetcafé Van Beeren is one of those rare gems that make the Amsterdam hospitality industry so varied and attractive. The business has a glorious past as a pub in the Nieuwmarkt neighborhood, where people often used to drink and drink until late at night. Where local residents, squatters, students and nightlife public meet each other and philosophize about politics, the life and the price of a beer while enjoying a drink.", R.drawable.restaurant_van_beeren, "http://www.eetcafevanbeeren.nl", 52.372073,4.902273 ));
        places.add(new Place("Hoi Tin", "Hoi Tin is a traditional Cantonese restaurant. With the oriental décor, one would feel like being in Southern China. With more than 100 seats, Hoi Tin is the perfect venue for a party or a nice gathering with the family. Hoi Tin has all the rice and noodle dishes one would expect of a traditional Chinese restaurant. Cha Sieuw, Soy Chicken and Peking Duck are dishes which we highly recommend.", R.drawable.hoi_tin, "http://www.restauranthoitin.com/en/index.php", 52.373442, 4.900125));

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


