package com.example.tps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Exercice_Calculatrice1 extends AppCompatActivity {

    Button n1,n2,n3,n4,n5,n6,n7,n8,n9,nequal,nplus,nsur,nmoin,nmulti;
    String tempn = "";
    TextView rsdesplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercice_calculatrice);

        rsdesplay = (TextView) findViewById(R.id.rsdesplay);
    }

    public void clcikbtn(View v){

        //String btClicked = getResources().getResourceEntryName(v.getId());
        //Toast.makeText(this, btClicked, Toast.LENGTH_SHORT).show();
        if (v.getId() == R.id.n1) {
            tempn = tempn + "1";
            rsdesplay.setText(tempn);
        }else if(v.getId() == R.id.n2){
            tempn = tempn + "2";
            rsdesplay.setText(tempn);
        }else if(v.getId() == R.id.n3){
            tempn = tempn + "3";
            rsdesplay.setText(tempn);
        }else if(v.getId() == R.id.n4){
            tempn = tempn + "4";
            rsdesplay.setText(tempn);
        }else if(v.getId() == R.id.n5){
            tempn = tempn + "5";
            rsdesplay.setText(tempn);
        }else if(v.getId() == R.id.n6){
            tempn = tempn + "6";
            rsdesplay.setText(tempn);
        }else if(v.getId() == R.id.n7){
            tempn = tempn + "7";
            rsdesplay.setText(tempn);
        }else if(v.getId() == R.id.n8){
            tempn = tempn + "8";
            rsdesplay.setText(tempn);
        }else if(v.getId() == R.id.n9){
            tempn = tempn + "9";
            rsdesplay.setText(tempn);
        }else if(v.getId() == R.id.nplus){
            tempn = tempn + " + ";
            rsdesplay.setText(tempn);
        }else if(v.getId() == R.id.nmoin){
            tempn = tempn + " - ";
            rsdesplay.setText(tempn);
        }else if(v.getId() == R.id.nsur){
            tempn = tempn + " / ";
            rsdesplay.setText(tempn);
        }else if(v.getId() == R.id.nmulti){
            tempn = tempn + " * ";
            rsdesplay.setText(tempn);
        }else if(v.getId() == R.id.nc){
            tempn = "";
            rsdesplay.setText(tempn);
        }else if(v.getId() == R.id.npoint){
            tempn = tempn + ".";
            rsdesplay.setText(tempn);
        }else{
            calculateResult();
        }



    }
    private void calculateResult() {
        try {
            double result = evaluateExpression(tempn);
            tempn = String.valueOf(result);
            rsdesplay.setText(tempn);
        } catch (Exception e) {
            rsdesplay.setText("Error");
            tempn = "";
        }
    }

    // Simple parser and evaluator
    private double evaluateExpression(String expr) throws Exception {
        List<Double> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        String temp = "";
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c >= '0' && c <= '9' || c == '.') {
                temp += c;
            } else {
                numbers.add(Double.parseDouble(temp));
                temp = "";
                operators.add(c);
            }
        }
        if (!temp.isEmpty()) numbers.add(Double.parseDouble(temp));

        // First handle * and /
        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);
            if (op == '*' || op == '/') {
                double a = numbers.get(i);
                double b = numbers.get(i + 1);
                double res = (op == '*') ? a * b : a / b;
                numbers.set(i, res);
                numbers.remove(i + 1);
                operators.remove(i);
                i--; // step back to check the new operator at this index
            }
        }

        // Then handle + and -
        double result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);
            double b = numbers.get(i + 1);
            if (op == '+') result += b;
            else if (op == '-') result -= b;
        }

        return result;
    }

}