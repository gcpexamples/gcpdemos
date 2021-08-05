package com.example.customermsrestdatajpa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorIntegerationTest {

    Calculator calcy;

    @BeforeEach
    public void setup(){
        System.out.println("inside setup");
        calcy = new Calculator();
        calcy.setAdder(new Adder());
    }

    @AfterEach
    public  void clear(){
        System.out.println("inside clean");
    }
    /**
     *  scenaio when both numbers are positive
     *  inputs: ip1 : 5 , ip2:7
     *  expectation: 12
     */
    @Test
    public void testAdd_1(){
        System.out.println("isnide testAdd1");
        int result=calcy.add(5,7);
        assertEquals(12,result);
    }

    /**
     *  scenario when both numbers are  negative
     *  inputs: ip1 : -5 , ip2:-10
     *  expectation: -12
     */
    @Test
    public void testAdd_2(){
        System.out.println("isnide testAdd2");
        int result=calcy.add(-5,-10);
        assertEquals(-15,result);
    }

}
