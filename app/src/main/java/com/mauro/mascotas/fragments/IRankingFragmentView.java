package com.mauro.mascotas.fragments;

import com.mauro.mascotas.adapters.MascotaAdaptador;
import com.mauro.mascotas.classes.Mascota;

import java.util.ArrayList;

public interface IRankingFragmentView {

    public void generateLinearLayot();
    public MascotaAdaptador generateMascotaAdaptador(ArrayList<Mascota> mascotas );
    public void initAdaptadorRV( MascotaAdaptador adaptador );

}
