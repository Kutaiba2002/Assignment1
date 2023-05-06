package com.example.assignment_1;

import java.util.ArrayList;

public class DAOperation {

    ArrayList<Operation> arrayList1 = new ArrayList<>();
    ArrayList<Operation> arrayList2 = new ArrayList<>();
    ArrayList<Operation> arrayList3 = new ArrayList<>();
    ArrayList<Operation> arrayList4 = new ArrayList<>();

    public DAOperation() {
        arrayList1.add(new Operation(5,5,"+"));
        arrayList1.add(new Operation(8,5,"+"));
        arrayList1.add(new Operation(7,3,"+"));
        arrayList1.add(new Operation(2,5,"+"));


        arrayList2.add(new Operation(2,2,"*"));
        arrayList2.add(new Operation(5,2,"*"));
        arrayList2.add(new Operation(4,3,"*"));
        arrayList2.add(new Operation(3,3,"*"));


        arrayList3.add(new Operation(5,3,"-"));
        arrayList3.add(new Operation(7,2,"-"));
        arrayList3.add(new Operation(3,2,"-"));
        arrayList3.add(new Operation(8,4,"-"));


        arrayList4.add(new Operation(6,3,"/"));
        arrayList4.add(new Operation(4,2,"/"));
        arrayList4.add(new Operation(6,2,"/"));
        arrayList4.add(new Operation(4,4,"/"));

    }

    public ArrayList<Operation> getArrayList1() {
        return arrayList1;
    }

    public void setArrayList1(ArrayList<Operation> arrayList1) {
        this.arrayList1 = arrayList1;
    }

    public ArrayList<Operation> getArrayList2() {
        return arrayList2;
    }

    public void setArrayList2(ArrayList<Operation> arrayList2) {
        this.arrayList2 = arrayList2;
    }

    public ArrayList<Operation> getArrayList3() {
        return arrayList3;
    }

    public void setArrayList3(ArrayList<Operation> arrayList3) {
        this.arrayList3 = arrayList3;
    }

    public ArrayList<Operation> getArrayList4() {
        return arrayList4;
    }

    public void setArrayList4(ArrayList<Operation> arrayList4) {
        this.arrayList4 = arrayList4;
    }
}

