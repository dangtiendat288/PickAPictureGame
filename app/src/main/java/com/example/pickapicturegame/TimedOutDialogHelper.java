package com.example.pickapicturegame;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class TimedOutDialogHelper {
    public static void showTimedOutDialog(final Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.layout_dialog_timeout);
        TextView tvScoreDialog = dialog.findViewById(R.id.tvScoreDialog);
        TextView tvHome = dialog.findViewById(R.id.btnHome);
        TextView tvPlayAgain = dialog.findViewById(R.id.btnPlayAgain);
        tvScoreDialog.setText("Your score is: " + MainActivity2.mScore);
        tvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
            }
        });
        tvPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                activity.recreate();
                Intent intent = new Intent(activity, MainActivity2.class);
                activity.finish();
                activity.startActivity(intent);
            }
        });

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
            }
        });


        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
    }
}
