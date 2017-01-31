package com.rakesh.checkruntimepermissioninandroid.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.rakesh.checkruntimepermissioninandroid.networkmanager.NetworkUtil;

/**
 * Created by gleecus on 12/5/16.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {

    private OnNetworkChangeListener listener = null;
    public static String NETWORK_AVAILABLE_ACTION = "com.rakesh.checkruntimepermissioninandroid.NetworkAvailable";
    public static String NETWORK_TYPE = "networkType";

    @Override
    public void onReceive(final Context context, final Intent intent) {

        Intent networkStateIntent = new Intent(NETWORK_AVAILABLE_ACTION);
        networkStateIntent.putExtra(NETWORK_TYPE,  NetworkUtil.getConnectivityStatusString(context));
        LocalBroadcastManager.getInstance(context).sendBroadcast(networkStateIntent);

        //String status = NetworkUtil.getConnectivityStatusString(context);

        /*if (listener != null) {
            listener.onNetworkChanged(status);
        }*/
        //Toast.makeText(context, status, Toast.LENGTH_LONG).show();

    }

    public interface OnNetworkChangeListener {
        public void onNetworkChanged(String status);
    }

    public void setOnLocationChangeListener(Context context) {
        this.listener = (OnNetworkChangeListener) context;
    }
}
