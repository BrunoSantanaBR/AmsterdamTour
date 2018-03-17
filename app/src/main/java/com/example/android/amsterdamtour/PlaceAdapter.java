package com.example.android.amsterdamtour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bruno on 15/03/2018.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_place, parent, false);
        }

        // Get the {@link Place} object located at this position in the list
        Place currentPlace = getItem(position);

        // Find the TextView in the list_place.xml layout with the ID name_place_text_view.
        TextView namePlaceTextView = listItemView.findViewById(R.id.name_place_text_view_list);
        // Get the name of the place from the currentPlace object and set this text on
        // the Name Place TextView.
        namePlaceTextView.setText(currentPlace.getmNamePlace());

        // Find the ImageView in the list_place.xml layout with the ID image.
        ImageView placeImageView = listItemView.findViewById(R.id.place_image_view_list);
        // Display the provided image based on the resource ID
        placeImageView.setImageResource(currentPlace.getmImagePlaceId());

        // Return the whole list item layout (containing 1 TextView and 1 ImageView) so that it can be shown in
        // the ListView.
        return listItemView;
    }

}
