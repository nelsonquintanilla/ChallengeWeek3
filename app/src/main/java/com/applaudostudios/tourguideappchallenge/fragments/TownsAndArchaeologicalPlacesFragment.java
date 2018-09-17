package com.applaudostudios.tourguideappchallenge.fragments;


import android.content.Intent;
import android.os.Bundle;
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
        mPlaceList.add(new Place("Atáco", R.drawable.ataco, "+503 2257 7777", "https://www.mipuebloysugente.com/apps/blog/show/18928814-concepcion-de-ataco-ahuachapan", "Concepcion de Ataco is a town situated in the western mountain ranges of El Salvador. It is located in the department of Ahuachapan along the popular Flowers Route (Ruta de la Flores). Ataco was founded by the Pipiles (a pre-Columbian Indian group) in the Apaneca Mountain Range.  The name comes from a Nahuatl word that means “place of elevated water springs”.", "13.8667", "-89.85"));
        mPlaceList.add(new Place("Apaneca", R.drawable.apaneca, "+503 2257 7777", "http://elsalvador.travel/es/places/apaneca-2/", "Apaneca has impressive places, but unknown to many tourists, places where the essence remains intact for centuries and where neither the stress nor the daily hustle disturbs the tranquility. The natural riches are the main tourist attraction that this municipality has, located in the department of Ahuachapán, with 45.13 square kilometers of extension that offer archeology, fauna and flora in its maximum splendor.", "13.8667", "-89.85"));
        mPlaceList.add(new Place("Nahuizalco", R.drawable.nahuizalco, "+503 2257 7777", "http://www.turismo.com.sv/destinos/nahuizalco.php", "Nahuizalco is located 70 kilometers from San Salvador and its name means \" four Izalcos \". There are several theories as to the origin of its name. One says that the city was founded by four families in the town of Izalco. Another theory says that the name came about because at one time the population was four times that of Izalco . Whatever the truth, it is a fact that Nahuizalco is a town of great Indian tradition and is home to many talented artisans.", "13.8667", "-89.85"));
        mPlaceList.add(new Place("Suchitoto", R.drawable.suchitoto, "+503 2257 7777", "http://www.elsalvadorturismo.com.sv/turismoelsalvador/el-salvador-rural-y-cultural/suchitoto-el-salvador/index.html", "", "13.8667", "-89.85"));
        mPlaceList.add(new Place("San Andrés", R.drawable.san_andres, "+503 2257 7777", "http://www.fundar.org.sv/sanandre.html", "Suchitoto is a historic colonial city in El Salvador, with cobbled streets, colonial houses, rich cultural traditions and panoramic views of Lake Suchitlán. We offer a variety of amenities in our quiet city, including hotels and restaurants for all budgets, museums, art galleries and nightlife. In our rural areas, well, you will find natural and historical treasures and numerous opportunities for exploration.", "13.8667", "-89.85"));
        mPlaceList.add(new Place("Juayúa", R.drawable.juayua, "+503 2257 7777", "http://www.turismo.com.sv/destinos/juayua.php", "Juayúa is a municipality located in the department of Sonsonate, El Salvador, 85 kilometers from the capital, it has a population of 24,465 inhabitants according to the 2007 Population and Housing Census, occupying the 57th position in population; is limited to the North by Atiquizaya, (Department of Achuchapán) and Chalchuapa (Department of Santa Ana), to the East by Chalchuapa (Department of Santa Ana) and Nahuizalco, to the West by Apaneca (Department of Ahuachapán) and Salcoatitán. It is divided into 10 cantons and 31 hamlets.", "13.8667", "-89.85"));
        mPlaceList.add(new Place("The Maya ruins of Tazumal", R.drawable.tazumal, "+503 2257 7777", "http://www.fundar.org.sv/tazumal.html", "The tazumal ruins is the most important arqueoloqy site in El Salvador, while there are many dramatic ruins throughout Mexico and Central America, the archaeological sites in El Salvador offer an important glimpse into what daily life was like for the Mayan society way of living.", "13.8667", "-89.85"));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(EXTRA_DETAIL, mPlaceList.get(position));
        startActivity(intent);
    }
}
