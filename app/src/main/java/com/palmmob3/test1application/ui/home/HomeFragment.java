package com.palmmob3.test1application.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.palmmob3.test1application.bean.User;
import com.palmmob3.test1application.databinding.FragmentHomeBinding;
import com.palmmob3.test1application.services.MyLocationService;
import com.palmmob3.test1application.ui.adapter.RecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private RecycleViewAdapter mRv01Adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mRv01Adapter = new RecycleViewAdapter(null);

        final TextView textView = binding.textHome;
        final RecyclerView rv01 = binding.rv01;

        rv01.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rv01.setAdapter(mRv01Adapter);

        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        homeViewModel.getUserList().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                mRv01Adapter.setUsers(users);
                mRv01Adapter.notifyDataSetChanged();
            }
        });


        binding.btnStart.setOnClickListener(v -> startGps(v));
        binding.btnStop.setOnClickListener(v -> stopGps(v));

        return root;
    }

    public void startGps(View view){
        getActivity().startService(new Intent(getActivity(), MyLocationService.class));
        homeViewModel.setText("startGps");
        homeViewModel.setUserList(getusers1());
    }

    public void stopGps(View view){
        getActivity().stopService(new Intent(getActivity(), MyLocationService.class));
        homeViewModel.setText("stopGps");
        homeViewModel.setUserList(getusers2());
    }

    List<User> getusers1(){
        List<User> users = new ArrayList<>();
        for(int i=0;i<20;i++){
            users.add(new User("test1_" + i));
        }
        return users;
    }

    List<User> getusers2(){
        List<User> users = new ArrayList<>();
        for(int i=0;i<10;i++){
            users.add(new User("test2_" + i));
        }
        return users;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}