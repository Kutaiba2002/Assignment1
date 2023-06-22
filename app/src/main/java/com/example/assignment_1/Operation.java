package com.example.assignment_1;

public class Operation {

    private int a;
    private int b;
    private String operation;

    private int imageId;

    public Operation(String operation, int imageId) {
        this.operation = operation;
        this.imageId = imageId;
    }

    public Operation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getImageId() {
        return imageId;
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

    @Override
    public String toString() {
        return operation;
    }
}

