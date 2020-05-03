package com.alquran.assudais.Utilities;

import android.app.Application;
import android.content.SharedPreferences;

import com.alquran.assudais.R;

public class MyApplication extends Application {

    static SharedPreferences sharedPreferences;
    static SharedPreferences.Editor editor;

    public static boolean SALAAMSOUND = true;

    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();

        SALAAMSOUND = sharedPreferences.getBoolean(CommonUtilities.SALAAMSOUND, true);
    }

    public static boolean isSALAAMSOUND() {
        SALAAMSOUND = sharedPreferences.getBoolean(CommonUtilities.SALAAMSOUND, true);
        return SALAAMSOUND;
    }

    public static void setSALAAMSOUND(boolean SALAAMSOUND) {
        editor.putBoolean(CommonUtilities.SALAAMSOUND, SALAAMSOUND);
        editor.apply();
        MyApplication.SALAAMSOUND = SALAAMSOUND;
    }

}
