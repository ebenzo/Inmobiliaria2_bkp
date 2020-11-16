package com.example.InmobiliariaApi.ui.inquilinos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.InmobiliariaApi.ItemInquilino;
import com.example.InmobiliariaApi.ListaInquilinos;
import com.example.InmobiliariaApi.R;

import java.util.ArrayList;

public class InquilinosFragment extends Fragment {

    private InquilinosViewModel inquilinosViewModel;
    private ArrayList<ItemInquilino> lista = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        inquilinosViewModel =
                ViewModelProviders.of(this).get(InquilinosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inquilinos, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);

        textView.setText("Lista Inquilinos");

        cargarDatos();
        generarListView(root);

        return root;
    }

    public void generarListView(View root) {

        //getActivity()
        //getContext()
        ArrayAdapter<ItemInquilino> adapter = new ListaInquilinos(getContext(), R.layout.item_inquilino, lista, getLayoutInflater());
        ListView lv = root.findViewById(R.id.listaInquilinos);
        lv.setAdapter(adapter);

    }

    public void cargarDatos() {

        lista.add(new ItemInquilino("37513955", "Perez", "Juan", "Pringles 501", "12345"));
        lista.add(new ItemInquilino("33800801", "Benzo", "Emmanuel", "A. del Valle 950", "68311156"));
        lista.add(new ItemInquilino("33800801", "Diego", "Torres", "Justo Daract 2478", "28118948765"));
    }
}