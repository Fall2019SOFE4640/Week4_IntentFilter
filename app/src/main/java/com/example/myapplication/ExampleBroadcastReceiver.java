/*
Author: Anwar Abdalbari
Date : Sept. 26, 2019
Purpose: To listen to actions using intent filter, we have to create a class extends BroadcasReceiver
 */

package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {
    @Override
    //in this method we handle the occurrence of each event by using Toast
    // to display messages on the screen
    public void onReceive(Context context, Intent intent) {

        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            Toast.makeText(context, "AirPlane mode changed", Toast.LENGTH_LONG).show();
        } else if (Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())) {
            Toast.makeText(context, "ACTION_POWER_CONNECTED", Toast.LENGTH_LONG).show();
        } else if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);
            if (noConnectivity)
                Toast.makeText(context, "Disconnected", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context, "connected", Toast.LENGTH_LONG).show();

        }else
            return;
    }
}
