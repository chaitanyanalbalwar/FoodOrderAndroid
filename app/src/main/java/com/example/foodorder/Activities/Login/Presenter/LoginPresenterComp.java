package com.example.foodorder.Activities.Login.Presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.foodorder.Activities.Login.Model.ILogin;
import com.example.foodorder.Activities.Login.Model.LoginModel;
import com.example.foodorder.Activities.Login.View.ILoginView;

public class LoginPresenterComp implements LoginPresenter {

    ILoginView iLoginView;
    ILogin user;
    Handler handler;

    public LoginPresenterComp(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }


    @Override
    public void doLogin(String mobile) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(mobile);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 5000);
    }

    @Override
    public void setProgressBarVisiblity(int visiblity){
        iLoginView.onSetProgressBarVisibility(visiblity);
    }

    private void initUser(){
        user = new LoginModel("9876543210");
    }
}
