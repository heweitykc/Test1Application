package com.palmmob3.libs.util;

import android.util.Log;

import java.util.Locale;

public class Logger {

   static public boolean isLoggable(){
      return true;
   }

   static public void d(String tag, String fmt, Object... args){
      Log.d(tag, format(fmt, args));
   }

   static private String format(String fmt, Object... args) {
      if(args == null || args.length <= 0){
         return fmt;
      }
      return String.format(Locale.getDefault(), fmt, args);
   }
}
