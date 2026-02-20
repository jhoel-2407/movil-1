package com.gxnova.appgxnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Auth extends AppCompatActivity {

    Button btnLogin;
    Button btnRegister;
    TextView tabLogin, tabRegister;
    LinearLayout layoutLogin, layoutRegister;

    EditText inputEmailLogin;
    EditText inputPasswordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        tabLogin = findViewById(R.id.tabLogin);
        tabRegister = findViewById(R.id.tabRegister);

        layoutLogin = findViewById(R.id.layoutLogin);
        layoutRegister = findViewById(R.id.layoutRegister);

        inputEmailLogin = findViewById(R.id.inputEmailLogin);
        inputPasswordLogin = findViewById(R.id.inputPasswordLogin);

        // 🔥 LOGIN CON API REAL
        btnLogin.setOnClickListener(v -> {

            String email = inputEmailLogin.getText().toString();
            String password = inputPasswordLogin.getText().toString();

            ApiService apiService = RetrofitClient.getClient(Auth.this).create(ApiService.class);

            LoginRequest request = new LoginRequest(email, password);

            apiService.login(request).enqueue(new Callback<LoginResponse>() {

                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                    if(response.isSuccessful()){

                        Toast.makeText(Auth.this,"Login correcto",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Auth.this, Inicio.class);
                        startActivity(intent);

                    }else{

                        Toast.makeText(Auth.this,"Credenciales incorrectas",Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {

                    Toast.makeText(Auth.this,"Error conexión API",Toast.LENGTH_SHORT).show();

                }
            });
        });

        // 🔵 REGISTER AÚN NORMAL (después lo conectamos)
        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(Auth.this, Inicio.class);
            startActivity(intent);
        });

        // TAB LOGIN
        tabLogin.setOnClickListener(view -> {

            layoutLogin.setVisibility(View.VISIBLE);
            layoutRegister.setVisibility(View.GONE);

            tabLogin.setBackgroundResource(R.drawable.bg_tab_active);
            tabLogin.setTextColor(getColor(R.color.gx_black));

            tabRegister.setBackgroundResource(R.drawable.bg_tab_inactive);
            tabRegister.setTextColor(getColor(R.color.gx_black));
        });

        // TAB REGISTER
        tabRegister.setOnClickListener(view -> {

            layoutLogin.setVisibility(View.GONE);
            layoutRegister.setVisibility(View.VISIBLE);

            tabRegister.setBackgroundResource(R.drawable.bg_tab_active);
            tabRegister.setTextColor(getColor(R.color.gx_black));

            tabLogin.setBackgroundResource(R.drawable.bg_tab_inactive);
            tabLogin.setTextColor(getColor(R.color.gx_black));
        });
    }
}
