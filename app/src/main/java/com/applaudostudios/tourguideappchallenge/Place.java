package com.applaudostudios.tourguideappchallenge;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {
    private String name;
    private int photo;
    private String phoneNumber;
    private String website;
    private String information;
    private String latitude;
    private String longitude;

    Place(String name, int photo, String phoneNumber, String website, String information, String latitude, String longitude) {
        this.name = name;
        this.photo = photo;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.information = information;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getInformation() {
        return information;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getWebsite() {
        return website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getPhoto() {
        return photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.photo);
        dest.writeString(this.phoneNumber);
        dest.writeString(this.website);
        dest.writeString(this.information);
        dest.writeString(this.latitude);
        dest.writeString(this.longitude);
    }

    private Place(Parcel in) {
        this.name = in.readString();
        this.photo = in.readInt();
        this.phoneNumber = in.readString();
        this.website = in.readString();
        this.information = in.readString();
        this.latitude = in.readString();
        this.longitude = in.readString();
    }

    public static final Parcelable.Creator<Place> CREATOR = new Parcelable.Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel source) {
            return new Place(source);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };
}
