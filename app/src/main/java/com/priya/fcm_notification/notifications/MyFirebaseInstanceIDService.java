package com.priya.fcm_notification.notifications;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.priya.fcm_notification.Constants;

/**
 * Created by Gokulapriya on 15/06/2018.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        //cV-_t7WHQoo:APA91bHaqCtjEvEmG1fBvJnhwGgCW1XpfHvON-4x4VVl8fS7JKSq1p4uQH-2qzUZRNirjhFrsVmAeXY0itov-kc-_quSj3WjPHDbz-181Hgt2aR2uL-8LWRg6ty9Nj3V-MuqD3vnnLJN

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        preferences.edit().putString(Constants.FIREBASE_TOKEN, refreshedToken).apply();
    }

}