package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txtQN;
    private TextView txtQA;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private TextView txtAlert;
    Random random = new Random();
    private int a;
    private int b;
    int[] answers = new int[4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtQN = findViewById(R.id.txtQN);
        txtQA = findViewById(R.id.txtQA);
        txtAlert = findViewById(R.id.txtAlert);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);


        Intent intent = getIntent();
        String operator = intent.getStringExtra("operator");

        Question(operator);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(btn1.getText().toString()) == knowOperator(operator)){
                    txtAlert.setText("Correct");
                    Question(operator);
                }else{
                    txtAlert.setText("Wrong");
                    Question(operator);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(btn2.getText().toString()) == knowOperator(operator)){
                    txtAlert.setText("Correct");
                    Question(operator);
                }else{

                    txtAlert.setText("Wrong");
                    Question(operator);
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(btn3.getText().toString()) == knowOperator(operator)){
                    txtAlert.setText("Correct");
                    Question(operator);
                }else{

                    txtAlert.setText("Wrong");
                    Question(operator);
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(btn4.getText().toString()) == knowOperator(operator)){
                    txtAlert.setText("Correct");
                    Question(operator);
                }else{

                    txtAlert.setText("Wrong");
                    Question(operator);
                }
            }
        });

    }

    private int knowOperator(String operator) {
        if(operator.equals("+")){
            return a+b;
        } else if (operator.equals("-")) {
            return a-b;
        } else if (operator.equals("*")) {
            return a*b;
        } else if (operator.equals("/")) {
            return a/b;
        }
        return 0;
    }

    private void shuffleArray() {
        for (int i = 0; i < answers.length; i++) {
            int randomIndex = (int) (Math.random() * answers.length);
            int temp = answers[i];
            answers[i] = answers[randomIndex];
            answers[randomIndex] = temp;
        }
        btn1.setText(String.valueOf(answers[0]));
        btn2.setText(String.valueOf(answers[1]));
        btn3.setText(String.valueOf(answers[2]));
        btn4.setText(String.valueOf(answers[3]));

    }

    private void Question(String operator) {

        if ("+".equals(operator)) {
            a = random.nextInt(10);
            b = random.nextInt(10);
            txtQA.setText(a+"+"+b);

            for (int i = 0; i < 3; i++) {
                answers[i] = random.nextInt(10);
            }
            answers[3] = a+b;
            shuffleArray();

        } else if ("-".equals(operator)) {
            a = random.nextInt(10);
            b = random.nextInt(10);
            txtQA.setText(a+"-"+b);

            for (int i = 0; i < 3; i++) {
                answers[i] = random.nextInt(15);
            }
            answers[3] = a-b;
            shuffleArray();

        } else if ("*".equals(operator)) {
            a = random.nextInt(10);
            b = random.nextInt(10);
            txtQA.setText(a+"*"+b);

            for (int i = 0; i < 3; i++) {
                answers[i] = random.nextInt(20);
            }
            answers[3] = a*b;
            shuffleArray();

        } else if ("/".equals(operator)) {
            a = random.nextInt(10);
            b = random.nextInt(10);
            txtQA.setText(a+"/"+b);

            for (int i = 0; i < 3; i++) {
                answers[i] = random.nextInt(11);
            }
            answers[3] = a/b;
            shuffleArray();

        } else {
            return;
        }

    }
}