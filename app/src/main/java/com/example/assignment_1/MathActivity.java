package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MathActivity extends AppCompatActivity {

    private TextView txtKidsMath;
    private ImageView addition;
    private ImageView subtraction;
    private ImageView multiplication;
    private ImageView division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        txtKidsMath = findViewById(R.id.txtKidsMath);
        addition = findViewById(R.id.addition);
        subtraction = findViewById(R.id.subtraction);
        multiplication = findViewById(R.id.multiplication);
        division = findViewById(R.id.division);

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent symbol = new Intent(MathActivity.this, MainActivity.class);
                symbol.putExtra("operator","+");
                startActivity(symbol);
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent symbol = new Intent(MathActivity.this, MainActivity.class);
                symbol.putExtra("operator","-");
                startActivity(symbol);
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent symbol = new Intent(MathActivity.this, MainActivity.class);
                symbol.putExtra("operator","*");
                startActivity(symbol);
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent symbol = new Intent(MathActivity.this, MainActivity.class);
                symbol.putExtra("operator","/");
                startActivity(symbol);
            }
        });
    }
}