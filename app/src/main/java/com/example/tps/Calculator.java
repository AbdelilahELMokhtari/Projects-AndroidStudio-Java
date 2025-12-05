package com.example.tps;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculator extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);


    }


    RadioGroup grpOperator ;
    TextView v1,v2,rs;

    public void makeOperation(View v){

        String btClicked = getResources().getResourceEntryName(v.getId());
        v1 = (TextView) findViewById(R.id.v1);
        v2 = (TextView) findViewById(R.id.v2);
        rs = (TextView) findViewById(R.id.result);
        String valuev1 = v1.getText().toString();
        String valuev2 = v2.getText().toString();
        if(btClicked.equals("resetdata")){
            v1.setText("");
            v2.setText("");
            rs.setText("Result");

        }else if(btClicked.equals("equal")){
            if(valuev1.isEmpty() || valuev2.isEmpty()){
                Toast.makeText(this,"Please enter the two Value",Toast.LENGTH_SHORT).show();

            }else{

                grpOperator = findViewById(R.id.grpoperator);
                int selectedId = grpOperator.getCheckedRadioButtonId();

                String selectedValue = "";

                if(selectedId != -1){
                    selectedValue= getResources().getResourceEntryName(selectedId);
                }
                if (selectedValue.equals("")){
                    Toast.makeText(this,"please select your operator",Toast.LENGTH_SHORT).show();


                }else if(selectedValue.equals("add")){
                    int result = Integer.parseInt(valuev1) + Integer.parseInt(valuev2);
                    rs.setText(String.valueOf("Result : "+result));
                } else if (selectedValue.equals("moins")) {
                    int result = Integer.parseInt(valuev1) - Integer.parseInt(valuev2);
                    rs.setText(String.valueOf("Result : " + result));

                } else if (selectedValue.equals("fois")) {
                    int result = Integer.parseInt(valuev1) * Integer.parseInt(valuev2);
                    rs.setText(String.valueOf("Result : "+result));
                } else if (selectedValue.equals("sur")) {
                    if(valuev2.equals("0")){
                        Toast.makeText(this, "you can't division on 0 ", Toast.LENGTH_SHORT).show();

                    }else{
                        int result = Integer.parseInt(valuev1) / Integer.parseInt(valuev2);
                        rs.setText(String.valueOf("Result : "+result));
                    }

                }

            }
        }else{
            finish();
        }

    }
}