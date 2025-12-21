package com.example.tps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EchangeDataB extends AppCompatActivity {

    TextView editmessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_echange_data_b);
        editmessage = findViewById(R.id.editTextText);

        Intent intent = getIntent();
        String OldMessage = intent.getStringExtra("OLDTEXT");

        editmessage.setText(OldMessage);
    }

    public void sendeditedtext(View v){
        String message = editmessage.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("NEW_TEXT",message);
        setResult(RESULT_OK,intent);
        finish();

    }


}