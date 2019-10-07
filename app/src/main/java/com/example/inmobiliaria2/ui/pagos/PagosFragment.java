package com.example.inmobiliaria2.ui.pagos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliaria2.Pago;
import com.example.inmobiliaria2.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PagosFragment extends Fragment {

    private PagosViewModel pagosViewModel;
    private Spinner spinnerPagos;
    private String[] strPago;
    private List<String> listaPago;
    private List<Pago> listaPago2;
    private ArrayAdapter<String> comboAdapter;
    private Pago pago;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pagosViewModel =
                ViewModelProviders.of(this).get(PagosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pagos, container, false);
        final TextView textView = root.findViewById(R.id.text_pagos);
        textView.setText("Lista Pagos");

        cargarPagos();
        cargarSpinnerPagos(root);

        return root;
    }

    private void cargarPagos() {
        listaPago2 = new ArrayList<>();
        listaPago2.add(new Pago("Pago 1", "05/10/19", 6841));
        listaPago2.add(new Pago("Pago 2", "06/10/19", 1234));
        listaPago2.add(new Pago("Pago 3", "07/10/19", 10000));
    }

    private void cargarSpinnerPagos(final View root) {


        spinnerPagos = (Spinner) root.findViewById(R.id.spinnerPagos);
        listaPago = new ArrayList<>();
        strPago = new String[] {"Pago 1", "Pago 2", "Pago 3"};
        Collections.addAll(listaPago, strPago);
        comboAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, listaPago);
        spinnerPagos.setAdapter(comboAdapter);
        spinnerPagos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()){
                    case R.id.spinnerPagos:
                        //Almaceno el nombre del item seleccionado
                        pago = listaPago2.get(position);
                        EditText nroPago = root.findViewById(R.id.textNroPago);
                        nroPago.setText(pago.getNroPago());

                        EditText fechaPago = root.findViewById(R.id.textFechaPago);
                        fechaPago.setText(pago.getFechaPago());

                        EditText importe = root.findViewById(R.id.textImportePago);
                        importe.setText(pago.getImporte() + "");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}




