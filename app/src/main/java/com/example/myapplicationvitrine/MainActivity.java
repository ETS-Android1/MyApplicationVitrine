package com.example.myapplicationvitrine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Déclaration des View à modifier en programmation

    private Button btnFavoris = null;
    private TextView tvPain = null;
    private TextView tvViennois = null;
    private TextView tvPatisserie = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fct_associationViewAuJava();
    }

    // On associe le XML avec le JAVA
    private void fct_associationViewAuJava(){
        this.tvPain = findViewById(R.id.tvPain);
        this.tvViennois = findViewById(R.id.tvViennois);
        this.tvPatisserie = findViewById(R.id.tvPatisserie);
        this.btnFavoris = findViewById(R.id.btnFavoris);

    }


    public void apelPain(View view) {
        AppelIntent.appelIntentAvecExtra(this,"Les Pains", LePains.class);
    }

    public void apelViennois(View view) {
        //Appeller intent extra pour envoyer les texts
        AppelIntent.appelIntentAvecExtra(this,"La Viennoisserie", LaViennoisserie.class);
    }

    public void apelPatisserie(View view) {
        //Appeller intent extra pour envoyer les texts
        AppelIntent.appelIntentAvecExtra(this,"La Patisserie", LaPatisserie.class);
    }

    public void apelAide(View view) {

        //Appeller intent simple
        AppelIntent.appelIntentSimple(this, Aide.class);
    }




}