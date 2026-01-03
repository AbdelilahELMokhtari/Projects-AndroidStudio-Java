package com.example.tps;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

public class tp6sql extends AppCompatActivity implements View.OnClickListener {
    DatabaseHelper myDb;
    EditText editId, editNom, editAge, editEcole;
    Button btnAdd, btnViewAll, btnUpdate, btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tp6sql);

        // Initialisation de la base de données
        // Initialisation de la base de données
        myDb = new DatabaseHelper(this);

        // Liaison avec le XML
        editId = findViewById(R.id.etId);
        editNom = findViewById(R.id.etNom);
        editAge = findViewById(R.id.etAge);
        editEcole = findViewById(R.id.etEcole);

        btnAdd = findViewById(R.id.btnAdd);
        btnViewAll = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        // Écouteurs de clics
        btnAdd.setOnClickListener(this);
        btnViewAll.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnAdd) {
            boolean isInserted = myDb.insertData(
                    editNom.getText().toString(),
                    editAge.getText().toString(),
                    editEcole.getText().toString()
            );
            if (isInserted) Toast.makeText(this, "Étudiant ajouté !", Toast.LENGTH_SHORT).show();
            else Toast.makeText(this, "Erreur d'ajout", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.btnView) {
            Cursor res = myDb.getAllData();
            if (res.getCount() == 0) {
                afficherMessage("Information", "La base est vide.");
                return;
            }
            StringBuilder buffer = new StringBuilder();
            while (res.moveToNext()) {
                buffer.append("ID: ").append(res.getString(0)).append("\n");
                buffer.append("Nom: ").append(res.getString(1)).append("\n");
                buffer.append("Age: ").append(res.getString(2)).append("\n");
                buffer.append("Ecole: ").append(res.getString(3)).append("\n\n");
            }
            afficherMessage("Liste des Étudiants", buffer.toString());

        } else if (id == R.id.btnUpdate) {
            boolean isUpdate = myDb.updateData(
                    editId.getText().toString(),
                    editNom.getText().toString(),
                    editAge.getText().toString(),
                    editEcole.getText().toString()
            );
            if (isUpdate) Toast.makeText(this, "Données modifiées", Toast.LENGTH_SHORT).show();
            else Toast.makeText(this, "Erreur (vérifiez l'ID)", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.btnDelete) {
            Integer deletedRows = myDb.deleteData(editId.getText().toString());
            if (deletedRows > 0) Toast.makeText(this, "Étudiant supprimé", Toast.LENGTH_SHORT).show();
            else Toast.makeText(this, "ID introuvable", Toast.LENGTH_SHORT).show();
        }
    }

    // Méthode pour afficher les résultats dans une boîte de dialogue
    public void afficherMessage(String titre, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(titre);
        builder.setMessage(message);
        builder.show();
    }
    // ===========================================================
    // CLASSE INTERNE POUR LA BASE DE DONNÉES (SQLITE)
    // ===========================================================
    public static class DatabaseHelper extends SQLiteOpenHelper {
        public static final String DATABASE_NAME = "Ecole.db";
        public static final String TABLE_NAME = "Etudiant";

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // Création de la table Etudiant avec les colonnes demandées
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT NOT NULL, age INTEGER NOT NULL, ecole TEXT NOT NULL)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        public boolean insertData(String nom, String age, String ecole) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("nom", nom);
            contentValues.put("age", age);
            contentValues.put("ecole", ecole);
            long result = db.insert(TABLE_NAME, null, contentValues);
            return result != -1;
        }

        public Cursor getAllData() {
            SQLiteDatabase db = this.getWritableDatabase();
            return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        }

        public boolean updateData(String id, String nom, String age, String ecole) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("nom", nom);
            contentValues.put("age", age);
            contentValues.put("ecole", ecole);
            int result = db.update(TABLE_NAME, contentValues, "id = ?", new String[]{id});
            return result > 0;
        }

        public Integer deleteData(String id) {
            SQLiteDatabase db = this.getWritableDatabase();
            return db.delete(TABLE_NAME, "id = ?", new String[]{id});
        }
    }
}