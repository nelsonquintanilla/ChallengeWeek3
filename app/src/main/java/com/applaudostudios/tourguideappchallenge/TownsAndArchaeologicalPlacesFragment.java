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
    private static final String EXTRA_DETAIL = "EXTRA_DETAIL";

    public TownsAndArchaeologicalPlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_towns_and_archaeological_places, container, false);
        myRecyclerView = v.findViewById(R.id.recycler_view_towns_and_archaeological_places);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mPlaceList, this);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPlaceList = new ArrayList<>();
        mPlaceList.add(new Place("Atáco", R.drawable.ataco, "+503 2257 7777", "https://www.mipuebloysugente.com/apps/blog/show/18928814-concepcion-de-ataco-ahuachapan"));
        mPlaceList.add(new Place("Apaneca", R.drawable.apaneca, "+503 2257 7777", "http://elsalvador.travel/es/places/apaneca-2/"));
        mPlaceList.add(new Place("Nahuizalco", R.drawable.nahuizalco, "+503 2257 7777", "http://www.turismo.com.sv/destinos/nahuizalco.php"));
        mPlaceList.add(new Place("Suchitoto", R.drawable.suchitoto, "+503 2257 7777", "http://www.elsalvadorturismo.com.sv/turismoelsalvador/el-salvador-rural-y-cultural/suchitoto-el-salvador/index.html"));
        mPlaceList.add(new Place("San Andrés", R.drawable.san_andres, "+503 2257 7777", "http://www.fundar.org.sv/sanandre.html"));
        mPlaceList.add(new Place("Juayúa", R.drawable.juayua, "+503 2257 7777", "http://www.turismo.com.sv/destinos/juayua.php"));
        mPlaceList.add(new Place("The Maya ruins of Tazumal", R.drawable.tazumal, "+503 2257 7777", "http://www.fundar.org.sv/tazumal.html"));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(EXTRA_DETAIL, mPlaceList.get(position));
        startActivity(intent);
    }
}
