package com.example.yhislaraf.loggy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

public class SplashActivity extends AppCompatActivity {
    private SharedPreferences spref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        spref = getSharedPreferences("preferences", Context.MODE_PRIVATE);

        Intent intentLogin = new Intent(this, LoggyActivity.class);
        Intent intentMain = new Intent(this, MainActivity.class);

        if(!TextUtils.isEmpty(Utils.getUserMailPref(spref)) && !TextUtils.isEmpty(Utils.getUserPassPref(spref))){
            startActivity(intentMain);
        }
        else {
            startActivity(intentLogin);
        }

        finish();
    }
}
