package com.example.myapplicationvitrine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class AppelIntent {




    public static void appelIntentSimple(Context context, Class classAAfficher) {

        // On crée un Intent (Une intention)

        Intent intent = new Intent(context, classAAfficher);

        //lancer Intent
        context.startActivity(intent);

    }

    public static void appelIntentAvecExtra(Context context, String titrePage, Class classAAfficher) {

        // Declarer les variables pour Extra
        String listIngredient;
        String prixProduit = null;
        int imageProduit =  R.drawable.ic_launcher_background;


        // Declarer les variables local
        String[] t;

        //Declarer valeur initial pour attribute listIngredients
        listIngredient = "Liste des ingrédients: \n";

        switch (titrePage){
            case "Chesse Cake":
                t = new String[]{"Farine", "Beurre ","Citron", "Crème fraîche épaisse", " Lait", "Sucre","Chocolate",
                        "Speculoos"};
                prixProduit = ("Prix = 2€");
                imageProduit = R.drawable.biscoff_cheesecake;
                break;
            case "Tarte tiramisu":
                t = new String[]{"Farine",  "Sucre", "Mascarpone","Oeuf", "Crème liquide entière", "Amaretto","Cacao en poudre",
                        "Cafe"};
                prixProduit= ("Prix = 1,8€");
                imageProduit =  R.drawable.tartetiramisu2_600x600;
                break;
            case "Croissant":
                t = new String[]{"Farine",  "Sucre", "Sel","Levure de boulanger ", "Lait", "Beurre","Oeuf"};
                prixProduit= ("Prix = 0.85€");
                imageProduit =  R.drawable.j_ai_fait_mes_croissants_au_beurre___la_maison_;
                break;
            case "Pain au raisin":
                t = new String[]{"Farine",  "Sucre", "Sel","Levure de boulanger ", "Lait", "Beurre","Oeuf",
                        "Crème pâtissière","Raisin secs","Sirop de sucre de canne"};
                prixProduit= ("Prix = 1€");
                imageProduit =  R.drawable.pain_au_raisin;
                break;
            case "Pain au chocolat":
                t = new String[]{"Farine",  "Sucre", "Sel","Levure de boulanger ", "Lait", "Beurre","Oeuf",
                "Chocolat"};
                prixProduit= ("Prix = 0.95€");
                imageProduit =  R.drawable.pains_au_chocolat_ou_chocolatines_comme_chez_le_boulanger;
                break;
            case "Pain Tradition":
                t = new String[]{"Farine","Levure fraîche", "Eau", "Sel"};
                prixProduit= ("Prix = 1.05€");
                imageProduit =  R.drawable.crusty_french_baguette_recipe__perfect_results__so_easy___baking_a_moment;
                break;
            case "Baguette":
                t = new String[]{"Farine","Levure fraîche", "Eau", "Sel"};
                prixProduit= ("Prix = 0.90€");
                imageProduit =  R.drawable.how_to_make_french_baguette;
                break;


            default:
                t=  new String[]{"Ce produit n'a pas l'ingredient"};
                break;
        }

        // Afficher list des ingredients

        for (int i=0;i<t.length;i++) {
            // Ajouter list des ingredients
            listIngredient += ( "- " + t[i] + "\n");
        }


        // On crée un Intent (Une intention)
        Intent intent = new Intent(context, classAAfficher);


        intent.putExtra("titre", titrePage );
        intent.putExtra("liste_des_ingrédients", listIngredient );
        intent.putExtra("prix_produit", prixProduit );
        intent.putExtra("image_produit",imageProduit);

        //lancer Intent
        context.startActivity(intent);

    }

    public static void fct_remplirLaVuePageCategorie(Context context,
                                                     Intent intent1,
                                                     TextView tvTitre){
        try {
            if (intent1.hasExtra("titre") == false) {
                throw new Exception("Aucun Extra donne pour le titre");
            }
        }catch (Exception e) {

            AppelToast.displayCustomToast(context, "Erreur détectée lors du remplissage de la vue [" + e.toString() + "]");

            intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
                String text_titrePage = intent1.getStringExtra("titre");
                tvTitre.setText(text_titrePage);
    }

    public static void fct_remplirLaVuePageProduit(Context context,
                                                   Intent intent1,
                                                   TextView tvTitre,
                                                   TextView tvPrixProduit,
                                                   TextView tvListIngredients,
                                                   ImageView imv ){
        try {
            if (intent1.hasExtra("titre") == false) {
                throw new Exception("Aucun Extra donne pour le titre");
            }
            if (intent1.hasExtra("liste_des_ingrédients") == false) {
                throw new Exception("Aucun Extra donne pour la liste des ingredients");
            }
            if (intent1.hasExtra("prix_produit") == false) {
                throw new Exception("Aucun Extra donne pour le prix");
            }
            if(intent1.hasExtra("image_produit")==false) {
                throw new Exception("Aucun Extra donne pour l'image");
            }
        }catch (Exception e) {

            AppelToast.displayCustomToast(context, "Erreur détectée lors du remplissage de la vue [" + e.toString() + "]");

            intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }

        // mettre Nom du produit
        String text_titrePage = intent1.getStringExtra("titre");
        tvTitre.setText(text_titrePage);

        // mettre list des ingredients du produit
        String text_listIngredients = intent1.getStringExtra("liste_des_ingrédients");
        tvListIngredients.setText(text_listIngredients);

        // mettre prix du produit
        String text_prixProduit = intent1.getStringExtra("prix_produit");
        tvPrixProduit.setText(text_prixProduit);

        // mettre image du produit
            int id = intent1.getIntExtra("image_produit", R.drawable.ic_launcher_background);
            imv.setImageResource(id);

    }

    public static void fct_remplirLaVuePageFavoris(Context context,
                                                   Intent intent1,
                                                   TextView tvTitre,
                                                   TextView tvPrixProduit){
        try {
            if (intent1.hasExtra("titre") == false) {
                throw new Exception("Aucun Extra donne pour le titre");
            }
            if (intent1.hasExtra("prix_produit") == false) {
                throw new Exception("Aucun Extra donne pour le prix");
            }

        }catch (Exception e) {

            AppelToast.displayCustomToast(context, "Erreur détectée lors du remplissage de la vue [" + e.toString() + "]");

            intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }

        // mettre Nom du produit
        String text_titrePage = intent1.getStringExtra("titre");
        tvTitre.setText(text_titrePage);


        // mettre prix du produit
        String text_prixProduit = intent1.getStringExtra("prix_produit");
        // Afficher un seul valeur numerique
        if (text_prixProduit.startsWith("Prix = ")){
            text_prixProduit = text_prixProduit.substring(7);
        }
        tvPrixProduit.setText(text_prixProduit);


    }

}




