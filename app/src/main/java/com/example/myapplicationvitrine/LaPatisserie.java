package com.example.myapplicationvitrine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LaPatisserie extends AppCompatActivity {
    // Déclaration des View à modifier en programmation

    private TextView tvTitreCategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_la_patisserie);

        // Apeller fonction association des le XML avec le JAVA
        this.fct_associationViewAuJava();
        AppelIntent.fct_remplirLaVuePageCategorie(this,getIntent(),tvTitreCategorie);
    }

    // On associe le XML avec le JAVA
    private void fct_associationViewAuJava() {
        this.tvTitreCategorie = findViewById(R.id.tvTitreCategorie);

    }


    public void appelProdChesse(View view) {

        AppelIntent.appelIntentAvecExtra(this,"Chesse Cake",LeProduit.class);

    }

    public void appelProdTarte(View view) {
        AppelIntent.appelIntentAvecExtra(this,"Tarte tiramisu",LeProduit.class);
    }

    public void apelHome(View view) {

        AppelIntent.appelIntentSimple(this, MainActivity.class);
    }


    public void appelAide(View view) {

        //Appeller intent simple
        AppelIntent.appelIntentSimple(this, Aide.class);
    }


}