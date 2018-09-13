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
public class HikingFragment extends Fragment implements CallBack {
    View v;
    private RecyclerView myRecyclerView;
    private List<Place> mPlaceList;

    public HikingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_hiking, container, false);
        myRecyclerView = v.findViewById(R.id.recycler_view_hiking_places);
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
        mPlaceList.add(new Place("Izalco Volcano", R.drawable.volcan_izalco));
        mPlaceList.add(new Place("Santa Ana Volcano", R.drawable.volcan_santa_ana));
        mPlaceList.add(new Place("El Imposible Park", R.drawable.el_imposible));
        mPlaceList.add(new Place("El Boquerón", R.drawable.el_boqueron));
        mPlaceList.add(new Place("El Pital", R.drawable.el_pital));
        mPlaceList.add(new Place("La Puerta del Diablo", R.drawable.la_puerta_del_diablo));
        mPlaceList.add(new Place("El Bicentenario", R.drawable.bicentenario));
        mPlaceList.add(new Place("Cerro verde", R.drawable.cerro_verde));
        mPlaceList.add(new Place("Walter Thilo Deininger Park", R.drawable.walter_thilo_deininger));
        mPlaceList.add(new Place("Jardín Botánico", R.drawable.jardin_botanico));
    }

    @Override
    public void onItemClick() {
        startActivity(new Intent(getActivity(), DetailsActivity.class));
    }
}
