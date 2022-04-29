package com.palmmob3.test1application;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLocationObserver implements LifecycleObserver {
   private Context context;
   private LocationManager locationManager;
   private MyLocationListener myLocationListener;
   public MyLocationObserver(Context context) {
      this.context = context;
   }

   @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
   public void startGetLocation() {
      Log.d("liang", "startGetLocation");
      locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
      myLocationListener = new MyLocationListener();
      if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
         return;
      }
      locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 1, myLocationListener);
   }


   @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
   public void stopGetLocation() {
      Log.d("liang", "stopGetLocation");
      locationManager.removeUpdates(myLocationListener);
   }

   static class MyLocationListener implements LocationListener {

      @Override
      public void onLocationChanged(Location location) {
         Log.d("liang", "location changed" + location.toString());
      }

      @Override
      public void onStatusChanged(String provider, int status, Bundle extras) {

      }

      @Override
      public void onProviderEnabled(String provider) {

      }

      @Override
      public void onProviderDisabled(String provider) {

      }
   }
}
