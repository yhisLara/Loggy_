package com.example.yhislaraf.loggy;

import android.content.SharedPreferences;

/**
 * Created by yhislaraf on 19-05-17.
 */

public class Utils {


    public static String getUserMailPref(SharedPreferences preferences){
        return preferences.getString("email","");
    }

    public static String getUserPassPref(SharedPreferences preferences){
        return preferences.getString("pass","");
    }

    public static Boolean deleteUserAndPass(SharedPreferences preferences){
        preferences.edit().remove("email").commit();
        preferences.edit().remove("pass").commit();
        return true;
    }



}
