package com.example.assignment_1;

public class Operation {

    private int a;
    private int b;
    private String operation;

    public Operation(int a, int b, String operation) {
        this.a = a;
        this.b = b;
        this.operation = operation;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}

