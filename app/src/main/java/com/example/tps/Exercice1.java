package com.example.tps;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exercice1 extends AppCompatActivity {
    TextView t ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercice1);



    }

    public void displayMessage(View v){
        t = (TextView) findViewById(R.id.message);
        String message = t.getText().toString();
        if(message.isEmpty()){
            Toast.makeText(this, "Please enter your message", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Your message is : \n"+message, Toast.LENGTH_SHORT).show();
        }

    }
}