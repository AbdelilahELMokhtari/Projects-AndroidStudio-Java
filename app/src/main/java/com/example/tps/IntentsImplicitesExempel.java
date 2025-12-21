package com.example.tps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntentsImplicitesExempel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intents_implicites_exempel);

    }

    public void btnclicked(View v ){

        String btnclicked = getResources().getResourceEntryName(v.getId());

        /*if(btnclicked.equals("btnsms")){
            Toast.makeText(this, "SMS", Toast.LENGTH_SHORT).show();
        } else if (btnclicked.equals("btnappel")) {
            Toast.makeText(this, "APPEL", Toast.LENGTH_SHORT).show();

        }else if (btnclicked.equals("btnweb")) {
            Toast.makeText(this, "WEB", Toast.LENGTH_SHORT).show();

        }*/
        Intent intent ;
        if(btnclicked.equals("btnsms")){
            intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:"));
            startActivity(intent);
        } else if (btnclicked.equals("btnappel")) {
            intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);

        }else if (btnclicked.equals("btnweb")) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://google.com "));

            startActivity(intent);

        }
    }
}