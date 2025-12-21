package com.example.tps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Exercice_Calculatrice extends AppCompatActivity {

    Button n0,n1,n2,n3,n4,n5,n6,n7,n8,n9,nequal,nplus,nsur,nmoin,nmulti,nc,npoint;
    String tempn = "";
    TextView rsdesplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercice_calculatrice);

        rsdesplay = findViewById(R.id.rsdesplay);

        // Initialize buttons
        n0 = findViewById(R.id.n0);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);
        nplus = findViewById(R.id.nplus);
        nmoin = findViewById(R.id.nmoin);
        nmulti = findViewById(R.id.nmulti);
        nsur = findViewById(R.id.nsur);
        nc = findViewById(R.id.nc);
        npoint = findViewById(R.id.npoint);
        nequal = findViewById(R.id.nequal);

        View.OnClickListener listener = this::clcikbtn;
        n0.setOnClickListener(listener);
        n1.setOnClickListener(listener);
        n2.setOnClickListener(listener);
        n3.setOnClickListener(listener);
        n4.setOnClickListener(listener);
        n5.setOnClickListener(listener);
        n6.setOnClickListener(listener);
        n7.setOnClickListener(listener);
        n8.setOnClickListener(listener);
        n9.setOnClickListener(listener);
        nplus.setOnClickListener(listener);
        nmoin.setOnClickListener(listener);
        nmulti.setOnClickListener(listener);
        nsur.setOnClickListener(listener);
        nc.setOnClickListener(listener);
        npoint.setOnClickListener(listener);
        nequal.setOnClickListener(listener);
    }

    private void clcikbtn(View v){
        int id = v.getId();

        if (id == R.id.n0) {
            tempn += "0";
        } else if (id == R.id.n1) {
            tempn += "1";
        } else if (id == R.id.n2) {
            tempn += "2";
        } else if (id == R.id.n3) {
            tempn += "3";
        } else if (id == R.id.n4) {
            tempn += "4";
        } else if (id == R.id.n5) {
            tempn += "5";
        } else if (id == R.id.n6) {
            tempn += "6";
        } else if (id == R.id.n7) {
            tempn += "7";
        } else if (id == R.id.n8) {
            tempn += "8";
        } else if (id == R.id.n9) {
            tempn += "9";
        } else if (id == R.id.npoint) {
            // prevent multiple dots in a number
            if (!tempn.endsWith(".")) tempn += ".";
        } else if (id == R.id.nplus || id == R.id.nmoin || id == R.id.nmulti || id == R.id.nsur) {
            // prevent two consecutive operators
            if (!tempn.isEmpty() && !isOperator(tempn.charAt(tempn.length() - 1))) {
                if (id == R.id.nplus) tempn += "+";
                else if (id == R.id.nmoin) tempn += "-";
                else if (id == R.id.nmulti) tempn += "*";
                else if (id == R.id.nsur) tempn += "/";
            }
        } else if (id == R.id.nc) {
            tempn = "";
        } else if (id == R.id.nequal) {
            // prevent empty input or ending with operator
            if (!tempn.isEmpty() && !isOperator(tempn.charAt(tempn.length() - 1))) {
                calculateResult();
            }
            return;
        }

        rsdesplay.setText(tempn);
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
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
    private double evaluateExpression(String expr) throws Exception {
        List<Double> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        String temp = "";
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if ((c >= '0' && c <= '9') || c == '.') {
                temp += c;
            } else if (isOperator(c)) {
                if (temp.isEmpty()) {
                    // handle negative numbers at the start or after an operator
                    if (c == '-') {
                        temp += "-";
                        continue;
                    } else {
                        throw new Exception("Invalid Expression");
                    }
                }
                numbers.add(Double.parseDouble(temp));
                temp = "";
                operators.add(c);
            }
        }
        if (!temp.isEmpty()) numbers.add(Double.parseDouble(temp));

        if (numbers.size() == 0) throw new Exception("Empty Expression");

        // Handle * and /
        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);
            if (op == '*' || op == '/') {
                double a = numbers.get(i);
                double b = numbers.get(i + 1);
                double res = (op == '*') ? a * b : a / b;
                numbers.set(i, res);
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }
        }

        // Handle + and -
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