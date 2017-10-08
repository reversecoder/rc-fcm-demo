package com.reversecoder.rb.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.reversecoder.rb.util.AllConstants;
import com.reversecoder.rb.util.SessionManager;

/**
 * Created by Belal on 03/11/16.
 */


public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        storeToken(refreshedToken);
    }

    private void storeToken(String token) {
        //saving the token on shared preferences
        SessionManager.setStringSetting(getApplicationContext(), AllConstants.SESSION_DEVICE_TOKEN, token);
    }
}