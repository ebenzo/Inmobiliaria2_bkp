package com.example.inmobiliaria2.ui.sesion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliaria2.R;

public class SesionFragment extends Fragment {

    private SesionViewModel sesionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sesionViewModel =
                ViewModelProviders.of(this).get(SesionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sesion, container, false);
        final TextView textView = root.findViewById(R.id.text_sesion);
        /*sesionViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        textView.setText("Cerrar Sesión");
        Button cerrar =  root.findViewById(R.id.botonCerrar);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "La sesión fue cerrada correctamente", Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }
}