package com.alquran.assudais.Utilities;

import android.app.Application;
import android.content.SharedPreferences;

import com.alquran.assudais.R;

public class MyApplication extends Application {

    static SharedPreferences sharedPreferences;
    static SharedPreferences.Editor editor;

    public static String bookmarkedPara = "";
    public static String bookmarkedRuku = "";
    public static String bookmarkedAyat = "";
    public static String bookmarkedPage = "";
    public static String lastReopened = "";
    public static boolean SALAAMSOUND = true;

    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();

        SALAAMSOUND = sharedPreferences.getBoolean(CommonUtilities.SALAAMSOUND, true);
        lastReopened = sharedPreferences.getString(CommonUtilities.LASTREOPENDPARA, " NONE");
        bookmarkedPara = sharedPreferences.getString(CommonUtilities.BOOKMARKEDPARA, " NONE");
        bookmarkedRuku = sharedPreferences.getString(CommonUtilities.BOOKMARKEDRUKU, " NONE");
        bookmarkedAyat = sharedPreferences.getString(CommonUtilities.BOOKMARKEDAYAT, " NONE");
        bookmarkedPage = sharedPreferences.getString(CommonUtilities.BOOKMARKEDPAGE, " NONE");
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

    public static String getLastReopened() {
        lastReopened = sharedPreferences.getString(CommonUtilities.LASTREOPENDPARA, " NONE");
        return lastReopened;
    }

    public static void setLastReopened(String lastReopened) {
        editor.putString(CommonUtilities.LASTREOPENDPARA, lastReopened);
        editor.apply();
        MyApplication.lastReopened = lastReopened;
    }

    public static String getBookmarkedPara() {
        bookmarkedPara = sharedPreferences.getString(CommonUtilities.BOOKMARKEDPARA, " NONE");
        return bookmarkedPara;
    }

    public static void setBookmarkedPara(String bookmarkedPara) {
        editor.putString(CommonUtilities.BOOKMARKEDPARA, bookmarkedPara);
        editor.apply();
        MyApplication.bookmarkedPara = bookmarkedPara;
    }

    public static String getBookmarkedRuku() {
        bookmarkedRuku = sharedPreferences.getString(CommonUtilities.BOOKMARKEDRUKU, " NONE");
        return bookmarkedRuku;
    }

    public static void setBookmarkedRuku(String bookmarkedRuku) {
        editor.putString(CommonUtilities.BOOKMARKEDRUKU, bookmarkedRuku);
        editor.apply();
        MyApplication.bookmarkedRuku = bookmarkedRuku;
    }

    public static String getBookmarkedAyat() {
        bookmarkedAyat = sharedPreferences.getString(CommonUtilities.BOOKMARKEDAYAT, " NONE");
        return bookmarkedAyat;
    }

    public static void setBookmarkedAyat(String bookmarkedAyat) {
        editor.putString(CommonUtilities.BOOKMARKEDAYAT, bookmarkedAyat);
        editor.apply();
        MyApplication.bookmarkedAyat = bookmarkedAyat;
    }

    public static String getBookmarkedPage() {
        bookmarkedPage = sharedPreferences.getString(CommonUtilities.BOOKMARKEDPAGE, " NONE");
        return bookmarkedPage;
    }

    public static void setBookmarkedPage(String bookmarkedPage) {
        editor.putString(CommonUtilities.BOOKMARKEDPAGE, bookmarkedPage);
        editor.apply();
        MyApplication.bookmarkedPage = bookmarkedPage;
    }
}
