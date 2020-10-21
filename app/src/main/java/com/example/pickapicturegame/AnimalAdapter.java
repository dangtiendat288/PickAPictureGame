package com.example.pickapicturegame;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {
    List<Animals> animals;
    OnItemClickedListener mListener;

    public AnimalAdapter(List<Animals> animals) {
        this.animals = animals;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_animal_item,parent,false);
        return new AnimalViewHolder(v,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        holder.image.setImageResource(animals.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return animals!=null?animals.size():0;
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        OnItemClickedListener mVHListener;
        public AnimalViewHolder(@NonNull View itemView, OnItemClickedListener listener) {
            super(itemView);
            image = itemView.findViewById(R.id.imageAnimal);
            mVHListener = listener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mVHListener.onClicked(getAdapterPosition());
                }
            });

        }
    }

    public void setOnItemClickedListener(OnItemClickedListener listener){
        this.mListener = listener;
    }

    public interface OnItemClickedListener {
        void onClicked(int position);
    }
}
