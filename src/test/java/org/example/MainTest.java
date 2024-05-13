package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
public class MainTest {
    Main m = new Main();
    @ParameterizedTest
    @MethodSource("arraysProvider")
    public void invo(double [] distance,int [] time){
        Assert.assertEquals("Success", m.Invoice(distance,time));
    }
    static Stream<Arguments> arraysProvider() {
        return Stream.of(
                Arguments.of(new double[]{1.0, 2.1, 3.4,5.4}, new int[]{1, 2, 3,1}), // Test case 1: Equal arrays
                Arguments.of(new double[]{0.5,0.3,1}, new int[]{2,1,4}) // Test case 2: Empty arrays
//                Arguments.of(new double[]{1, 2, 3}, new int[]{3, 2, 1}), // Test case 3: Arrays with same elements but in reverse order
//                Arguments.of(new double[]{1, 2, 3}, new int[]{1, 2}), // Test case 4: Arrays with different lengths
//                Arguments.of(new double[]{1, 2, 3}, new int[]{1, 2, 4}) // Test case 5: Arrays with different elements
        );
    }
}