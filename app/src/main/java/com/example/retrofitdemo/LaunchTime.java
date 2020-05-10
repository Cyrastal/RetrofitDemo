package com.example.retrofitdemo;

import android.util.Log;

public class LaunchTime {

    private static long startTime;

    public static void startTime(){
        startTime = System.currentTimeMillis();

    }
    public static void endTimeToPrint(String mag){
        long costTime=System.currentTimeMillis()-startTime;
        Log.d(mag, "custTime: "+costTime);
    }
}
