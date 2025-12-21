package com.example.tps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class show_sended_message extends AppCompatActivity {

    TextView messagesended;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_sended_message);
        messagesended = (TextView) findViewById(R.id.messagesended);

        Intent intent = getIntent();

        String message = intent.getStringExtra("MESSAGE");

        if(message.isEmpty()){
            messagesended.setText("saisie vide");
        }else{
            messagesended.setText(message);
        }
    }

    public void backtosend(View v){

        finish();

    }

}