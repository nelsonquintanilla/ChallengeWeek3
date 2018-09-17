package com.applaudostudios.tourguideappchallenge.fragments;


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
public class LakesAndWaterFallsFragment extends Fragment implements CallBack {
    View v;
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
        RecyclerView myRecyclerView = v.findViewById(R.id.recycler_view_lakes_and_waterfalls);
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
        mPlaceList.add(new Place("Alegria Lagoon", R.drawable.laguna_de_alegria, "+503 2257 7777", "http://guiaturisticasalvadorena.blogspot.com/2014/04/laguna-de-alegria-usulutan.html", "The Laguna de Alegria is located in the crater of Tecapa, in the Tecapa-Chinameca, less than two kilometers from the city. The lagoon has easy access through a cobblestone Street that passes through coffee plantations. The input is controlled and there are restrictions to ensure the conservation of the site. The Laguna de Alegria because his Emerald sulphur and minerals that are found in the crater of the volcano.", "13.500", "-88.500"));
        mPlaceList.add(new Place("Los Tercios Waterfalls", R.drawable.los_tercios, "+503 2257 7777", "http://www.elsalvadorturismo.com.sv/turismoelsalvador/el-salvador-rural-y-cultural/suchitoto-el-salvador/lostercios.html", "Los Tercios, a stunning waterfall and small swimming hole located an easy 1.5km (1-mile) stroll out of town, really looks like a piece of modern art, with foot-wide slices of vertical rock jutting out along the face of its 9m (30-ft.) waterfall. The unique shape of the rocks here is thought to have resulted from rapidly cooling ancient magma. Though water only flows over the falls from May to December, Los Tercios is worth a visit year-round, since the unique rock formations are the main attraction. Be prepared to climb down a few rocks to get a good look.", "13.500", "-88.500"));
        mPlaceList.add(new Place("Suchitlán Lake", R.drawable.suchitlan, "+503 2257 7777", "http://www.turismo.com.sv/destinos/lago-suchitlan.php", "The lake Suchitlan is one of the main attractions not only for its size and surface if not, the amount of fish and birds in there; In addition it offers the tourist boat rides with beautiful views of fantastic scenery or you can take the ferry that accommodates 4 vehicles to transport up to 100 people. On a tour you can see surrounding towns to that lake and its beautiful flora, fauna and different islands:Bird Island, lovers, El Salitre, El Chaparral, El León, El Burro, Trinidad etc. ", "13.500", "-88.500"));
        mPlaceList.add(new Place("Tamanique Waterfalls", R.drawable.tamanique, "+503 2257 7777", "http://magazine.elsalvador.com/mg/nota_3_imagenes.asp?idArt=7706200&idCat=19978", "Just minutes away from Playa El Tunco are a series of fun, crystal spring waterfalls that deserve your visit. The Tamanique waterfalls won’t cut into your surfing schedule, as this trip is only a 25 minute drive from the beach. It requires a hike so please be prepared for a steep walk and bring good footwear. It takes about 30 minutes to hike down to the waterfalls from town. On the way, let the locals regale you with stories of years living in a surf paradise. Then dive into the cool pools and take a break from the tropical heat. For larger groups we can cater a lunch to bring with you.", "13.500", "-88.500"));
        mPlaceList.add(new Place("Chorros de la Calera Waterfalls", R.drawable.chorros_de_la_calera, "+503 2257 7777", "http://guiaturisticasalvadorena.blogspot.com/2014/08/los-chorros-de-la-calera.html", " Los Chorros de la Calera is a natural wonder, located in the town of Juayua, Sonsonate department in the South West of El Salvador. This beautiful place has cascades down through the mountains to reach levels where they have created a shallow pools suitable for enjoying with family and friends.", "13.500", "-88.500"));
        mPlaceList.add(new Place("Golfo de Fonseca", R.drawable.golfo_de_fonseca, "+503 2257 7777", "http://www.elsalvadorturismo.com.sv/turismoelsalvador/areasnaturales/golfo-de-fonseca-y-parque-conchagua/index.html", "The area of La Union , is the Conchagua ecological park which has trails, lookouts towards the Gulf of Fonseca , areas for camping and rest areas, picnic and park guides. Ask for more information by calling the Park. Phone: (503) 2661-9832 and (503) 2659-5320. ", "13.500", "-88.500"));
        mPlaceList.add(new Place("Coatepeque Lake", R.drawable.lago_de_coatepeque, "+503 2257 7777", "http://elsalvador.travel/es/places/coatepeque/", "In the lake you can do different activities like kayaking, boat trips, dive, jetsky, SUP and enjoy at the shore of the great meals in the different restaurant, there are a few hotels in the shore of the lake available but the area is very quiet, most visitors are just local tourism that comes during the weekends, most of the time you will find it very quiet and private, an amazing place for couple or big groups.", "13.500", "-88.500"));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(EXTRA_DETAIL, mPlaceList.get(position));
        startActivity(intent);
    }
}
