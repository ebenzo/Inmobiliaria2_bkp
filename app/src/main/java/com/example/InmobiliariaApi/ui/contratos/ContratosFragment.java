package com.example.InmobiliariaApi.ui.contratos;

import android.os.Bundle;
import android.text.format.DateFormat;
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

import com.example.InmobiliariaApi.Contrato;
import com.example.InmobiliariaApi.ListaContratos;
import com.example.InmobiliariaApi.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ContratosFragment extends Fragment {

    private ContratosViewModel contratosViewModel;
    private Spinner spinnerPropContratos;
    private String[] strPropiedades;
    private List<String> listaPropContratos;
    private List<Contrato> listaContratos;
    private ArrayAdapter<String> comboAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contratosViewModel =
                ViewModelProviders.of(this).get(ContratosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contratos, container, false);

        cargarSpinnerPropiedades(root);
        
        return root;
    }

    private void cargarContratoProp1() {
        listaContratos = new ArrayList<>();
        DateFormat df = new android.text.format.DateFormat();
        String fechaInicio = df.format("dd-MM-yyyy", new Date(2018 - 1900, 10, 9)).toString();
        String fechaFin = df.format("dd-MM-yyyy", new Date(2019 - 1900, 12, 31)).toString();
        listaContratos.add(new Contrato(10, fechaInicio, fechaFin, 123 ));
    }

    private void cargarContratoProp2() {
        listaContratos = new ArrayList<>();
        DateFormat df = new android.text.format.DateFormat();
        String fechaInicio = df.format("dd-MM-yyyy", new Date(2018 - 1900, 5, 1)).toString();
        String fechaFin = df.format("dd-MM-yyyy", new Date(2020 - 1900, 12, 1)).toString();
        listaContratos.add(new Contrato(11, fechaInicio, fechaFin, 123456 ));
    }

    public void generarListView(View root) {

        ArrayAdapter<Contrato> adapter = new ListaContratos(getContext(), R.layout.item_contrato, listaContratos, getLayoutInflater());
        ListView lv = root.findViewById(R.id.listaContratos);
        lv.setAdapter(adapter);

    }

    private void cargarSpinnerPropiedades(final View root) {

        spinnerPropContratos = (Spinner) root.findViewById(R.id.spinnerPropiedadesContratos);
        listaPropContratos = new ArrayList<>();
        strPropiedades = new String[] {"Prop1", "Prop2"};
        Collections.addAll(listaPropContratos, strPropiedades);
        comboAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, listaPropContratos);
        spinnerPropContratos.setAdapter(comboAdapter);

        spinnerPropContratos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()){
                    case R.id.spinnerPropiedadesContratos:

                        if (position == 0)
                            cargarContratoProp1();
                        else if (position == 1)
                            cargarContratoProp2();
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