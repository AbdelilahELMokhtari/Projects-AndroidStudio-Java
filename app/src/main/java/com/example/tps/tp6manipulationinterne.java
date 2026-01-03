package com.example.tps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class tp6manipulationinterne extends AppCompatActivity {
    private EditText etSaisie;
    private Button btnEcrire, btnLire;
    private final String FILENAME = "saisie.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tp6manipulationinterne);


        // Initialisation
        etSaisie = findViewById(R.id.etSaisie);
        btnEcrire = findViewById(R.id.btnEcrire);
        btnLire = findViewById(R.id.btnLire);


    }



    // Méthode pour l'écriture
    private void ecrireFichier(View v) {
        String texte = etSaisie.getText().toString();
        try (FileOutputStream fos = openFileOutput(FILENAME, MODE_PRIVATE)) {
            fos.write(texte.getBytes());
            Toast.makeText(this, "Texte sauvegardé !", Toast.LENGTH_SHORT).show();
            etSaisie.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Méthode pour la lecture
    private void lireFichier(View v) {
        try (FileInputStream fis = openFileInput(FILENAME)) {
            StringBuilder contenu = new StringBuilder();
            int n;
            while ((n = fis.read()) != -1) {
                contenu.append((char) n);
            }
            Toast.makeText(this, contenu.toString(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Erreur : fichier introuvable", Toast.LENGTH_SHORT).show();
        }
    }
}