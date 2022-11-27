package org.mhiginio._11containerwithmostwater;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{1, 1}, 1),
                Arguments.of(new int[]{2, 1}, 1),
                Arguments.of(new int[]{0, 2}, 0)
        );
    }

    @ParameterizedTest(name = "Jump game for \"{0}\" should return {1}")
    @MethodSource("testData")
    void test(int[] value, int result) {
        assertEquals(result, solution.maxArea(value));
    }

}