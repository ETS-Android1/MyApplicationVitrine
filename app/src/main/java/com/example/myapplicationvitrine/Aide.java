package com.example.myapplicationvitrine;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Aide extends AppCompatActivity {

    private TextView tvAideMenu = null;
    private EditText eTxtName = null;
    private EditText eTxtEmail = null;
    private EditText eTxtSubjet = null;
    private EditText eTxtMessage = null;
    private Button  btnValide = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aide);

        fct_associationViewAuJava();

        tvAideMenu.setText("Je suis a votre aide");

    }

    // On associe le XML avec le JAVA
    private void fct_associationViewAuJava(){
        this.tvAideMenu = findViewById(R.id.tvAideMenu);
        this.eTxtName = findViewById(R.id.eTxtName);
        this.eTxtEmail = findViewById(R.id.eTxtEmail);
        this.eTxtSubjet = findViewById(R.id.eTxtSubjet);
        this.eTxtMessage = findViewById(R.id.eTxtMessage);
        this.btnValide = findViewById(R.id.btnValide);
    }

    public void actValide(View view) {
        String name = null;
        String mail = null;
        String subjet = null;
        String message = null;

        name= ajouteText(eTxtName);
        mail= ajouteText(eTxtEmail);
        subjet= ajouteText(eTxtSubjet);
        message= ajouteText(eTxtMessage);

        if (name!=null && mail!=null && subjet!=null && message!=null){
            tvAideMenu.setText(" Votre demande a bien ete enregistree!"
                         + "\n Nom :" + name
                         + "\n Email: " + mail
                         + "\n Subjet: "+ subjet
                         + "\n Message: "+ message   );
            tvAideMenu.setTextColor(Color.BLACK);
        }else {
            tvAideMenu.setText("Ajoutez vos informations et message pour valider votre demande");
            tvAideMenu.setTextColor(Color.RED);
        }

    }

    public String ajouteText( EditText edT) {
        String t= null;
        // Verifier si editText est vide
        if (TextUtils.isEmpty(edT.getText())) {

            //set error et required
            edT.setError("Entre votre Nom, svp!");
        } else {
            // mettre text dans editText au valeur de text
            t = edT.getText().toString();
        }
        return t;
    }

    //retour du MainActivity
    public void appelHome(View view) {
        AppelIntent.appelIntentSimple(this,MainActivity.class);
    }
}