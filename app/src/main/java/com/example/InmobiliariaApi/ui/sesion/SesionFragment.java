package com.example.InmobiliariaApi.ui.sesion;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.InmobiliariaApi.R;

public class SesionFragment extends Fragment {

    private SesionViewModel sesionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sesionViewModel =
                ViewModelProviders.of(this).get(SesionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sesion, container, false);
        final TextView textView = root.findViewById(R.id.text_sesion);

        textView.setText("Cerrar Sesión");
        Button cerrar =  root.findViewById(R.id.botonCerrar);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast.makeText(getContext(), "La sesión fue cerrada correctamente", Toast.LENGTH_LONG).show();*/
                cerrarSesion();
            }
        });
        
        return root;
    }

    public void cerrarSesion() {
        new AlertDialog.Builder(getContext())
            .setTitle("Cerrar sesion")
            .setMessage("Esta seguro?")
            .setPositiveButton("Si", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            }).show();
    }
}