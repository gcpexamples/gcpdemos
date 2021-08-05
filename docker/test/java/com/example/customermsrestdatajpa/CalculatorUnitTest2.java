package com.example.customermsrestdatajpa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorUnitTest2 {


    @Mock
    Adder adder;

    @InjectMocks
    @Spy
    Calculator calcy;

    @BeforeEach
    public void setup() {
        System.out.println("inside setup");
    }

    @AfterEach
    public void clear() {
        System.out.println("inside clean");
    }

    /**
     * scenario when both numbers are positive
     * inputs: ip1 : 5 , ip2:7
     * expectation: 12
     */
    @Test
    public void testAdd_1() {
        System.out.println("isnide testAdd1");
        when(adder.add(5, 7)).thenReturn(12);
        int result = calcy.add(5, 7);
        assertEquals(12, result);
    }

    /**
     * scenario when both numbers are  negative
     * inputs: ip1 : -5 , ip2:-10
     * expectation: -12
     */
    @Test
    public void testAdd_2() {
        System.out.println("isnide testAdd2");
        when(adder.add(-5, -10)).thenReturn(-15);
        int result = calcy.add(-5, -10);
        assertEquals(-15, result);
    }

    @Test
    public void testAddBy10_1() {
        int num = 5;
        doReturn(15).when(calcy).add(num, 10);
        int result = calcy.addBy10(num);
        assertEquals(15, result);
    }

}
