package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
    Button plus;
    Button multiply;
    Button divide;
    Button equals;
    Button minus;
    Button clear;
    Button next;

    Spinner spin;

    String act;
    String[] mas = new String[0];
    ArrayAdapter<String> adap;
    boolean fnum;
    int ident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        plus = findViewById(R.id.plus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        equals = findViewById(R.id.equals);
        minus = findViewById(R.id.minus);
        clear = findViewById(R.id.clear);
        next = findViewById(R.id.nextpage);

        spin = findViewById(R.id.spin);

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
        plus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equals.setOnClickListener(this);
        minus.setOnClickListener(this);
        clear.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

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
                if(!fnum && FirstNumber.getText()==""){
                    fnum=!fnum;
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
            case R.id.plus:
            case R.id.minus:
            case R.id.multiply:
            case R.id.divide:
                Button button1 = (Button) view;
                ident = view.getId();
                switch (ident) {
                    case R.id.plus:
                        Symbol.setText("+");
                        break;
                    case R.id.minus:
                        Symbol.setText("-");
                        break;
                    case R.id.multiply:
                        Symbol.setText("*");
                        break;
                    case R.id.divide:
                        Symbol.setText("/");
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
                float num1 = Float.valueOf(FirstNumber.getText().toString());
                float num2 = Float.valueOf(SecondNumber.getText().toString());
                float res;
                equal.setText("=");
                switch (ident) {
                    case R.id.plus:
                        res = num1 + num2;
                        result.setText(String.valueOf(res));
                        break;
                    case R.id.minus:
                        res = num1 - num2;
                        result.setText(String.valueOf(res));
                        break;
                    case R.id.multiply:
                        res = num1 * num2;
                        result.setText(String.valueOf(res));
                        break;
                    case R.id.divide:
                        res = num1 / num2;
                        result.setText(String.valueOf(res));
                        break;
                }
                fnum = !fnum;
                mas = Arrays.copyOf(mas,mas.length +1);
                String temp;
                for (int i = mas.length - 1; i>=1; i--)
                {
                    temp = mas[i - 1];
                    mas[i - 1] = mas[i];
                    mas[i] = temp;
                }
                mas[0] = String.valueOf(result.getText());
                adap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,mas);
                spin.setAdapter(adap);
                break;
            case R.id.clear:
                FirstNumber.setText("");
                SecondNumber.setText("");
                result.setText("");
                equal.setText("");
                Symbol.setText("");
                break;
            case R.id.nextpage:
                Intent intent = new Intent(this,MainActivity2.class);
                startActivity(intent);
                break;
        }
    }
}