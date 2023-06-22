package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView txtQ;
    Random random = new Random();
    private int a;
    private int b;

    int[] answers = new int[4];
    private SharedPreferences sharedPreferences;


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
        txtQ = findViewById(R.id.textView);


        Intent intent = getIntent();
        String operator = intent.getStringExtra("operation");

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Question(operator);


        final int[] countCorrectAns = {0};
        final int[] countAns = {0};
        txtQ.setText(String.valueOf(countCorrectAns[0]));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(btn1.getText().toString()) == knowOperator(operator)){
                    if (countAns[0] != 5) {
                        countCorrectAns[0]++;
                        countAns[0]++;
                        txtQ.setText(String.valueOf(countAns[0]));

                    }

                    editor.putInt("correctAnswers", countCorrectAns[0]);
                    editor.commit();

                    txtAlert.setText("Correct");
                    if(countAns[0] != 5) {
                        sound1.start();
                        Question(operator);
                    }else{


                        int correctAnswers = sharedPreferences.getInt("correctAnswers", 0);
                        if(correctAnswers>2) {

                            Toast.makeText(MainActivity.this, "Congratulation, You Win. Number of correct answer " + correctAnswers, Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this, "OPS!, You Lose. You got" + correctAnswers + " correct answers ", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }

                }else{

                    if(countAns[0] != 5) {
                        countAns[0]++;
                        txtQ.setText(String.valueOf(countAns[0]));
                        txtAlert.setText("Wrong");
                        Question(operator);
                        sound2.start();
                    }else{

                        int correctAnswers = sharedPreferences.getInt("correctAnswers", 0);
                        if(correctAnswers>2) {

                            Toast.makeText(MainActivity.this, "Congratulation, You Win. Number of correct answer " + correctAnswers, Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this, "OPS!, You Lose. You got" + correctAnswers + " correct answers ", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(btn2.getText().toString()) == knowOperator(operator)){
                    if (countAns[0] != 5) {
                        countCorrectAns[0]++;
                        countAns[0]++;
                        txtQ.setText(String.valueOf(countAns[0]));

                    }

                    editor.putInt("correctAnswers", countCorrectAns[0]);
                    editor.commit();

                    txtAlert.setText("Correct");
                    if(countAns[0] != 5) {
                        sound1.start();
                        Question(operator);
                    }else{

                        int correctAnswers = sharedPreferences.getInt("correctAnswers", 0);
                        if(correctAnswers>2) {

                            Toast.makeText(MainActivity.this, "Congratulation, You Win. Number of correct answer " + correctAnswers, Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this, "OPS!, You Lose. You got" + correctAnswers + " correct answers ", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }


                }else{

                    if(countAns[0] != 5) {
                        countAns[0]++;
                        txtAlert.setText("Wrong");
                        txtQ.setText(String.valueOf(countAns[0]));
                        Question(operator);
                        sound2.start();
                    }else{

                        int correctAnswers = sharedPreferences.getInt("correctAnswers", 0);
                        if(correctAnswers>2) {

                            Toast.makeText(MainActivity.this, "Congratulation, You Win. Number of correct answer " + correctAnswers, Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this, "OPS!, You Lose. You got" + correctAnswers + " correct answers ", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(btn3.getText().toString()) == knowOperator(operator)){
                    if (countAns[0] != 5) {
                        countCorrectAns[0]++;
                        countAns[0]++;
                        txtQ.setText(String.valueOf(countAns[0]));

                    }

                    editor.putInt("correctAnswers", countCorrectAns[0]);
                    editor.commit();

                    txtAlert.setText("Correct");
                    if(countAns[0] != 5) {
                        Question(operator);
                        sound1.start();
                    }else{

                        int correctAnswers = sharedPreferences.getInt("correctAnswers", 0);
                        if(correctAnswers>2) {

                            Toast.makeText(MainActivity.this, "Congratulation, You Win. Number of correct answer " + correctAnswers, Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this, "OPS!, You Lose. You got" + correctAnswers + " correct answers ", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                }else{

                    if(countAns[0] != 5) {
                        countAns[0]++;
                        txtAlert.setText("Wrong");
                        txtQ.setText(String.valueOf(countAns[0]));
                        Question(operator);
                        sound2.start();
                    }else{

                        int correctAnswers = sharedPreferences.getInt("correctAnswers", 0);
                        if(correctAnswers>2) {

                            Toast.makeText(MainActivity.this, "Congratulation, You Win. Number of correct answer " + correctAnswers, Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this, "OPS!, You Lose. You got" + correctAnswers + " correct answers ", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(btn4.getText().toString()) == knowOperator(operator)){
                    if (countAns[0] != 5) {
                        countCorrectAns[0]++;
                        countAns[0]++;
                        txtQ.setText(String.valueOf(countAns[0]));
                    }

                    editor.putInt("correctAnswers", countCorrectAns[0]);
                    editor.commit();

                    txtAlert.setText("Correct");
                    if(countAns[0] != 5) {
                        Question(operator);
                        sound1.start();
                    }else{
                        int correctAnswers = sharedPreferences.getInt("correctAnswers", 0);
                        if(correctAnswers>2) {

                            Toast.makeText(MainActivity.this, "Congratulation, You Win. Number of correct answer " + correctAnswers, Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this, "OPS!, You Lose. You got" + correctAnswers + " correct answers ", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                }else{

                    if(countAns[0] != 5) {
                        countAns[0]++;
                        txtAlert.setText("Wrong");
                        txtQ.setText(String.valueOf(countAns[0]));
                        Question(operator);
                        sound2.start();
                    }else{

                        int correctAnswers = sharedPreferences.getInt("correctAnswers", 0);
                        if(correctAnswers>2) {

                            Toast.makeText(MainActivity.this, "Congratulation, You Win. Number of correct answer " + correctAnswers, Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this, "OPS!, You Lose. You got" + correctAnswers + " correct answers ", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

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
        if(operator.equals("Plus")){
            return a+b;
        } else if (operator.equals("Minus")) {
            return a-b;
        } else if (operator.equals("Multiplication")) {
            return a*b;
        } else if (operator.equals("Division")) {
            return a/b;
        } else if (operator.equals("Factorial")) {
            return factorial(a);
        } else if (operator.equals("Square root")) {
            Math.sqrt(a);
        }
        return 0;
    }

    private int factorial(int a) {
        int b = 1;
        for(int i=1;i<=a;i++){

            b *= i;
        }
        return b;
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

        if ("Plus".equals(operator)) {
            a = random.nextInt(50);
            b = random.nextInt(50);
            txtQA.setText(a+"+"+b);

            for (int i = 0; i < 3; i++) {
                answers[i] = random.nextInt(100);
            }
            answers[3] = a+b;
            shuffleArray();

        }else if ("Minus".equals(operator)) {
            a = random.nextInt(50);
            b = random.nextInt(50);
            txtQA.setText(a+"-"+b);

            for (int i = 0; i < 3; i++) {
                answers[i] = random.nextInt(100);
            }
            answers[3] = a-b;
            shuffleArray();

        } else if ("Multiplication".equals(operator)) {
            a = random.nextInt(20);
            b = random.nextInt(10);
            txtQA.setText(a+"*"+b);

            for (int i = 0; i < 3; i++) {
                answers[i] = random.nextInt(200);
            }
            answers[3] = a*b;
            shuffleArray();

        } else if ("Division".equals(operator)) {
            a = random.nextInt(20);
            b = random.nextInt(10);
            txtQA.setText(a + "/" + b);

            for (int i = 0; i < 3; i++) {
                answers[i] = random.nextInt(15);
            }
            answers[3] = a / b;
            shuffleArray();

        }else if ("Square root".equals(operator)) {
            a = random.nextInt(20);
            txtQA.setText("√"+a);

            for (int i = 0; i < 3; i++) {
                answers[i] = random.nextInt(15);
            }
            answers[3] = (int) Math.sqrt(a);
            shuffleArray();

        } else if ("Factorial".equals(operator)) {
            a = random.nextInt(5);
            txtQA.setText(a+"!");

            for (int i = 0; i < 3; i++) {
                answers[i] = random.nextInt(200);
            }
            answers[3] = factorial(a);
            shuffleArray();
        }
    }
}