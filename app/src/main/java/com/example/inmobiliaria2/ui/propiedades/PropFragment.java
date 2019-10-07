package com.example.inmobiliaria2.ui.propiedades;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.inmobiliaria2.R;
import com.example.inmobiliaria2.tabPropiedad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PropFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PropFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PropFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private tabPropiedad prop;

    private OnFragmentInteractionListener mListener;

    public PropFragment(tabPropiedad propiedad) {
        // Required empty public constructor

        prop = propiedad;
    }

    public PropFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PropFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PropFragment newInstance(String param1, String param2) {
        PropFragment fragment = new PropFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.tab_propiedad, container, false);

        cargarSpinnerTipos(root);
        cargarSpinnerUsos(root);

        EditText domicilio = root.findViewById(R.id.textDomicilio);
        domicilio.setText(prop.getDomicilio());
        EditText ambientes = root.findViewById(R.id.textAmbientes);
        ambientes.setText(prop.getAmbientes() + "");
        Spinner tipo = root.findViewById(R.id.spinnerTipo);
        tipo.setSelection(1);
        Spinner uso = root.findViewById(R.id.spinnerUso);
        uso.setSelection(1);
        EditText precio = root.findViewById(R.id.textPrecio);
        precio.setText(prop.getPrecio() + "");
        Switch habilitada = root.findViewById(R.id.swDisponible);
        habilitada.setChecked(prop.isDisponible());

        return  root;
    }

    private void cargarSpinnerTipos(View root) {
        Spinner spinnerTipoProp;
        String[] strTipoProp;
        List<String> listaTipo;
        ArrayAdapter<String> comboAdapter;

        //Hago referencia al spinner con el id `sp_frutas`
        spinnerTipoProp = (Spinner) root.findViewById(R.id.spinnerTipo);
        //Convierto la variable List<> en un ArrayList<>()
        listaTipo = new ArrayList<>();
        //Arreglo con nombre de frutas
        strTipoProp = new String[] {"Local", "Depósito", "Casa", "Departamento", "Otro"};
        //Agrego las frutas del arreglo `strFrutas` a la listaFrutas
        Collections.addAll(listaTipo, strTipoProp);
        //Implemento el adapter con el contexto, layout, listaFrutas
        comboAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, listaTipo);
        //Cargo el spinner con los datos
        spinnerTipoProp.setAdapter(comboAdapter);
    }

    private void cargarSpinnerUsos(View root) {
        Spinner spinnerUsoProp;
        String[] strUsoProp;
        List<String> listaUso;
        ArrayAdapter<String> comboAdapter;

        //Hago referencia al spinner con el id `sp_frutas`
        spinnerUsoProp = (Spinner) root.findViewById(R.id.spinnerUso);
        //Convierto la variable List<> en un ArrayList<>()
        listaUso = new ArrayList<>();
        //Arreglo con nombre de frutas
        strUsoProp = new String[] {"Comercial", "Residencial"};
        //Agrego las frutas del arreglo `strFrutas` a la listaFrutas
        Collections.addAll(listaUso, strUsoProp);
        //Implemento el adapter con el contexto, layout, listaFrutas
        comboAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, listaUso);
        //Cargo el spinner con los datos
        spinnerUsoProp.setAdapter(comboAdapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
