package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button reg,unreg;
    AirplaneModeReceiver myreceiver = new AirplaneModeReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg = (Button) findViewById(R.id.reg);
        unreg =(Button) findViewById(R.id.unreg);
        reg.setOnClickListener(this);
        unreg.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter f = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(myreceiver,f);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myreceiver);
    }

    //seharusnya yang dibawah ini tidak perlu
    @Override
    public void onClick(View view) {
        if(view == reg){
            IntentFilter f = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
            registerReceiver(myreceiver,f);
        }else if(view==unreg){
            unregisterReceiver(myreceiver);
        }
    }
}