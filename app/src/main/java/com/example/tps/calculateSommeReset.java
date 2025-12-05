package com.example.tps;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class calculateSommeReset extends AppCompatActivity {
    TextView n1 ,n2,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculatesommereset);



        /*b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1,number2;

                number1 = Integer.parseInt(n1.getText().toString());
                number2 = Integer.parseInt(n2.getText().toString());
                int rs = number1 + number2 ;

                String rst = String.valueOf(rs);

                result.setText(rst);

            }
        });*/


    }
    public void bAction(View v){
        n1 = (TextView) findViewById(R.id.n1);
        n2 = (TextView) findViewById(R.id.n2);
        result = (TextView) findViewById(R.id.n3) ;
        int nId =v.getId();
        String nameId = getResources().getResourceEntryName(nId);

        if((n1.getText().toString().equals("")) || (n2.getText().toString().equals(""))){
            result.setText("Please enter n1 and n2");
        }
        else if(nameId.equals("somme")){
            int rst = Integer.parseInt(n1.getText().toString()) + Integer.parseInt(n2.getText().toString());

            result.setText(String.valueOf(rst));
        }else if(nameId.equals("reset")){
            n1.setText("");
            n2.setText("");
            result.setText("");
        }


    }

}