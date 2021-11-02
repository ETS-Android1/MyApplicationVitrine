package com.example.myapplicationvitrine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ACTLaucher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actlaucher);
        //Je lance activity main
        apelActivity();
    }

    private void apelActivity(){
        // On crée un Intent (Une intention)
        // Création de l'intent qui indique l'activité que l'on souhaite ouvrir
        Intent intent = new Intent (this, MainActivity.class);

        // Lancement de l'activité déclarée dans l'intent
        startActivity(intent);

        // Si on souhaite fermer l'activité initiale on execute le finish
         finish();
    }

}