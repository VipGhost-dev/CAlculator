package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

        TextView FirstNumber;
        TextView SecondNumber;
        TextView result;
        TextView Symbol;
        TextView equal;

        Button zero;
        Button one;
        Button two;
        Button three;
        Button four;
        Button five;
        Button six;
        Button seven;
        Button eight;
        Button nine;
        Button sinus;
        Button degree;
        Button root;
        Button equals;
        Button cosinus;
        Button clear;
        Button back;

        String act;
        boolean fnum;
        int ident;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            act = "";
            fnum = true;

            FirstNumber = findViewById(R.id.FirstNumber);
            SecondNumber = findViewById(R.id.SecondNumber);
            result = findViewById(R.id.result);
            Symbol = findViewById(R.id.Symbol);
            equal = findViewById(R.id.equal);

            zero = findViewById(R.id.zero);
            one = findViewById(R.id.one);
            two = findViewById(R.id.two);
            three = findViewById(R.id.three);
            four = findViewById(R.id.four);
            five = findViewById(R.id.five);
            six = findViewById(R.id.six);
            seven = findViewById(R.id.seven);
            eight = findViewById(R.id.eight);
            nine = findViewById(R.id.nine);
            sinus = findViewById(R.id.sinus);
            degree = findViewById(R.id.degree);
            root = findViewById(R.id.root);
            equals = findViewById(R.id.equals);
            cosinus = findViewById(R.id.cosinus);
            clear = findViewById(R.id.clear);
            back = findViewById(R.id.backpage);

            zero.setOnClickListener(this);
            one.setOnClickListener(this);
            two.setOnClickListener(this);
            three.setOnClickListener(this);
            four.setOnClickListener(this);
            five.setOnClickListener(this);
            six.setOnClickListener(this);
            seven.setOnClickListener(this);
            eight.setOnClickListener(this);
            nine.setOnClickListener(this);
            sinus.setOnClickListener(this);
            degree.setOnClickListener(this);
            root.setOnClickListener(this);
            equals.setOnClickListener(this);
            cosinus.setOnClickListener(this);
            clear.setOnClickListener(this);
            back.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){

            switch (view.getId()) {
                case R.id.zero:
                case R.id.one:
                case R.id.two:
                case R.id.three:
                case R.id.four:
                case R.id.five:
                case R.id.six:
                case R.id.seven:
                case R.id.eight:
                case R.id.nine:
                    if (!fnum && FirstNumber.getText() == "") {
                        fnum = !fnum;
                    }
                    Button button = (Button) view;
                    String numText;
                    if (fnum) {
                        numText = FirstNumber.getText().toString();
                        numText += button.getText().toString();
                        FirstNumber.setText(numText);
                    } else {
                        numText = SecondNumber.getText().toString();
                        numText += button.getText().toString();
                        SecondNumber.setText(numText);
                    }
                    break;
                case R.id.sinus:
                case R.id.cosinus:
                case R.id.degree:
                case R.id.root:
                    Button button1 = (Button) view;
                    ident = view.getId();
                    switch (ident) {
                        case R.id.sinus:
                            Symbol.setText("sin");
                            break;
                        case R.id.cosinus:
                            Symbol.setText("cos");
                            break;
                        case R.id.degree:
                            Symbol.setText("^");
                            break;
                        case R.id.root:
                            Symbol.setText("√");
                            break;
                    }
                    if (act == button1.getText().toString()) {
                        act = button1.getText().toString();
                        if (!fnum) {
                            fnum = !fnum;
                        }
                    } else {
                        fnum = !fnum;
                    }
                    break;
                case R.id.equals:
                    double res;
                    equal.setText("=");
                    switch (ident) {
                        case R.id.sinus:
                            float num1 = Float.valueOf(FirstNumber.getText().toString());
                            res = Math.sin(Math.toRadians(num1));
                            result.setText(String.valueOf(res));
                            break;
                        case R.id.cosinus:
                            float num2 = Float.valueOf(FirstNumber.getText().toString());
                            res = Math.cos(Math.toRadians(num2));
                            result.setText(String.valueOf(res));
                            break;
                        case R.id.degree:
                            float num3 = Float.valueOf(FirstNumber.getText().toString());
                            float num4 = Float.valueOf(SecondNumber.getText().toString());
                            res = Math.pow(num3,num4);
                            result.setText(String.valueOf(res));
                            break;
                        case R.id.root:
                            float num6 = Float.valueOf(FirstNumber.getText().toString());
                            float num5 = Float.valueOf(SecondNumber.getText().toString());
                            res = Math.pow(num5,1/num6);
                            result.setText(String.valueOf(res));
                            break;
                    }
                    fnum = !fnum;
                    break;
                case R.id.clear:
                    FirstNumber.setText("");
                    SecondNumber.setText("");
                    result.setText("");
                    equal.setText("");
                    Symbol.setText("");
                    break;
                case R.id.backpage:
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }