package com.example.tps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuRestaurant extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_restaurant);


    }

    public void clickedelement(View v){

        String elementClicked = getResources().getResourceEntryName(v.getId());

        if(elementClicked.equals("margarita")){
            Toast.makeText(this, "Prix : 25DH", Toast.LENGTH_SHORT).show();
        } else if (elementClicked.equals("catania")) {
            Toast.makeText(this, "Prix : 45DH", Toast.LENGTH_SHORT).show();

        }else if (elementClicked.equals("legumes")) {
            Toast.makeText(this, "Prix : 30DH", Toast.LENGTH_SHORT).show();

        }else if (elementClicked.equals("tropicale")) {
            Toast.makeText(this, "Prix : 43DH", Toast.LENGTH_SHORT).show();

        } else if (elementClicked.equals("btnabout")) {
            Toast.makeText(this,"Hello , I am ABDELILAH EL MOKHTARI ,From IGOV",Toast.LENGTH_SHORT).show();
        }else if (elementClicked.equals("btnexit")){
            finish();
        }
        else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

        }

    }


}