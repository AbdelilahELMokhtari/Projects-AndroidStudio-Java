package com.example.tps;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tp6Preferencespartagees extends AppCompatActivity {

    TextView etEmail,etNom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tp6_preferencespartagees);

        etEmail = (TextView) findViewById(R.id.etEmail);
        etNom = (TextView) findViewById(R.id.etNom);




    }

    public void btnpref(View v){

        String elementClicked = getResources().getResourceEntryName(v.getId());
        if(elementClicked.equals("btnEnregistrer")){
            String name = etNom.getText().toString();
            String email = etEmail.getText().toString();
            SharedPreferences sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();

            editor.putString("nom",name);
            editor.putString("email",email);

            editor.apply();
            etNom.setText("");
            etEmail.setText("");
        }else if(elementClicked.equals("btnCharger")){
            SharedPreferences sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            String nom = sharedPref.getString("nom","vide");
            String email = sharedPref.getString("email","vide");

            etNom.setText(nom);
            etEmail.setText(email);

        }else{
            SharedPreferences sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("nom","");
            editor.putString("email","");
            editor.apply();
            etNom.setText("");
            etEmail.setText("");
        }


        Toast.makeText(this, elementClicked, Toast.LENGTH_SHORT).show();

    }
}