package com.example.tps;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuRestaurant_sandwichs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_restaurant_sandwichs);
    }
    public void clickedelement(View v){
        String elementClicked = getResources().getResourceEntryName(v.getId());

        if (elementClicked.equals("btnabout")) {
            Toast.makeText(this,"Hello , I am ABDELILAH EL MOKHTARI ,From IGOV",Toast.LENGTH_SHORT).show();
        }else {
            finish();
        }


    }
}