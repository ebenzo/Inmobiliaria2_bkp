package com.example.inmobiliaria2;

import com.google.android.material.navigation.NavigationView;

public abstract class ModelosInmobiliaria {

    private static Propietario propietario;
    private static NavigationView navigationView;
    public ModelosInmobiliaria() {

    }

    public static Propietario getProp() {
        return propietario;
    }

    public static void setProp(Propietario prop) {
        propietario = prop;
    }

    public static NavigationView getNavigationView() {
        return navigationView;
    }

    public static void setNavigationView(NavigationView navigation) {
        navigationView = navigation;
    }
}
