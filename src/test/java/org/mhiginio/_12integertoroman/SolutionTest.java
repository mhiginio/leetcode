package org.mhiginio._12integertoroman;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(10, "X"),
                Arguments.of(1111, "MCXI"),
                Arguments.of(3, "III"),
                Arguments.of(58, "LVIII"),
                Arguments.of(1994, "MCMXCIV"),
                Arguments.of(505, "DV")
        );
    }

    @ParameterizedTest(name = "{0} in roman is {1}")
    @MethodSource("testData")
    void test(int decimal, String result) {
        assertEquals(result, solution.intToRoman(decimal));
    }

}