package com.example.myapplicationvitrine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LaViennoisserie extends AppCompatActivity {
    private TextView tvTitreCategorie;
    private Button btnProduit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_la_viennoisserie);

        // Apeller fonction association des le XML avec le JAVA
        this.fct_associationViewAuJava();
        AppelIntent.fct_remplirLaVuePageCategorie(this,getIntent(),tvTitreCategorie);

    }
    // On associe le XML avec le JAVA
    private void fct_associationViewAuJava(){
        this.tvTitreCategorie = findViewById(R.id.tvTitreCategorie);
        this.btnProduit1 = findViewById(R.id.btnBaguette);
    }

    // Fonction appeller du Aide
    public void appelAide(View view) {
        //Appeller intent simple
        AppelIntent.appelIntentSimple(this, Aide.class);
    }

    // Fonction retour du MainActivity
    public void apelHome(View view) {
        //Appeller intent simple
        AppelIntent.appelIntentSimple(this,MainActivity.class);
    }

    public void appelProdCroissant(View view) {
        AppelIntent.appelIntentAvecExtra(this,"Croissant",LeProduit.class);
    }

    public void appelProdPainRaisin(View view) {
        AppelIntent.appelIntentAvecExtra(this,"Pain au raisin",LeProduit.class);
    }

    public void appelProdPainChocolate(View view) {
        AppelIntent.appelIntentAvecExtra(this,"Pain au chocolat",LeProduit.class);
    }
}