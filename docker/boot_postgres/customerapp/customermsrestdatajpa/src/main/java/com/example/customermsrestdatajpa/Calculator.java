package com.example.customermsrestdatajpa;

public class Calculator {

    private Adder adder;

    public void setAdder(Adder adder){
        this.adder=adder;
    }

    public int add(int a, int b){
        System.out.println("inside calculator add");
        int result=adder.add(a,b);
        System.out.println(adder+"result="+result);
       return result;
    }

    public int addBy10(int num){
        System.out.println("inside add by 10");
       int result= add(num,10);
       return result;
    }


}
