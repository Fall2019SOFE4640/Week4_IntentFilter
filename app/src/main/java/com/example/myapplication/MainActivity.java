/*
Author: Anwar Abdalbari
Date : Sept. 26, 2019
Purpose: Dynamic Broadcast Intents

 */
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import java.util.concurrent.BrokenBarrierException;

public class MainActivity extends AppCompatActivity {

    // create an object from ExampleBroadcatReceiver class
    ExampleBroadcastReceiver broadcastReceiver = new ExampleBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //create intent filter to listen to specific events
        IntentFilter intentFilter = new IntentFilter();

        //add Airplane action(listner) to the filter
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        //add power connecion action(listner) to the filter
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);

        //add connectivity action(listner) to the filter
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        //register the filter
        registerReceiver(broadcastReceiver,intentFilter);


    }

    @Override
    //when the app is not active unregister the filter
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }
}
