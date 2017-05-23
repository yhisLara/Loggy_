package com.example.yhislaraf.loggy;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by yhislaraf on 19-05-17.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(3000);
    }


}
