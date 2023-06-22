package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;

import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

public class MathActivity extends AppCompatActivity implements RecyclerInterface {

    private TextView txtKidsMath;
    private RecyclerView recycler;
    private Animation top,recyclerAnim;

    private ArrayList<Operation> operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        top = AnimationUtils.loadAnimation(this,R.anim.top_animation);

        txtKidsMath = findViewById(R.id.txtKidsMath);
        operations = new ArrayList<>();
        operations.add(new Operation("Plus", R.drawable.plus));
        operations.add(new Operation("Minus", R.drawable.minus));
        operations.add(new Operation("Division", R.drawable.division));
        operations.add(new Operation("Multiplication", R.drawable.multiplication));
        operations.add(new Operation("Factorial", R.drawable.factorial));
        operations.add(new Operation("Square root", R.drawable.square));


        OperationAdapter adapter = new OperationAdapter(operations, this);

        recycler = findViewById(R.id.recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        txtKidsMath.setAnimation(top);

    }

    @Override
    public void onItemClick(int position) {
        Operation operation = operations.get(position);
        Intent intent = new Intent(MathActivity.this, MainActivity.class);
        intent.putExtra("operation", operation.getOperation());
        startActivity(intent);
    }

}