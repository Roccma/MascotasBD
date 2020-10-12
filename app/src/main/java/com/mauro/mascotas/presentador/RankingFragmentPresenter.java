package com.mauro.mascotas.presentador;

import android.content.Context;

import com.mauro.mascotas.classes.Mascota;
import com.mauro.mascotas.db.ConstructorRanking;
import com.mauro.mascotas.fragments.IRankingFragmentView;

import java.util.ArrayList;

public class RankingFragmentPresenter implements IRankingFragmentPresenter {

    private IRankingFragmentView iRankingFragmentView;
    private Context context;
    private ConstructorRanking constructorRanking;
    private ArrayList<Mascota> ranking;

    public RankingFragmentPresenter(IRankingFragmentView iRankingFragmentView, Context context) {
        this.iRankingFragmentView = iRankingFragmentView;
        this.context = context;
    }

    @Override
    public void obtenerRankingBD() {
        constructorRanking = new ConstructorRanking( context );
        ranking = constructorRanking.getRanking();
        mostrarRanking();
    }

    @Override
    public void mostrarRanking() {
        iRankingFragmentView.initAdaptadorRV( iRankingFragmentView.generateMascotaAdaptador( ranking ) );
        iRankingFragmentView.generateLinearLayot();
    }
}
