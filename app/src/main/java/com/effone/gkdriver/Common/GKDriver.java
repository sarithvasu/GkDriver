package com.effone.gkdriver.Common;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by sarith.vasu on 09-03-2017.
 */

public class GKDriver {
    public static void createOKAlert(Context context, String title, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(context,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        if(!title.equals("")) {
            builder.setTitle(title);

        }
        builder.setMessage(msg)
                .setCancelable(false)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog alert = builder.show();
        alert.getWindow().getAttributes().gravity = Gravity.CENTER;
        TextView messageText = (TextView)alert.findViewById(android.R.id.message);
        int titleId =context.getResources().getIdentifier("alertTitle", "id", "android");
        TextView titleText = (TextView)alert.findViewById(titleId);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {

            titleText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));
            titleText.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        }
        titleText.setGravity(Gravity.CENTER);
        messageText.setGravity(Gravity.CENTER);
        alert.show();
    }
    public static ProgressDialog createProgressDialog(Context mContext) {
        ProgressDialog dialog = new ProgressDialog(mContext);
        try {
            dialog.show();
        } catch (WindowManager.BadTokenException e) {

        }
        dialog.setCancelable(false);
        // dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        //    dialog.setContentView(R.layout.common_progressbar);
        // dialog.setMessage(Message);
        return dialog;
    }
}
