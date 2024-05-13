package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
public class MainTest {
    Main m = new Main();
    @ParameterizedTest(name = "Passing the id and value also retriving the data by id")
    @MethodSource("arraysProvider")
    public void invo(int id,double [] distance,int [] time){
        Assert.assertEquals("Bill Generated", m.method(id,distance,time));
        Assert.assertEquals("Success",m.printmethod(id));
    }
    static Stream<Arguments> arraysProvider() {
        return Stream.of(
                Arguments.of(1, new double[]{1.0, 2.1, 3.4,5.4}, new int[]{1, 2, 3,1}),
                Arguments.of(2,new double[]{0.5,0.3,1}, new int[]{2,1,4}),
                Arguments.of(3,new double[]{7,8.5,3.5}, new int[]{22,60,5}),
                Arguments.of(4,new double[]{5.5,4.3,6.7,8.7,3.2,1.25,10.32}, new int[]{30,23,60,75,20,11,100}),
                Arguments.of(5,new double[]{1, 2, 3}, new int[]{1, 2, 4})
        );
    }
}