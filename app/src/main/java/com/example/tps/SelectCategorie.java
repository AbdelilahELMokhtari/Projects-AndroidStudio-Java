package com.example.tps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelectCategorie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_select_categorie);

    }

    public void selectCategorie(View v){
        Intent intent ;
        String selectedCategorie = getResources().getResourceEntryName(v.getId());

        if(selectedCategorie.equals("sandwichs")){
            intent = new Intent(this, MenuRestaurant_sandwichs.class);
            startActivity(intent);
        } else if (selectedCategorie.equals("pizzas")) {
            intent = new Intent(this, MenuRestaurant.class);
            startActivity(intent);
        }else if (selectedCategorie.equals("salades")) {
            intent = new Intent(this, MenuRestaurant_salades.class);
            startActivity(intent);
        }else if (selectedCategorie.equals("desserts")) {
            intent = new Intent(this, MenuRestaurant_desserts.class);
            startActivity(intent);
        }else if (selectedCategorie.equals("boissons")) {
            intent = new Intent(this, MenuRestaurant_boissons.class);
            startActivity(intent);
        }
    }
}