package com.example.inmobiliaria2.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliaria2.Propietario;
import com.example.inmobiliaria2.R;

public class PerfilFragment extends Fragment {

    private PerfilViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        /*toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        textView.setText("Propietario");

        Propietario prop = new Propietario(1, "33800801", "Benzo", "Emmanuel", "26647159366", "benzoemma@gmail.com", "123");

        EditText dni = root.findViewById(R.id.textDni);
        dni.setText(prop.getDni());

        EditText apellido = root.findViewById(R.id.textApellido);
        apellido.setText(prop.getApellido());

        EditText nombre = root.findViewById(R.id.textNombre);
        nombre.setText(prop.getNombre());

        EditText tel = root.findViewById(R.id.textTelefono);
        tel.setText(prop.getTelefono());

        EditText email = root.findViewById(R.id.textEmail);
        email.setText(prop.getEmail());

        EditText pass = root.findViewById(R.id.textPassword);
        pass.setText(prop.getPassword());


        return root;
    }
}