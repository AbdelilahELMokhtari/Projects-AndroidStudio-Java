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

public class EchangeDataA extends AppCompatActivity {


    TextView message ;
    ActivityResultLauncher<Intent> editmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_echange_dataa);
        message = findViewById(R.id.showedtext);
        editmessage = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result ->{
                    if(result.getResultCode() == RESULT_OK && result.getData() != null){
                        Intent data = result.getData();

                        String msg = data.getStringExtra("NEW_TEXT");
                        message.setText(msg);
                    }else{
                        message.setText("NO TEXT");
                    }

                }
                );
    }

    public void editmessage(View v){

        String oldtext = message.getText().toString();
        Intent intent =new Intent(this,EchangeDataB.class);
        intent.putExtra("OLDTEXT",oldtext);

        editmessage.launch(intent);

    }



}