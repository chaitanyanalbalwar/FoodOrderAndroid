package com.example.foodorder.Activities.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.foodorder.Activities.Login.Presenter.LoginPresenter;
import com.example.foodorder.Activities.Login.Presenter.LoginPresenterComp;
import com.example.foodorder.Activities.Login.View.ILoginView;
import com.example.foodorder.Activities.MainActivity;
import com.example.foodorder.Interface.UserService;
import com.example.foodorder.Model.ResObj;
import com.example.foodorder.R;
import com.example.foodorder.Util.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements ILoginView {


    public static final String MyPREFERENCES = "FoodOrder";
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    EditText edtMobileNo;
    Button btnLogin;
    UserService userService;

    private LoginPresenter loginPresenter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        sp = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sp.edit();


        edtMobileNo = (EditText) findViewById(R.id.edt_mobile_number);
        btnLogin = (Button) findViewById(R.id.btn_login);
        progressBar=findViewById(R.id.progress_login);
        userService = ApiUtils.getUserService();

        loginPresenter = new LoginPresenterComp(this);
        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*String username = edtMobileNo.getText().toString();

                Intent i = new Intent(LoginActivity.this, Otp_Activity.class);
                startActivity(i);*/


                loginPresenter.setProgressBarVisiblity(View.VISIBLE);
                btnLogin.setEnabled(false);
                loginPresenter.doLogin(edtMobileNo.getText().toString());

            }
        });
    }


    private boolean validateLogin(String username, String password){
        if(username == null || username.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    private void doLogin(final String username,final String password){
        Call call = userService.login(username,password);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    ResObj resObj = (ResObj) response.body();
                    if(resObj.getMessage().equals("true")){
                        //login start main activity
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("username", username);
                        startActivity(intent);

                    } else {
                        Toast.makeText(LoginActivity.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onLoginResult(Boolean result, int code) {

        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
        btnLogin.setEnabled(true);
        if (result){
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this,MainActivity.class));
        }
        else
            Toast.makeText(this,"Login Fail, code = " + code,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }
}
