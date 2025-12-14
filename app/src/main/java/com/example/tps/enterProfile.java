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

public class enterProfile extends AppCompatActivity {

    ActivityResultLauncher<Intent> userinfos;
    TextView userresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_enter_profile);
        userresult = (TextView) findViewById(R.id.userinfos);
        userinfos = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result ->{

                    if(result.getResultCode() == RESULT_OK && result.getData() != null){

                        Intent data = result.getData();
                        String name = data.getStringExtra("EXTRA_NAME");
                        String age = data.getStringExtra("EXTRA_AGE");

                        userresult.setText("Name: "+name+" ,Age: "+age);
                    }else{
                        userresult.setText("User Have a error");
                    }

                }
        );

    }

    public void enterprofile(View v){

        Intent intent = new Intent(this, ProfileActivity.class);

        userinfos.launch(intent);

    }
}