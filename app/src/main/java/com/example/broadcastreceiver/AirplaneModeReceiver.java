package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(isAirplaneModeOn(context.getApplicationContext())){
            Toast.makeText(context, "Airplane Mode is On", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Airplane Mode is Off",Toast.LENGTH_SHORT).show();
        }

    }
    public static boolean isAirplaneModeOn(Context c){
        return Settings.System.getInt(c.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0) !=0;
    }
}
