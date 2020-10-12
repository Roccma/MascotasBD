package com.mauro.mascotas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mauro.mascotas.R;
import com.mauro.mascotas.adapters.MascotaAdaptador;
import com.mauro.mascotas.classes.Mascota;
import com.mauro.mascotas.presentador.IRankingFragmentPresenter;
import com.mauro.mascotas.presentador.RankingFragmentPresenter;

import java.util.ArrayList;

public class RankingFragment extends Fragment implements IRankingFragmentView {

    private RecyclerView rvMascotas;
    private IRankingFragmentPresenter iRankingFragmentPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_ranking, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        iRankingFragmentPresenter = new RankingFragmentPresenter( this, getContext() );
        iRankingFragmentPresenter.obtenerRankingBD();
        generateLinearLayot();
        return v;
    }

    @Override
    public void generateLinearLayot() {
        LinearLayoutManager llm = new LinearLayoutManager( getContext() );
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador generateMascotaAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador( mascotas );
        return mascotaAdaptador;
    }

    @Override
    public void initAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter( adaptador );
    }
}