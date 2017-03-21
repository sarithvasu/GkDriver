package com.effone.gkdriver.Connection;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;


import com.effone.gkdriver.R;

/**
 * Created by sarith.vasu on 22-02-2017.
 */

public class Connectivty {
    private static final String TAG = "PermissionMessage";
    private Context m_context;

    public Connectivty(Context m_context) {
        this.m_context = m_context;
    }


    public static  void showGPSDisabledAlertToUser(final Context context) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setMessage(R.string.messahe)
                .setCancelable(false)
                .setPositiveButton(R.string.GpsButton,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                context.startActivity(callGPSSettingIntent);

                            }
                        });
        alertDialogBuilder.setNegativeButton(R.string.button,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        System.exit(0);
                    }
                });
        final AlertDialog alert = alertDialogBuilder.create();
        alert.show();

    }
    public static void showInternetDisabledAlertToUser(final Context context) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.internet_connection)
                .setTitle(R.string.titleMsg)
                .setCancelable(false)
                .setPositiveButton(R.string.settings,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Intent i = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                                context.startActivity(i);
                            }
                        }
                )
                .setNegativeButton(R.string.button,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                System.exit(0);
                            }
                        }
                );
        AlertDialog alert = builder.create();
        alert.show();
    }



}
