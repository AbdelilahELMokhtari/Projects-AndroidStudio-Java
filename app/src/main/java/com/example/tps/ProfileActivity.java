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

public class ProfileActivity extends AppCompatActivity {
    TextView name ,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        name = (TextView) findViewById(R.id.nameinfo);
        age = (TextView) findViewById(R.id.ageinfo);


    }

    public void senduserinfos(View v){
        Intent intent = new Intent();
        String username = name.getText().toString();
        String userage = age.getText().toString();
        intent.putExtra("EXTRA_NAME",username);
        intent.putExtra("EXTRA_AGE",userage);

        setResult(RESULT_OK,intent);
        finish();
    }


}