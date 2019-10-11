package com.example.inmobiliaria2.ui.propiedades;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.inmobiliaria2.R;
import com.example.inmobiliaria2.tabPropiedad;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PropiedadesFragment extends Fragment implements PropFragment.OnFragmentInteractionListener {

    private PropiedadesViewModel propiedadesViewModel;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        propiedadesViewModel =
                ViewModelProviders.of(this).get(PropiedadesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_propiedades, container, false);
        final TextView textView = root.findViewById(R.id.text_share);


        viewPager = root.findViewById(R.id.viewPageProp);
        appBarLayout = root.findViewById(R.id.appBar);

        tabLayout = new TabLayout(getContext());

        appBarLayout.addView(tabLayout);

        ViewPageAdapter vpa = new ViewPageAdapter(getActivity().getSupportFragmentManager());

        tabPropiedad prop1 = new tabPropiedad("Casa", "A. del Valle 950", 3, "Residencial", 100500, true);
        vpa.addFragment(new PropFragment(prop1), "Prop1");
        tabPropiedad prop2 = new tabPropiedad("Departamento", "Pringles 371", 4, "Comercial", 2348, false);
        vpa.addFragment(new PropFragment(prop2), "Prop2");

        viewPager.setAdapter(vpa);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Toast.makeText(getContext(), tab.getText(), Toast.LENGTH_LONG).show();
                String s = "hola";
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                String s = "hola";
            }
        });

        return root;
    }

    public class ViewPageAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> titulosFragment = new ArrayList<>();

        public ViewPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titulosFragment.get(position);
        }

        public void addFragment(Fragment fragment, String titulo) {
            fragmentList.add(fragment);
            titulosFragment.add(titulo);
        }

        @Override
        public int getItemPosition(Object object) {
            String a = "Hola";
            return POSITION_NONE;
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        String s = "hola";
    }
}