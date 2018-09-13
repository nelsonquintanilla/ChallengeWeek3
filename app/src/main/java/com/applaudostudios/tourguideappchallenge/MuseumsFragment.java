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
public class MuseumsFragment extends Fragment implements CallBack {
    View v;
    private RecyclerView myRecyclerView;
    private List<Place> mPlaceList;

    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_museums, container, false);
        myRecyclerView = v.findViewById(R.id.recycler_view_museums);
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
        mPlaceList.add(new Place("Los Cóbanos", R.drawable.los_cobanos));
        mPlaceList.add(new Place("Salinitas", R.drawable.salinitas));
        mPlaceList.add(new Place("El Tunco", R.drawable.el_tunco));
        mPlaceList.add(new Place("El Zonte", R.drawable.el_zonte));
        mPlaceList.add(new Place("Costa del Sol", R.drawable.costa_del_sol));
        mPlaceList.add(new Place("Costa Azúl", R.drawable.costa_azul));
        mPlaceList.add(new Place("El Cuco", R.drawable.el_cuco));
        mPlaceList.add(new Place("Puerto La Libertad", R.drawable.port_la_libertad));
    }

    @Override
    public void onItemClick() {
        startActivity(new Intent(getActivity(), DetailsActivity.class));
    }
}
