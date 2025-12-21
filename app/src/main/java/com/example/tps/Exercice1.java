package com.example.tps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exercice1 extends AppCompatActivity {
    TextView t ;

    //ActivityResultLauncher<Intent> sendmessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercice1);

        /*sendmessage = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result ->{

                }
        );*/


    }

    public void sendmessage(View v){
        t = (TextView) findViewById(R.id.message);
        String message = t.getText().toString();
        Intent intent = new Intent(this, show_sended_message.class);
        intent.putExtra("MESSAGE",message);
        startActivity(intent);
    }


    /*public void displayMessage(View v){
        t = (TextView) findViewById(R.id.message);
        String message = t.getText().toString();
        if(message.isEmpty()){
            Toast.makeText(this, "Please enter your message", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Your message is : \n"+message, Toast.LENGTH_SHORT).show();
        }

    }*/


}