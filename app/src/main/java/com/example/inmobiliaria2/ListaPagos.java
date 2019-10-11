package com.example.inmobiliaria2;

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

public class ListaPagos  extends ArrayAdapter<Pago> {

    private Context context;
    private List<Pago> lista;
    private LayoutInflater li;

    public ListaPagos(@NonNull Context context, int resource, @NonNull List<Pago> objects, LayoutInflater li) {
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
            itemView = li.inflate(R.layout.item_pago, parent, false);
        }

        Pago p = lista.get(position);
        EditText nroPago = itemView.findViewById(R.id.textNroPago);
        nroPago.setText(p.getNroPago());

        EditText textFechaPago = itemView.findViewById(R.id.textFechaPago);
        textFechaPago.setText(p.getFechaPago());

        EditText textImportePago = itemView.findViewById(R.id.textImportePago);
        textImportePago.setText(p.getFechaPago());

        return itemView;

    }
}
