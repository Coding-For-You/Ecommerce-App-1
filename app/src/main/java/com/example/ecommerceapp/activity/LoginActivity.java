package com.example.ecommerceapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ecommerceapp.MainActivity;
import com.example.ecommerceapp.R;
import com.example.ecommerceapp.api.APIClient;
import com.example.ecommerceapp.databinding.ActivityLoginBinding;
import com.example.ecommerceapp.model.SingleMessageResponse.SingleMessageResponse;
import com.example.ecommerceapp.model.loginResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginApiCall();

            }
        });
    }

    private void loginApiCall() {

        String email, password;

        email = binding.editEmail.getText().toString().trim();
        password = binding.editPassword.getText().toString().trim();

        if (email.isEmpty()) {
            binding.editEmail.setError("Invalid Email");
            return;
        } else if (password.isEmpty()) {
            binding.editPassword.setError("Invalid Password");
            return;
        }
        Call<LoginResponse> call = APIClient.getInstance().getApi().login(email, password
        );
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse.getCode() == 200) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finishAffinity();
                        Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Failed due to: " + loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}