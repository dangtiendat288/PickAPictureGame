package com.example.pickapicturegame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>{
    List<Player> mPlayers;
    Context mContext;

    public ScoreAdapter(List<Player> mPlayers, Context context) {
        this.mContext = context;
        this.mPlayers = mPlayers;
    }

    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_highscore,parent,false);
        return new ScoreViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {
        Player currentPlayer = mPlayers.get(position);
        holder.tvName.setText(currentPlayer.getName());
        holder.tvScore.setText(String.valueOf(currentPlayer.getScore()));

        int colorRes = 0;
        switch (position%2){
            case 0:
                colorRes = R.color.evenItem;
                break;
            case 1:
                colorRes = R.color.oddItem;
                break;
        }
        holder.cvBackground.setBackgroundColor(ContextCompat.getColor(mContext, colorRes));


    }

    @Override
    public int getItemCount() {
        return mPlayers.size();
    }

    public class ScoreViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvScore;
        CardView cvBackground;
        public ScoreViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvScore = itemView.findViewById(R.id.tvScore);
            cvBackground = itemView.findViewById(R.id.cvBackground);

        }
    }
}
