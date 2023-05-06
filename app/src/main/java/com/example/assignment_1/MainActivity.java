package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
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

    DAOperation d = new DAOperation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showAlert();

        final MediaPlayer sound1 =MediaPlayer.create(this,R.raw.yeah);
        final MediaPlayer sound2 = MediaPlayer.create(this,R.raw.no);
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
                    sound1.start();
                }else{
                    txtAlert.setText("Wrong");
                    Question(operator);
                    sound2.start();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(btn2.getText().toString()) == knowOperator(operator)){
                    txtAlert.setText("Correct");
                    Question(operator);
                    sound1.start();
                }else{

                    txtAlert.setText("Wrong");
                    Question(operator);
                    sound2.start();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(btn3.getText().toString()) == knowOperator(operator)){
                    txtAlert.setText("Correct");
                    Question(operator);
                    sound1.start();
                }else{

                    txtAlert.setText("Wrong");
                    Question(operator);
                    sound2.start();
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(btn4.getText().toString()) == knowOperator(operator)){
                    txtAlert.setText("Correct");
                    Question(operator);
                    sound1.start();
                }else{

                    txtAlert.setText("Wrong");
                    Question(operator);
                    sound2.start();
                }
            }
        });

    }

    private void showAlert() {
        new AlertDialog.Builder(MainActivity.this)
        .setTitle("Explain")
        .setMessage("Think about question that the first number is apple and the second number is banana")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                })
                .create().show();
    }

    //helo broo
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

        for(int i=0;i<answers.length;i++){
            for(int j=i+1;j<answers.length;j++){
                if(answers[i] == answers[j]){
                    answers[i] = answers[i]+1;
                }
            }
        }
        btn1.setText(String.valueOf(answers[0]));
        btn2.setText(String.valueOf(answers[1]));
        btn3.setText(String.valueOf(answers[2]));
        btn4.setText(String.valueOf(answers[3]));

    }

    private void Question(String operator) {

        if ("+".equals(operator)) {
            a = d.getArrayList1().get(0).getA();
            b = d.getArrayList1().get(0).getB();
            txtQA.setText(a+"+"+b);

            for (int i = 0; i < 3; i++) {
                answers[i] = random.nextInt(15);
            }
            answers[3] = a+b;
            shuffleArray();
            d.getArrayList1().remove(0);

        } else if ("-".equals(operator)) {
            a = d.getArrayList3().get(0).getA();
            b = d.getArrayList3().get(0).getB();
            txtQA.setText(a+"-"+b);

            for (int i = 0; i < 3; i++) {
                answers[i] = random.nextInt(15);
            }
            answers[3] = a-b;
            shuffleArray();
            d.getArrayList3().remove(0);

        } else if ("*".equals(operator)) {
            a = d.getArrayList2().get(0).getA();
            b = d.getArrayList2().get(0).getB();
            txtQA.setText(a+"*"+b);

            for (int i = 0; i < 3; i++) {
                answers[i] = random.nextInt(20);
            }
            answers[3] = a*b;
            shuffleArray();
            d.getArrayList2().remove(0);

        } else if ("/".equals(operator)) {
            a = d.getArrayList4().get(0).getA();
            b = d.getArrayList4().get(0).getB();
            txtQA.setText(a+"/"+b);

            for (int i = 0; i < 3; i++) {
                answers[i] = random.nextInt(15);
            }
            answers[3] = a/b;
            shuffleArray();
            d.getArrayList2().remove(0);

        } else {
            return;
        }

    }
}