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
    private static final String EXTRA_DETAIL = "EXTRA_DETAIL";

    public HikingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_hiking, container, false);
        myRecyclerView = v.findViewById(R.id.recycler_view_hiking_places);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mPlaceList, this);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPlaceList = new ArrayList<>();
        mPlaceList.add(new Place("Izalco Volcano", R.drawable.volcan_izalco, "+503 2257 7777", "https://www.britannica.com/place/Izalco-Volcano"));
        mPlaceList.add(new Place("Santa Ana Volcano", R.drawable.volcan_santa_ana, "+503 2257 7777", "https://www.dontforgettomove.com/hiking-the-santa-ana-volcano-el-salvador/"));
        mPlaceList.add(new Place("El Imposible Park", R.drawable.el_imposible, "+503 2257 7777", "http://www.marn.gob.sv/parque-nacional-el-imposible/"));
        mPlaceList.add(new Place("El Boquerón", R.drawable.el_boqueron, "+503 2257 7777", "http://www.mitur.gob.sv/en/travel/parque-nacional-el-boqueron/"));
        mPlaceList.add(new Place("El Pital", R.drawable.el_pital, "+503 2257 7777", "http://www.elsalvadorturismo.com.sv/turismoelsalvador/areasnaturales/cerro-el-pital/index.html"));
        mPlaceList.add(new Place("La Puerta del Diablo", R.drawable.la_puerta_del_diablo, "+503 2257 7777", "https://www.ngenespanol.com/travel/la-puerta-del-diablo-el-salvador/"));
        mPlaceList.add(new Place("El Bicentenario", R.drawable.bicentenario, "+503 2257 7777", "http://www.salvanatura.org/parque-del-bicentenario/"));
        mPlaceList.add(new Place("Cerro verde", R.drawable.cerro_verde, "+503 2257 7777", "http://www.elsalvadorturismo.com.sv/turismoelsalvador/areasnaturales/parque-natural-el-cerro-verde/"));
        mPlaceList.add(new Place("Walter Thilo Deininger Park", R.drawable.walter_thilo_deininger, "+503 2257 7777", "http://elsalvador.travel/es/places/parque-walter-thilo-deininger-2/"));
        mPlaceList.add(new Place("Jardín Botánico", R.drawable.jardin_botanico, "+503 2257 7777", "http://elsalvador.travel/es/places/jardin-botanico-la-laguna-2/"));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(EXTRA_DETAIL, mPlaceList.get(position));
        startActivity(intent);
    }
}
