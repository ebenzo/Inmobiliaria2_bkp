package com.example.inmobiliaria2.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliaria2.ModelosInmobiliaria;
import com.example.inmobiliaria2.Propietario;
import com.example.inmobiliaria2.R;
import com.google.android.material.navigation.NavigationView;

public class PerfilFragment extends Fragment {

    private PerfilViewModel toolsViewModel;
    Propietario prop;
    EditText dni;
    EditText apellido;
    EditText nombre;
    EditText tel;
    EditText email;
    EditText pass;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

        final TextView textView = root.findViewById(R.id.text_tools);
        textView.setText("Propietario");

        final Button editar = root.findViewById(R.id.btnEditar);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = editar.getText().toString().toUpperCase();
                if (editar.getText().toString().toUpperCase().equals("EDITAR")) {
                    setControlsEnabled(true);

                    editar.setText("GUARDAR");
                }
                else if (editar.getText().toString().toUpperCase().equals("GUARDAR")) {
                    prop = new Propietario(1,
                            dni.getText().toString(),
                            apellido.getText().toString(),
                            nombre.getText().toString(),
                            tel.getText().toString(),
                            email.getText().toString(),
                            pass.getText().toString());
                    ModelosInmobiliaria.setProp(prop);
                    setControlsEnabled(false);
                    editar.setText("EDITAR");

                    NavigationView nav = ModelosInmobiliaria.getNavigationView();
                    View header = nav.getHeaderView(0);
                    TextView headerNombre = header.findViewById(R.id.headerNombreProp);
                    TextView headerEmail = header.findViewById(R.id.headerEmailProp);
                    headerEmail.setText(email.getText().toString());
                    headerNombre.setText(nombre.getText().toString());
                }
            }
        });

        getControls(root);
        setDatosDefault();

        return root;
    }

    public void getControls(View root) {
        dni = root.findViewById(R.id.textDni);
        apellido = root.findViewById(R.id.textApellido);
        nombre = root.findViewById(R.id.textNombre);
        tel = root.findViewById(R.id.textTelefono);
        email = root.findViewById(R.id.textEmail);
        pass = root.findViewById(R.id.textPassword);
    }

    public void setControlsEnabled(boolean editable) {
        dni.setEnabled(editable);
        apellido.setEnabled(editable);
        nombre.setEnabled(editable);
        tel.setEnabled(editable);
        email.setEnabled(editable);
        pass.setEnabled(editable);
    }

    public void setDatosDefault() {
        prop = ModelosInmobiliaria.getProp();
        if (prop == null) {
            prop = new Propietario(1,
                    "33800801",
                    "Benzo",
                    "Emmanuel",
                    "26647159366",
                    "benzoemma@gmail.com",
                    "123");
        }

        dni.setText(prop.getDni());
        apellido.setText(prop.getApellido());
        nombre.setText(prop.getNombre());
        tel.setText(prop.getTelefono());
        email.setText(prop.getEmail());
        pass.setText(prop.getPassword());
    }

    public void setDatosModifcados() {

    }
}