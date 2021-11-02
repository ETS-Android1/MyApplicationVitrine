package com.example.myapplicationvitrine;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;


public class Favoris extends AppCompatActivity {

    private TextView tvProduit;
    private TextView tvPrixProd;
    private TableLayout tl;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);

        // Association view au java
        fct_associationViewAuJava();

        //ajouterRow(tl);

        AppelIntent.fct_remplirLaVuePageFavoris(this,getIntent(),tvProduit, tvPrixProd);

    }

    // On associe le XML avec le JAVA
    private void fct_associationViewAuJava(){
        this.tvProduit =findViewById(R.id.tvProduit);
        this.tvPrixProd=findViewById(R.id.tvPrixProd);
        this.tl = findViewById(R.id.tlListProduitFavoris);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void ajouterRow(TableLayout tl){

        // Create a new row to be added
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        //Creer 2 TextView
      TextView tvNewProduit = new TextView(this);
      TextView tvNewPrixProduit = new TextView(this);
       tvNewProduit.setTextAppearance(R.style.TableColumStyle0);
       tvNewPrixProduit.setTextAppearance(R.style.TableColumStyle1);
        tvNewProduit.setText("new Produit");
        tvNewPrixProduit.setText("new prix");

        //Creer 1 checkbox
        CheckBox cbNewAjoutePanier = new CheckBox(this);

        //2 ways to set Style
        //TextViewCompat.setTextAppearance(cbNewAjoutePanier,R.style.TableColumStyle1);
        cbNewAjoutePanier.setTextAppearance(R.style.TableColumStyle1);
        cbNewAjoutePanier.setText("Ajoutez  au panier");

        //Ajouter les Textviews et checkbox a la ligne
        tr.addView(tvNewProduit);
        tr.addView(tvNewPrixProduit);
        tr.addView(cbNewAjoutePanier);

        // Add row to TableLayout.
        tl.addView(tr);
    }

    public void appelHome(View view) {
        AppelIntent.appelIntentSimple(this,MainActivity.class);
    }

    public void appelAide(View view) {
        AppelIntent.appelIntentSimple(this,Aide.class);
    }
}