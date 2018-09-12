package com.applaudostudios.tourguideappchallenge;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParksFragment extends Fragment {
    View v;
    private RecyclerView myRecyclerView;
    private List<Place> mPlaceList;

    public ParksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_parks, container, false);
        myRecyclerView = v.findViewById(R.id.recycler_view_parks);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), mPlaceList);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPlaceList = new ArrayList<>();
        mPlaceList.add(new Place("parque el imposible"));
        mPlaceList.add(new Place("parque el imposible2"));
        mPlaceList.add(new Place("parque el imposible3"));
        mPlaceList.add(new Place("parque el imposible4"));
        mPlaceList.add(new Place("parque el imposible5"));
    }

}
