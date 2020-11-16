package com.example.InmobiliariaApi.ui.login;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.InmobiliariaApi.DrawerActivity;
import com.example.InmobiliariaApi.R;

/*



esta activity vendria a ser como el login pero se llama MainActivity



*/
public class MainActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private Button btnLogin;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new clickLogin());

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginViewModel.getError().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer s) {

                //error.setVisibility(s);
            }
        });
        loginViewModel.getToken().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Intent i = new Intent(getApplicationContext(), DrawerActivity.class);
                //le llevo todos los parametros que va a usar la vista
                i.putExtra("email", "benzoemma@gmail.com");
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
    }

    class clickLogin implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (!email.getText().toString().trim().equals("") && !password.getText().toString().trim().equals("")) {
                loginViewModel.ingresar(email.getText().toString(), password.getText().toString());
            }
            else {
                Toast.makeText(getApplicationContext(), "Complete todos los campos", Toast.LENGTH_LONG).show();
            }
        }
    }

}
