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

        places.add(new Place("Anne Frank House","The Anne Frank House (Dutch: Anne Frank Huis) is a writer's house and biographical museum dedicated to Jewish wartime diarist Anne Frank.The Anne Frank House (Dutch: Anne Frank Huis) is a writer's house and biographical museum dedicated to Jewish wartime diarist Anne Frank. During World War II, Anne Frank hid from Nazi persecution with her family and four other people in hidden rooms at the rear of the 17th-century canal house, known as the Secret Annex (Dutch: Achterhuis).", R.drawable.anne_frank_house, "http://www.annefrank.org/nl/",52.375218, 4.883977));
        places.add(new Place("Amsterdam Rijksmuseum","It is in 1800, that The Amsterdam Rijksmuseum opened first its collection to the public as the Nationale Kunstgallerij (National Art Gallery). Since then, it moved several times before being established in Amsterdam (1808) by the decree of the King of the Netherlands Louis Bonaparte, brother of Napoleon. Named then the Royal Museum, received in 1815 from the Dutch King Willem I its present name. In 1885 Rijksmuseum moved to its beautiful building, designed by the Dutch architect Petrus J.H. Cuypers.",R.drawable.rijks_museum,"https://www.rijksmuseum.nl/",52.359998,4.885219 ));
        places.add(new Place("Van Gogh Museum","The collection features the works of Vincent van Gogh – more than 200 painting, 500 drawings but also works of other artists, his contemporaries – Impressionists and Postimpressionists. Van Gogh's work is organized chronologically into five periods, each representing a different period of his life and work: The Netherlands, Paris, Arles, Saint-Remy and Auvers-sur-Oise.",R.drawable.van_gogh,"https://www.vangoghmuseum.nl",52.358416,4.881076));
        places.add(new Place("Stedelijk Museum","Established in 1895 as the municipal museum, the Stedelijk became only in 1938 the state museum, with its interests divided into many disciplines as art, objects documenting history of Amsterdam now in the collection of Amsterdam Museum and specific subjects as history of medicine. It is only at the beginning of 1970’s, that the Stedelijk became solely the modern art museum. Today the Stedelijk Museum in Amsterdam has one of the richest modern art collections in the world.",R.drawable.stedelijk_museum,"https://www.stedelijk.nl/",52.358011,4.879755));
        places.add(new Place("Rembrandt House Museum","In 1906, during the Rembrandt Year, the foundation has been established to buy the house of the painter. Three years later, after a thorough restoration, the Museum has been opened to the public. The Amsterdam Rembrandt House Museum is a reconstruction of the Rembrandt’s rooms and of his workshop. The furniture and objects from the epoch were carefully presented together with the prints, sculptures and a few paintings of other painters from the Rembrandt’s times.",R.drawable.rembrandthouse_museum,"https://www.rembrandthuis.nl/en/",52.369369,4.901235));
        places.add(new Place("Amsterdam Museum","The history of Amsterdam has been presented chronologically, on three floors of the museum with a huge respect for the tradition (remarkable paintings). This rich presentation has been made with an eye for different social aspects of the city life, its religions as well as urban folklore and diverse subcultures, including entertainment, prostitution and Ajax football fanaticism. Each year the museum presents an interesting temporary exhibit.",R.drawable.amsterdam_museum,"https://www.amsterdammuseum.nl/",52.369987,4.889974));
        places.add(new Place("National Holocaust Museum","Opposite the Hollandsche Schouwburg in the Jewish Cultural Quarter is the National Holocaust Museum. This building, once a teachers’ training college, was used by resistance workers during World War II to smuggle some 600 children out of captivity and get them to relatively safe hiding places. This historic site hosts temporary exhibitions that tell the story of the Holocaust: it is a story of exclusion, of persecution and murder, but also of rescues, survival, and solidarity.",R.drawable.nationaal_holocaust_museum,"https://jck.nl/nhm",52.366903,4.910931));
        places.add(new Place("National Maritime Museum","The Amsterdam maritime museum building dates from 1656, it was designed by Daniël Stalpaert and at the time it was an architecture wonder. To construct it on the artificial island created in the Amsterdam harbor, 1800 wooden piles had to be sunk deep into the muddy ground. It is here, that the war ships of the Dutch Republic were equipped. They have the replica of the three masted “Amsterdam”, a large vessel of the Dutch East India Company.",R.drawable.maritime_museum,"https://www.hetscheepvaartmuseum.nl",52.371708,4.914880));
        places.add(new Place("NEMO Science Museum","Amsterdam NEMO houses loads of experiments and exhibitions inside its giant green hull on Oosterdok. No matter your background you will learn something new and have fun while doing it. Attractions change regularly, check the homepage to get the latest word. You can find the open-air exhibition Energetica, a large terrace and a restaurant on the roof, all with beautiful views of the city of Amsterdam.",R.drawable.nemo_museum,"https://www.nemosciencemuseum.nl/",52.374211,4.912339));

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
