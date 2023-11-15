package com.example.mostri_in_tasca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mostri_in_tasca.ApiStuff.ApiInterface;
import com.example.mostri_in_tasca.ApiStuff.RetrofitProvider;
import com.example.mostri_in_tasca.ApiStuff.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiInterface = RetrofitProvider.getApiInterface();
        Call<SignUpResponse> signUpCall = apiInterface.register();
        signUpCall.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, retrofit2.Response<SignUpResponse> response) {
                if (!response.isSuccessful()) {
                    Log.d("Sergio", "Error: " + response.code());
                    return;
                }
                SignUpResponse result = response.body();
                Log.d("TAG", "onResponse:  "+ result.sid);
            }
            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Log.d("Sergio", "Error: " + t.getMessage());
            }
        });
    }





}