package com.applaudostudios.tourguideappchallenge;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<Place> mData;
    private CallBack mCallBack;

    RecyclerViewAdapter(List<Place> data, CallBack callBack) {
        mData = data;
        mCallBack = callBack;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(mData.get(position).getName());
        holder.image.setImageResource(mData.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private ImageView image;
        private ConstraintLayout itemPlace;

        private MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.place_name);
            image = itemView.findViewById(R.id.image_place);
            itemPlace = itemView.findViewById(R.id.place_item_id);
            itemPlace.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mCallBack.onItemClick(getAdapterPosition());
        }
    }
}
