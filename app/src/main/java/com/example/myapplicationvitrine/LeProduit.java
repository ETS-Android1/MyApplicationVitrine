package com.example.myapplicationvitrine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LeProduit extends AppCompatActivity{

    private TextView tvTitreProduit = null;
    private TextView tvPrixProduit = null;
    private TextView tvIngredientsProduit = null;
    private ImageView imProduit = null;
   // private Button btnAddFavoris = null;

    String nomProduit=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_produit);

        // Associer du Vue XML au Java
        fct_associationViewAuJava();
        AppelIntent.fct_remplirLaVuePageProduit(this,
                                                getIntent(),
                                                tvTitreProduit,
                                                tvPrixProduit,
                                                tvIngredientsProduit,
                                                imProduit);



    }

    // On associe le XML avec le JAVA
    private void fct_associationViewAuJava(){
        this.tvTitreProduit =findViewById(R.id.tvTitreProduit);
        this.tvPrixProduit=findViewById(R.id.tvPrixProduit);
        this.tvIngredientsProduit =findViewById(R.id.tvIngredientsProduit);
        this.imProduit =findViewById(R.id.imProduit);
       // this.btnAddFavoris=findViewById(R.id.btnAddFavoris);

    }


    public void appelAide(View view) {

        //Appeller intent simple
        AppelIntent.appelIntentSimple(this, Aide.class);
    }

    public void appelHome(View view) {
        AppelIntent.appelIntentSimple(this,MainActivity.class);
    }

    public void ajouteFavoris(View view) {
        nomProduit = tvTitreProduit.getText().toString();
        AppelIntent.appelIntentAvecExtra(this, nomProduit ,Favoris.class);

    }
}
