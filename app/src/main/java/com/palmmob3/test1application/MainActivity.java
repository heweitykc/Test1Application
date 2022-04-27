package com.palmmob3.test1application;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.palmmob3.libs.util.Logger;
import com.palmmob3.test1application.databinding.ActivityMain2Binding;

public class MainActivity extends AppCompatActivity {

    final String TAG = "MainActivity";

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Logger.d(TAG, "onCreate");

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setItemIconTintList(null);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Logger.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Logger.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Logger.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Logger.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Logger.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Logger.d(TAG, "onDestroy");
    }
}