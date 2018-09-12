package com.applaudostudios.tourguideappchallenge;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BeachesFragment extends Fragment {
    View v;
    private RecyclerView myRecyclerView;
    private List<Place> mPlaceList;

    public BeachesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_beaches, container, false);
        myRecyclerView = v.findViewById(R.id.recycler_view_beaches);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), mPlaceList);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPlaceList = new ArrayList<>();
        mPlaceList.add(new Place("Costa del Sol"));
        mPlaceList.add(new Place("El cuco"));
        mPlaceList.add(new Place("El Tunco"));
        mPlaceList.add(new Place("Los Cobanos"));
        mPlaceList.add(new Place("La libertad"));
    }
}
