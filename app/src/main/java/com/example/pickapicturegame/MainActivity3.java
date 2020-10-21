package com.example.pickapicturegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.pickapicturegame.databinding.ActivityMain3Binding;

import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    ActivityMain3Binding mMain3Binding;
    List<Animals> mAnimals;
    RecyclerView mRvAnimal;
    AnimalAdapter mAnimalAdapter;
    QuestionCountDownTimer mQCDTInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMain3Binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(mMain3Binding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Log.d("ABC","onCreate3");

        mAnimals = Animals.getMockData();
        mRvAnimal = findViewById(R.id.rvAnimal);
        mAnimalAdapter = new AnimalAdapter(mAnimals);
        mQCDTInstance = QuestionCountDownTimer.getInstance();

        mQCDTInstance.setOnCountDownListener(new QuestionCountDownTimer.OnCountDownListener() {
            @Override
            public void onTick(long l) {
                mMain3Binding.tvTime.setText(l / 1000 + "");
            }

            @Override
            public void onFinish() {
                if (findViewById(R.id.layout_activity3) != null)
                    TimedOutDialogHelper.showTimedOutDialog(MainActivity3.this);
//                    showFinishDialog();
            }
        });


        mAnimalAdapter.setOnItemClickedListener(new AnimalAdapter.OnItemClickedListener() {
            @Override
            public void onClicked(int position) {
                Intent intent = new Intent();
                intent.putExtra(Key.POSITION, position);
                setResult(RESULT_OK, intent);
                finish();
                Log.d("ABC", position + "");
            }
        });


        mRvAnimal.setAdapter(mAnimalAdapter);
        closeContextMenu();

    }

    //    public void showFinishDialog() {
//        Dialog dialog = new Dialog(MainActivity3.this);
//        dialog.setContentView(R.layout.layout_dialog_timeout);
//        TextView tvScoreDialog = dialog.findViewById(R.id.tvScoreDialog);
//        tvScoreDialog.setText("Your score is: " + MainActivity2.mScore);
//        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//        dialog.show();
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // back was pressed
            Intent intent = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ABC","onStart3");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ABC","onResume3");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ABC","onStop3");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ABC","onPause3");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ABC","onRestart3");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ABC","onDestroy3");
    }

}