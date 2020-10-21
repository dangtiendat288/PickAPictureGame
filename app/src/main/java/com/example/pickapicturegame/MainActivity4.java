package com.example.pickapicturegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.pickapicturegame.databinding.ActivityMain4Binding;

import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    ActivityMain4Binding mMain4Binding;
    SharedPreferences mSharedPreferences;
    int mHighScore;
    ScoreAdapter mScoreAdapter;
    List<Player> mPlayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMain4Binding = ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(mMain4Binding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mSharedPreferences = getSharedPreferences("High scores",MODE_PRIVATE);
        mHighScore = mSharedPreferences.getInt(Key.HIGH_SCORE,0);
//        mMain4Binding.tvHighScore.setText("High score: " + mHighScore);
        mPlayers = Player.getMockData();
        mScoreAdapter = new ScoreAdapter(mPlayers,this);
        mMain4Binding.rvHighScores.setAdapter(mScoreAdapter);
    }
}