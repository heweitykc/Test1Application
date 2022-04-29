package com.palmmob3.test1application.services;

import android.util.Log;

import androidx.lifecycle.LifecycleService;

import com.palmmob3.test1application.MyLocationObserver;

public class MyLocationService extends LifecycleService {

   public MyLocationService() {
      Log.d("liang", "MyLocationService");
      MyLocationObserver myLocationObserver = new MyLocationObserver(this);
      getLifecycle().addObserver(myLocationObserver);
   }
}