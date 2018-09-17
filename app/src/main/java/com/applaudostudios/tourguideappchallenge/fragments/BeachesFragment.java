package com.applaudostudios.tourguideappchallenge.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applaudostudios.tourguideappchallenge.CallBack;
import com.applaudostudios.tourguideappchallenge.DetailsActivity;
import com.applaudostudios.tourguideappchallenge.R;
import com.applaudostudios.tourguideappchallenge.adapters.RecyclerViewAdapter;
import com.applaudostudios.tourguideappchallenge.model.Place;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BeachesFragment extends Fragment implements CallBack {
    View v;
    private List<Place> mPlaceList;

    public BeachesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_beaches, container, false);
        RecyclerView myRecyclerView = v.findViewById(R.id.recycler_view_beaches);
        myRecyclerView.setHasFixedSize(true);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mPlaceList, this);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPlaceList = new ArrayList<>();
        mPlaceList.add(new Place("Los Cóbanos", R.drawable.los_cobanos, "+503 2257 7777", "http://www.turismo.com.sv/destinos/playa-los-cobanos.php", "The beautiful Playa Los Cóbanos is located in the Department of Sonsonate, without doubt has great beauty that makes it an ideal place to visit, is characterized by almost white sand, which does not look much at home because the coast is volcanic sand. The beach consists of reefs that are protected by remnants of cliffs that serve as natural breakwaters and create a safe place for bathing.", "13.525", "-89.797"));
        mPlaceList.add(new Place("Salinitas", R.drawable.salinitas, "+503 2257 7777", "http://www.mitur.gob.sv/travel/playa-salinitas/", "While Playa Salinitas isn't the cleanest beach, its sands are vast, and there's always something to do in or around the water. It's also one of the most visited beaches in El Salvador, so expect to share this sandy strip with crowds of locals and tourists.", "13.68935", "-89.18718"));
        mPlaceList.add(new Place("El Tunco", R.drawable.el_tunco, "+503 2257 7777", "http://www.mitur.gob.sv/en/travel/playa-el-tunco/", "Playa El Tunco is located just 31 minutes away from the  international airport, is one of the most popular beach town, the surf is very consistence and for all levels, having two different breaks, a rocky pointbreak named Sunzal and a rivermouth with left and rights waves named Bocana, in the town you find several hotels, bars and restuarants, very popular for the live music parties during the weekends.", "13.492", "-89.381"));
        mPlaceList.add(new Place("El Zonte", R.drawable.el_zonte, "+503 2257 7777", "http://www.mitur.gob.sv/en/travel/playa-el-zonte-2/", "In El Zonte you will find a few spots where you can surf, the most popular is the breakpoint, with rocky bottom break a nice mellow wave, very stron with bigger sweels, to the west you find a river mouth that breaks different sections, left waves most of the time, and at the end you will find a beach break with left and right and close up sections, in the rain season the beach is full of rocks and with big waves is very hard to surf, is perfect spot for middle size sweels", "13.433", "-89.050"));
        mPlaceList.add(new Place("Costa del Sol", R.drawable.costa_del_sol, "+503 2257 7777", "http://www.mitur.gob.sv/en/travel/costa-del-sol/", "Costa del sol is a very famous beach located in the department of La Paz, is well known as one of the most exclusive beaches in the country, Costa del Sol is divided in two areas, one is the beautifull sandy beach right at the shore of the ocean and the other side is the mangroove where most of the different land lords of the exclusive beach houses residential have boats and yats.", "13.344", "-89.066"));
        mPlaceList.add(new Place("Costa Azúl", R.drawable.costa_azul, "+503 2257 7777", "http://elsalvador.travel/es/places/playa-costa-azul/", "At Costa Azul the different activities are hourse riding, boat trips at the mangrooves and in the ocean, fishing expeditions, renting jet sky and stand up paddle. To make the different activities is always better to contact a tour operator company.", "13.6483", "-89.9219"));
        mPlaceList.add(new Place("El Cuco", R.drawable.el_cuco, "+503 2222 2222", "http://www.elsalvadortravelnetwork.com/playa-el-cuco.html", "El cuco is a popular beach town at the east side department of San Miguel, very close from the Fonseca gulf that share El Salvador with Nicaragua and Honduras. This area is conciderated as one of the best beaches areas in El Salvador, there are around 100 kilometers including beaches like El Espino, Playas Negras, Las Tunas and Tamarindo.", "13.167", "-88.100"));
        mPlaceList.add(new Place("Puerto La Libertad", R.drawable.port_la_libertad, "+503 2257 7777", "http://www.viajeroselsalvador.com/puerto-de-la-libertad.html", "El Salvador's El Puerto de la Libertad region includes the most popular El Salvador beaches, especially when it comes to surfing. In particular, the La Punta break is renowned by surfers worldwide. The surf is the biggest (think 10-foot waves!) during the wet season between May and October. However, the dry season has smaller, more consistent conditions, perfect for beginners. ", "13.48833", "-89.32222"));

    }

    @Override
    public void onItemClick(int position) {
        startActivity(DetailsActivity.getInstance(getContext(), mPlaceList.get(position)));
    }
}
