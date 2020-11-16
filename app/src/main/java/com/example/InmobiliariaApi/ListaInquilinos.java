package com.example.InmobiliariaApi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListaInquilinos extends ArrayAdapter<ItemInquilino> {

    private Context context;
    private List<ItemInquilino> lista;
    private LayoutInflater li;

    public ListaInquilinos(@NonNull Context context, int resource, @NonNull List<ItemInquilino> objects, LayoutInflater li) {
        super(context, resource, objects);

        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;
        if (itemView == null) {
            itemView = li.inflate(R.layout.item_inquilino, parent, false);
        }

        ItemInquilino inmueble = lista.get(position);
        EditText dni = itemView.findViewById(R.id.textDni);
        dni.setText(inmueble.getDni());

        EditText apellido = itemView.findViewById(R.id.textApellido);
        apellido.setText(inmueble.getApellido());

        EditText nombre = itemView.findViewById(R.id.textNombre);
        nombre.setText(inmueble.getNombre());

        EditText direccion = itemView.findViewById(R.id.textDireccion);
        direccion.setText(inmueble.getDireccion());

        TextView telefono = itemView.findViewById(R.id.textTelefono);
        telefono.setText(inmueble.getTelefono());

        return itemView;

    }
}
