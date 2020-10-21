package com.example.pickapicturegame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pickapicturegame.databinding.ActivityMain2Binding;

import java.util.Collections;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding mMain2Binding;
    List<Animals> mAnimals;
    List<Animals> mQuestionAnimals;
    long mTime = 5300;
    public static int mScore = 0;
    int mQuestionIndex = 0;
//    RecyclerView mRvAnimal;
//    AnimalAdapter mAnimalAdapter;
    CountDownTimer mCountDownTimer;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;
    QuestionCountDownTimer mQCDTInstance;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ABC","onStart2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ABC","onResume2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ABC","onStop2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ABC","onDestroy2");
        mQCDTInstance.getInstance().stopCountDown();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ABC","onRestart2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ABC","onPause2");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMain2Binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(mMain2Binding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Log.d("ABC","OnCreate2");

        Glide.with(this).load(getDrawable(R.drawable.background_zoo)).into(mMain2Binding.imageView);
        mAnimals = Animals.getMockData();
        mQuestionAnimals = Animals.getMockData();
        Collections.shuffle(mQuestionAnimals);

        mSharedPreferences = getSharedPreferences("High scores",MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mQCDTInstance = QuestionCountDownTimer.getInstance();


        setQuestions(mQuestionIndex);

        mQCDTInstance.setCountDownTimer(mTime,1000);
        setOnCountDownListener();


//        setCountDownTimer();

        mMain2Binding.imageViewPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity2.this,MainActivity3.class);
                startActivityForResult(intent,Key.REQUEST_CODE_IMAGE);
//                final Dialog dialog = new Dialog(MainActivity2.this);
//                dialog.setContentView(R.layout.layout_dialog_animal_picker);
//                dialog.show();
//                mRvAnimal = dialog.findViewById(R.id.rvAnimal);
//                mRvAnimal.hasFixedSize();
//                mAnimalAdapter = new AnimalAdapter(mAnimals);
//                mAnimalAdapter.setOnItemClickedListener(new AnimalAdapter.OnItemClickedListener() {
//                    @Override
//                    public void onClicked(int position) {
//                        mMain2Binding.imageViewPicture.setImageResource(mAnimals.get(position).getImage());
//                        dialog.dismiss();
//                    }
//                });
//                mRvAnimal.setAdapter(mAnimalAdapter);
            }

        });

    }

    private void setOnCountDownListener() {
        mQCDTInstance.setOnCountDownListener(new QuestionCountDownTimer.OnCountDownListener() {
            @Override
            public void onTick(long l) {
                mMain2Binding.tvTime.setText(l/1000+"");
            }

            @Override
            public void onFinish() {
//                if(findViewById(R.id.layout_activity2)!=null)
                    TimedOutDialogHelper.showTimedOutDialog(MainActivity2.this);
//                showFinishDialog();
            }
        });
    }

    private void setQuestions(int questionIndex) {
        mMain2Binding.tvQuestion.setText(mQuestionAnimals.get(questionIndex).getName());
    }

//    private void setCountDownTimer() {
//        if(mCountDownTimer!=null){
//            mCountDownTimer.cancel();
//        }
//
//        mCountDownTimer = new CountDownTimer(mTime,1000) {
//            @Override
//            public void onTick(long l) {
//                    mMain2Binding.tvTime.setText(l/1000+"");
//            }
//
//            @Override
//            public void onFinish() {
//                showFinishDialog();

//                Toast.makeText(MainActivity2.this, "You have ran out of time!", Toast.LENGTH_SHORT).show();
//            }
//        };
//        mCountDownTimer.start();
//    }

//    public void showFinishDialog() {
//        final Dialog dialog = new Dialog (MainActivity2.this);
//        dialog.setContentView(R.layout.layout_dialog_timeout);
//        TextView tvScoreDialog = dialog.findViewById(R.id.tvScoreDialog);
//        TextView tvHome = dialog.findViewById(R.id.tvHome);
//        TextView tvPlayAgain = dialog.findViewById(R.id.tvPlayAgain);
//        tvScoreDialog.setText("Your score is: " + mScore);
//        tvHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });
//        tvPlayAgain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.cancel();
//                MainActivity2.this.recreate();
//            }
//        });
//        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//        dialog.show();
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==Key.REQUEST_CODE_IMAGE&&resultCode==RESULT_OK){
            final int position = data.getIntExtra(Key.POSITION,0);
            mMain2Binding.imageViewPicture.setImageResource(mAnimals.get(position).getImage());
            setOnCountDownListener();
            checkAnswer(mAnimals.get(position).getName());

        }

    }

    private void checkAnswer(String name) {
        if(name.equals(mMain2Binding.tvQuestion.getText().toString().toLowerCase().trim())){
            mMain2Binding.tvScore.setText(String.valueOf(++mScore));
            setQuestions(++mQuestionIndex);
            updateHighScore(mScore);
            mQCDTInstance.setCountDownTimer(mTime,1000);

        }
        else{
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateHighScore(int mScore) {
        int highScore = mSharedPreferences.getInt(Key.HIGH_SCORE,0);
        if(mScore>highScore)
        mEditor.putInt(Key.HIGH_SCORE,mScore);
        mEditor.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // back was pressed
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}