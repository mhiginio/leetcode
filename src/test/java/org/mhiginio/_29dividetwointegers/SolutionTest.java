package org.mhiginio._29dividetwointegers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(10, 3, 3),
                Arguments.of(1000, 10, 100),
                Arguments.of(7, -3, -2),
                Arguments.of(-2147483648, -1, 2147483647)

        );
    }

    @ParameterizedTest(name = "{0}/{1}={2}")
    @MethodSource("testData")
    void test(int dividend, int divisor, int result) {
        assertEquals(result, solution.divide(dividend, divisor));
    }
}