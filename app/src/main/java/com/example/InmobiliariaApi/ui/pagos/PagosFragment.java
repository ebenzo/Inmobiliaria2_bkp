package com.example.InmobiliariaApi.ui.pagos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.InmobiliariaApi.ListaPagos;
import com.example.InmobiliariaApi.model.Pago;
import com.example.InmobiliariaApi.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PagosFragment extends Fragment {

    private PagosViewModel pagosViewModel;
    private Spinner spinnerPagos;
    private String[] strPropiedades;
    private List<String> listaProp;
    private List<Pago> listaPago2;
    private ArrayAdapter<String> comboAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pagosViewModel =
                ViewModelProviders.of(this).get(PagosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pagos, container, false);
        //final TextView textView = root.findViewById(R.id.text_pagos);
        //textView.setText("Lista Pagos");


        cargarSpinnerPagos(root);

        return root;
    }

    private void cargarPagosProp1() {
        listaPago2 = new ArrayList<>();
        listaPago2.add(new Pago("Pago 1", "05/08/19", 6841));
        listaPago2.add(new Pago("Pago 2", "06/09/19", 1234));
        listaPago2.add(new Pago("Pago 3", "07/10/19", 10000));
        listaPago2.add(new Pago("Pago 4", "02/11/19", 5550));
    }

    private void cargarPagosProp2() {
        listaPago2 = new ArrayList<>();
        listaPago2.add(new Pago("Pago 1", "01/10/19", 7000));
        listaPago2.add(new Pago("Pago 2", "02/11/19", 9500));
    }

    public void generarListView(View root) {

        ArrayAdapter<Pago> adapter = new ListaPagos(getContext(), R.layout.item_pago, listaPago2, getLayoutInflater());
        ListView lv = root.findViewById(R.id.listaPagos);
        lv.setAdapter(adapter);

    }

    private void cargarSpinnerPagos(final View root) {


        spinnerPagos = (Spinner) root.findViewById(R.id.spinnerPropiedades);
        listaProp = new ArrayList<>();
        strPropiedades = new String[] {"Prop1", "Prop2"};
        Collections.addAll(listaProp, strPropiedades);
        comboAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, listaProp);
        spinnerPagos.setAdapter(comboAdapter);

        spinnerPagos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()){
                    case R.id.spinnerPropiedades:

                        if (position == 0)
                            cargarPagosProp1();
                        else if (position == 1)
                            cargarPagosProp2();
                        generarListView(root);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}




