package com.example.inmobiliaria2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
    }

    class clickLogin implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (email.getText().toString().equals("emma") && password.getText().toString().equals("123")) {
                Intent i = new Intent(getApplicationContext(), DrawerActivity.class);
                //le llevo todos los parametros que va a usar la vista
                i.putExtra("email", "benzoemma@gmail.com");
                i.putExtra("nombre", email.getText().toString());
                startActivity(i);
            }
            else {
                Toast.makeText(getApplicationContext(), "Usuario y/o Password incorrectos", Toast.LENGTH_LONG).show();
            }
        }
    }

}
