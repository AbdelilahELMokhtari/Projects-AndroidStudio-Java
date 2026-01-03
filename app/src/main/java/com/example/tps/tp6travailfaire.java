package com.example.tps;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.util.ArrayList;

public class tp6travailfaire extends AppCompatActivity {
    ListView lvFiles;
    TextView tvPath;
    File currentDir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tp6travailfaire);

        lvFiles = findViewById(R.id.lvFiles);
        tvPath = findViewById(R.id.tvPath);
        currentDir = Environment.getExternalStorageDirectory();

        remplirListe();
        // Correction du onBackPressed déprécié
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (!currentDir.equals(Environment.getExternalStorageDirectory())) {
                    currentDir = currentDir.getParentFile();
                    remplirListe();
                } else {
                    finish();
                }
            }
        });
    }
    private void remplirListe() {
        tvPath.setText(currentDir.getAbsolutePath());
        File[] files = currentDir.listFiles();
        ArrayList<File> list = new ArrayList<>();
        if (files != null) {
            for (File f : files) list.add(f);
        }

        // Adaptateur personnalisé pour gérer les couleurs
        ArrayAdapter<File> adapter = new ArrayAdapter<File>(this, android.R.layout.simple_list_item_1, list) {

            @Override
            public View getView(int position, View convertView,  ViewGroup parent) {
                TextView tv = (TextView) super.getView(position, convertView, parent);
                File file = getItem(position);

                if (file != null) {
                    tv.setText(file.getName());
                    // COULEURS : Rose pour dossier, Noir pour fichier
                    if (file.isDirectory()) tv.setTextColor(Color.MAGENTA);
                    else tv.setTextColor(Color.BLACK);
                }
                return tv;
            }
        };
        lvFiles.setAdapter(adapter);

        lvFiles.setOnItemClickListener((parent, view, position, id) -> {
            File clicked = list.get(position);
            if (clicked.isDirectory()) {
                currentDir = clicked;
                remplirListe();
            }
        });
    }
}