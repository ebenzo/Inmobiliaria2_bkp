package com.example.inmobiliaria2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListaContratos extends ArrayAdapter<Contrato> {

    private Context context;
    private List<Contrato> lista;
    private LayoutInflater li;

    public ListaContratos(@NonNull Context context, int resource, @NonNull List<Contrato> objects, LayoutInflater li) {
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
            itemView = li.inflate(R.layout.item_contrato, parent, false);
        }

        Contrato c = lista.get(position);
        EditText textNroContrato = itemView.findViewById(R.id.textNroContrato);
        textNroContrato.setText(c.getIdContrato() + "");

        EditText textFechaInicio = itemView.findViewById(R.id.textFechaInicioContrato);
        textFechaInicio.setText(c.getFechaInicio().toString());

        EditText textFechaFin = itemView.findViewById(R.id.textFechaFinContrato);
        textFechaFin.setText(c.getFechaFin().toString());

        EditText textImporteContrato = itemView.findViewById(R.id.textImporteContrato);
        textImporteContrato.setText(c.getImporte() + "");

        return itemView;

    }
}
