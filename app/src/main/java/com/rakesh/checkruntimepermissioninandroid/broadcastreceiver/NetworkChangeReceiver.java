package com.rakesh.checkruntimepermissioninandroid.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.rakesh.checkruntimepermissioninandroid.networkmanager.NetworkUtil;

/**
 * Created by gleecus on 12/5/16.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {

        boolean isConnected = NetworkUtil.isInternetAvailable(context);
        if (isConnected) {
            Log.e("NetworkChangeReceiver: ", "connected");
            Intent i2 = new Intent("connected");
            LocalBroadcastManager.getInstance(context).sendBroadcast(i2);
        } else {
            Log.e("NetworkChangeReceiver: ", "not connected");
            Intent i2 = new Intent("notconnected");
            LocalBroadcastManager.getInstance(context).sendBroadcast(i2);
        }
    }
}
