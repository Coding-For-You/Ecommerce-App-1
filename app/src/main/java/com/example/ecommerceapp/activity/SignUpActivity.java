package com.example.ecommerceapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.api.APIClient;
import com.example.ecommerceapp.databinding.ActivitySignUpBinding;
import com.example.ecommerceapp.model.SingleMessageResponse.SingleMessageResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpApiCall();

            }
        });
    }

    private void signUpApiCall() {

        String username, email, password;

        username = binding.editUsername.getText().toString().trim();
        email = binding.editEmail.getText().toString().trim();
        password = binding.editPassword.getText().toString().trim();

        if (username.isEmpty()) {
            binding.editUsername.setError("Invalid Username");
            return;
        } else if (email.isEmpty()) {
            binding.editEmail.setError("Invalid Email");
            return;
        } else if (password.isEmpty()) {
            binding.editPassword.setError("Invalid Password");
            return;
        }
        Call<SingleMessageResponse> call = APIClient.getInstance().getApi().register(username, email, password
        );
        call.enqueue(new Callback<SingleMessageResponse>() {
            @Override
            public void onResponse(Call<SingleMessageResponse> call, Response<SingleMessageResponse> response) {

                if (response.isSuccessful()) {
                    SingleMessageResponse registerResponse = response.body();
                    if (registerResponse.getCode() == 200) {
                        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                        finishAffinity();
                        Toast.makeText(SignUpActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUpActivity.this, "Failed due to: " + registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<SingleMessageResponse> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}