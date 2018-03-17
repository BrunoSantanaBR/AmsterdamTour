package com.example.android.amsterdamtour;

/**
 * Created by bruno on 15/03/2018.
 */

public class Place {

    private String mNamePlace;
    private String mDescriptionPlace;
    private int mImagePlaceId;
    private String mWebSitePlace;
    private double mLatitudePlace;
    private double mLongitudePlace;


    public Place(String namePlace, String descriptionPlace, int imagePlaceId, String webSitePlace, double latitudePlace, double longitudePlace) {
        mNamePlace = namePlace;
        mDescriptionPlace = descriptionPlace;
        mImagePlaceId = imagePlaceId;
        mWebSitePlace = webSitePlace;
        mLatitudePlace = latitudePlace;
        mLongitudePlace = longitudePlace;
    }

    public String getmNamePlace() {

        return mNamePlace;
    }

    public String getmDescriptionPlace() {

        return mDescriptionPlace;
    }

    public int getmImagePlaceId() {
        return mImagePlaceId;
    }

    public String getmWebSitePlace() {
        return mWebSitePlace;
    }

    public double getmLatitudePlace() {

        return mLatitudePlace;
    }

    public double getmLongitudePlace() {

        return mLongitudePlace;
    }
}
