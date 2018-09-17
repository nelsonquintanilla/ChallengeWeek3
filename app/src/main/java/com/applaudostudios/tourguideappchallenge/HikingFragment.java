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
        mPlaceList.add(new Place("Izalco Volcano", R.drawable.volcan_izalco, "+503 2257 7777", "https://www.britannica.com/place/Izalco-Volcano", "Izalco Volcano, Spanish Volcán Izalco, volcano in western El Salvador on the southern slope of Santa Ana. It is the most active volcano in Central America, having erupted more than 50 times since 1770. Its black symmetrical cone, which was formed by a number of eruptions over a period of 200 years, is devoid of vegetation and reaches a height of 6,004 feet (1,830 metres).", "13.813", "-89.633"));
        mPlaceList.add(new Place("Santa Ana Volcano", R.drawable.volcan_santa_ana, "+503 2257 7777", "https://www.dontforgettomove.com/hiking-the-santa-ana-volcano-el-salvador/", "Accessing the volcano is best done from the nearby city of Santa Ana, where public bus schedules match the tour companies, and the whole day trip to Santa Ana volcano can be done without signing up for an expensive tour (see a full list of directions at the bottom of the article).", "13.99417", "-89.55972"));
        mPlaceList.add(new Place("El Imposible Park", R.drawable.el_imposible, "+503 2257 7777", "http://www.marn.gob.sv/parque-nacional-el-imposible/", "El Imposible National Park (Spanish: Parque Nacional El Imposible) is a tropical forest and a national park in El Salvador. It was established on 1 January 1989 and covers an area of 38.20 square kilometres. It literally means \"The Impossible National Park\" in English. It has an altitude of between 250 and 1,425 metres.", "13.5030", "-89.5727"));
        mPlaceList.add(new Place("El Boquerón", R.drawable.el_boqueron, "+503 2257 7777", "http://www.mitur.gob.sv/en/travel/parque-nacional-el-boqueron/", "The San Salvador Volcano (also known as Quetzaltepec ) is a stratovolcano situated northwest to the city of San Salvador. The crater has been nearly filled with a relatively newer edifice, the Boquerón volcano. The city of San Salvador is adjacent to the volcano and the western section of the city actually lies among its slopes. Because of this close proximity, any geological activity of the volcano, whether eruptive or not, has the potential to result in catastrophic destruction and death to the city. ", "13.734", "-89.294"));
        mPlaceList.add(new Place("El Pital", R.drawable.el_pital, "+503 2257 7777", "http://www.elsalvadorturismo.com.sv/turismoelsalvador/areasnaturales/cerro-el-pital/index.html", "Cerro El Pital is a mountain in Central America, on the border of El Salvador and Honduras. It is located 12 km (7 mi) from the town of La Palma at a height of 2,730 m (8,957 ft) above sea level, and is the highest point in Salvadoran territory.", "14.3833318", "-89.1166662"));
        mPlaceList.add(new Place("La Puerta del Diablo", R.drawable.la_puerta_del_diablo, "+503 2257 7777", "https://www.ngenespanol.com/travel/la-puerta-del-diablo-el-salvador/", "Puerta Del Diablo is a peak located to the South East of San Salvador. Being of great significance to the Mayan Pipil people, it was a sacred site used for sacrifice rituals. It was named \"The Devil's Door\" by the Spanish Catholics who constantly opposed indigenous religious practice. Any taxi can take you from the capitol in about 20 minutes for only a few dollars. A quick hike to the top is completely worth the view, especially if you go late in the evening near dusk.", "13.627", "-89.185"));
        mPlaceList.add(new Place("El Bicentenario", R.drawable.bicentenario, "+503 2257 7777", "http://www.salvanatura.org/parque-del-bicentenario/", "The Bicentenario Park is located to the west of the city and is a green retreat that's perfect for a day trip. The park features long paved and unpaved trails that wind through it and are perfect for hiking, casual strolls, biking, and bird watching. There also is a small playground for the kids and a picnic and barbeque area. The trails are signposted with maps and there are many park employees and guards throughout to ensure you don't lose your way. The park is an oasis of natural beauty and definitely should not be missed when in the city.", "13.8030", "-88.9053"));
        mPlaceList.add(new Place("Cerro verde", R.drawable.cerro_verde, "+503 2257 7777", "http://www.elsalvadorturismo.com.sv/turismoelsalvador/areasnaturales/parque-natural-el-cerro-verde/", "Despite a debut that lacked its much-touted main attraction, the hotel opened and operated for decades. A short drive from the capital of San Salvador, the 22-room getaway was frequented by the country's elite, who held extravagant weddings and rang in the New Years with style. It was the most-fashionable spot to stay in Cerro Verde National Park, home to the Izalco, Cerro Verde and Santa Ana Volcanoes. But the hotel sustained considerable damage in a 1986 earthquake, and operated at diminished capacity until it was shuttered in 1997. ", "13.8030", "-88.9053"));
        mPlaceList.add(new Place("Walter Thilo Deininger Park", R.drawable.walter_thilo_deininger, "+503 2257 7777", "http://elsalvador.travel/es/places/parque-walter-thilo-deininger-2/", "Just 39 kilometers from San Salvador, this beautiful park is located in the south central area of the country, in the department of La Libertad. Visit this park if you want to experience a trip to the mountain and a wonderful view of the sea from a height ranging from 8 to 280 meters above sea level.", "13.8030", "-88.9053"));
        mPlaceList.add(new Place("Jardín Botánico", R.drawable.jardin_botanico, "+503 2257 7777", "http://elsalvador.travel/es/places/jardin-botanico-la-laguna-2/", "This is a mid-sized botanical garden on the outskirts of San Salvador.", "13.8030", "-88.9053"));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(EXTRA_DETAIL, mPlaceList.get(position));
        startActivity(intent);
    }
}
