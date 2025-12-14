package com.example.tps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DecisionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_decision);

    }

    public void sendyes(View v){
        sendDecision(true);
    }
    public void sendno(View v){
        sendDecision(false);
    }
    public void sendDecision(boolean yesorno){

        Intent intent =new Intent();

        intent.putExtra("EXTRA_DECISION",yesorno);

        setResult(RESULT_OK,intent);

        finish();
    }
}