package com.example.customermsrestdatajpa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorUnitTest {

    Calculator calcy;
    Adder adder;

    @BeforeEach
    public void setup(){
        System.out.println("inside setup");
        calcy = new Calculator();
        adder=mock(Adder.class);
        calcy.setAdder(adder);
    }

    @AfterEach
    public  void clear(){
        System.out.println("inside clean");
    }
    /**
     *  scenario when both numbers are positive
     *  inputs: ip1 : 5 , ip2:7
     *  expectation: 12
     */
    @Test
    public void testAdd_1(){
        System.out.println("isnide testAdd1");
        when(adder.add(5,7)).thenReturn(12);
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
        when(adder.add(-5,-10)).thenReturn(-15);
        int result=calcy.add(-5,-10);
        assertEquals(-15,result);
    }

    @Test
    public void testAddBy10_1(){
        int num=5;
        Calculator spy=spy(calcy);
        //when(spy.add(num,10)).thenReturn(15);
        doReturn(15).when(spy).add(num,10);
        int result=spy.addBy10(num);
         assertEquals(15,result);
    }

}
