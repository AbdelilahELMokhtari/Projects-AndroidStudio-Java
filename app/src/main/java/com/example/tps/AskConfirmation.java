package com.example.tps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AskConfirmation extends AppCompatActivity {

    //Create a Launcher

    ActivityResultLauncher<Intent> takeDecision;
    TextView resuldecision ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ask_confirmation);

        resuldecision = (TextView) findViewById(R.id.resuldecision);
        takeDecision = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                   if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                        Intent data = result.getData();
                        boolean yesorno = data.getBooleanExtra("EXTRA_DECISION", false);

                        if (yesorno) {
                            resuldecision.setText("Accepted");
                        } else {
                            resuldecision.setText("Rejected");
                        }

                    } else {
                        // Optional: handle cancel case
                        resuldecision.setText("No decision");
                    }

                }
        );


    }

    public void yesorno(View v){

        Intent intent = new Intent(this, DecisionActivity.class);

        takeDecision.launch(intent);

    }



}