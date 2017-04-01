package com.smartindia.hackathon.biotechnology.helper;

/**
 * Created by aman on 27/3/17.
 */


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharedPrefs {



    private static final String PREF_NAME = "welcome";
    private static final String KEY_TYPE = "key_type";
    private static final String PREF_NAME_LOGIN = "Login";
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static final String KEY_TYPE_ANALOGUS= "typeAnalogus";

    private static String TAG = "Shared Preference";

    // Shared Preferences
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    public SharedPrefs(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public String getAccessToken() {
        return pref.getString(KEY_ACCESS_TOKEN,"00");
    }

    public void setAccessToken(String accessToken) {
        editor.putString(KEY_ACCESS_TOKEN, accessToken);
        editor.commit();
    }
    public String getKeyType() {
        return pref.getString(KEY_TYPE, null);
    }

    public void setKeyType(String keyType) {
        editor.putString(KEY_TYPE, keyType);
        editor.commit();
    }

    public void setLogin(boolean isLoggedIn) {
        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
        // commit changes
        editor.commit();
        Log.d(TAG, "User login session modified!");
    }

    public String getKeyTypeAnalogus() {
        return pref.getString(KEY_TYPE_ANALOGUS,null);
    }

    public void setKeyTypeAnalogus(String typeAnalogus) {
        editor.putString(KEY_TYPE_ANALOGUS,typeAnalogus);
        editor.commit();
    }


    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }

    }