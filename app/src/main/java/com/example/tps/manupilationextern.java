package com.example.tps;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class manupilationextern extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manupilationextern);

    }

    public void lireExterne(View v) {
        // Accéder à la racine de la carte SD
        File sdCard = Environment.getExternalStorageDirectory();
        File fichier = new File(sdCard, "chaine.txt");

        if (fichier.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(fichier));
                String ligne = br.readLine(); // Lit la première ligne
                br.close();
                Toast.makeText(this, "SD Card: " + ligne, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(this, "Hello IGOV", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Fichier chaine.txt introuvable sur la SD", Toast.LENGTH_LONG).show();
        }
    }
}