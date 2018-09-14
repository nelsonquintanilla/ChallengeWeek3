package com.applaudostudios.tourguideappchallenge;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
public class LakesAndWaterFallsFragment extends Fragment implements CallBack {
    View v;
    private RecyclerView myRecyclerView;
    private List<Place> mPlaceList;
    private static final String EXTRA_DETAIL = "EXTRA_DETAIL";

    public LakesAndWaterFallsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_lakes_and_waterfalls, container, false);
        myRecyclerView = v.findViewById(R.id.recycler_view_lakes_and_waterfalls);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mPlaceList, this);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPlaceList = new ArrayList<>();
        mPlaceList.add(new Place("Alegria Lagoon", R.drawable.laguna_de_alegria, "+503 2257 7777"));
        mPlaceList.add(new Place("Los Tercios Waterfalls", R.drawable.los_tercios, "+503 2257 7777"));
        mPlaceList.add(new Place("Suchitlán Lake", R.drawable.suchitlan, "+503 2257 7777"));
        mPlaceList.add(new Place("Tamanique Waterfalls", R.drawable.tamanique, "+503 2257 7777"));
        mPlaceList.add(new Place("Chorros de la Calera Waterfalls", R.drawable.chorros_de_la_calera, "+503 2257 7777"));
        mPlaceList.add(new Place("Golfo de Fonseca", R.drawable.golfo_de_fonseca, "+503 2257 7777"));
        mPlaceList.add(new Place("Coatepeque Lake", R.drawable.lago_de_coatepeque, "+503 2257 7777"));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(EXTRA_DETAIL, mPlaceList.get(position));
        startActivity(intent);
    }
}
