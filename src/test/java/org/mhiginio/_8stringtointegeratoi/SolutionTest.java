package org.mhiginio._8stringtointegeratoi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("42", 42),
                Arguments.of("", 0),
                Arguments.of(" ", 0),
                Arguments.of("a", 0),
                Arguments.of("   -42", -42),
                Arguments.of("42 blabla", 42),
                Arguments.of("9999999999999999", Integer.MAX_VALUE),
                Arguments.of("-9999999999999999", Integer.MIN_VALUE),
                Arguments.of("-2147483648", Integer.MIN_VALUE),
                Arguments.of("-2147483647", -2147483647),
                Arguments.of("2147483647", Integer.MAX_VALUE)
        );
    }

    @ParameterizedTest(name = "Jump game for \"{0}\" should return {1}")
    @MethodSource("testData")
    void test(String value, int result) {
        assertEquals(result, solution.myAtoi(value));
    }


}