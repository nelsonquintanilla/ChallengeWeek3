package com.applaudostudios.tourguideappchallenge;


import android.content.Intent;
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
public class TownsAndArchaeologicalPlacesFragment extends Fragment implements CallBack {
    View v;
    private RecyclerView myRecyclerView;
    private List<Place> mPlaceList;

    public TownsAndArchaeologicalPlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_towns_and_archaeological_places, container, false);
        myRecyclerView = v.findViewById(R.id.recycler_view_towns_and_archaeological_places);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), mPlaceList);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewAdapter.setCallBack(this);
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPlaceList = new ArrayList<>();
        mPlaceList.add(new Place("Atáco", R.drawable.ataco));
        mPlaceList.add(new Place("Apaneca", R.drawable.apaneca));
        mPlaceList.add(new Place("Nahuizalco", R.drawable.nahuizalco));
        mPlaceList.add(new Place("Suchitoto", R.drawable.suchitoto));
        mPlaceList.add(new Place("San Andrés", R.drawable.san_andres));
        mPlaceList.add(new Place("Juayúa", R.drawable.juayua));
        mPlaceList.add(new Place("The Maya ruins of Tazumal", R.drawable.tazumal));
    }

    @Override
    public void onItemClick() {
        startActivity(new Intent(getActivity(), DetailsActivity.class));
    }
}
