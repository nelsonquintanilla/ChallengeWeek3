package com.applaudostudios.tourguideappchallenge;


import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BeachesFragment extends Fragment implements CallBack{
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
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mPlaceList, this);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerViewAdapter.setCallBack(this);
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPlaceList = new ArrayList<>();
        mPlaceList.add(new Place("Los Cóbanos", R.drawable.los_cobanos, "+503 2257 7777"));
        mPlaceList.add(new Place("Salinitas", R.drawable.salinitas, "+503 2257 7777"));
        mPlaceList.add(new Place("El Tunco", R.drawable.el_tunco, "+503 2257 7777"));
        mPlaceList.add(new Place("El Zonte", R.drawable.el_zonte, "+503 2257 7777"));
        mPlaceList.add(new Place("Costa del Sol", R.drawable.costa_del_sol, "+503 2257 7777"));
        mPlaceList.add(new Place("Costa Azúl", R.drawable.costa_azul, "+503 2257 7777"));
        mPlaceList.add(new Place("El Cuco", R.drawable.el_cuco, "+503 2222 2222"));
        mPlaceList.add(new Place("Puerto La Libertad", R.drawable.port_la_libertad, "+503 2257 7777"));

    }

    @Override
    public void onItemClick(int position) {
        startActivity(DetailsActivity.getInstance(getContext(), mPlaceList.get(position)));
    }
}
