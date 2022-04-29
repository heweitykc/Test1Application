package com.palmmob3.test1application.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.palmmob3.test1application.bean.User;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private final MutableLiveData<String> mText;

    private final MutableLiveData<List<User>> mUserList;

    public HomeViewModel(@NonNull Application application) {
        super(application);

        mText = new MutableLiveData<>();

        mUserList = new MutableLiveData<>();

        mText.setValue("This is home fragment");
    }

    public void setText(String txt){
        mText.setValue(txt);
    }

    public void setUserList(List<User> users){
        mUserList.setValue(users);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<User>> getUserList() {
        return mUserList;
    }
}