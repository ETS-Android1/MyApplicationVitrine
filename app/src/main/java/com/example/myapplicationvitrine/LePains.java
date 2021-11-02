package com.example.myapplicationvitrine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LePains extends AppCompatActivity {

    private TextView tvTitreCategorie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_pains);
        // Associer view a Java
        this.tvTitreCategorie = findViewById(R.id.tvTitreCategorie);
        // Afficher le titre du page
        AppelIntent.fct_remplirLaVuePageCategorie(this,getIntent(),tvTitreCategorie);
    }

    public void appelHome(View view) {
        AppelIntent.appelIntentSimple(this,MainActivity.class);
    }

    public void appelPainTradition(View view) {
        AppelIntent.appelIntentAvecExtra(this,"Pain Tradition",LeProduit.class);
    }

    public void appelBaguette(View view) {
        AppelIntent.appelIntentAvecExtra(this,"Baguette",LeProduit.class);
    }

    public void appelAide(View view) {
        AppelIntent.appelIntentSimple(this,Aide.class);
    }
}