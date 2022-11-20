package org.mhiginio._45jumpgameii;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 1, 4}, 2),
                Arguments.of(new int[]{2, 3, 0, 1, 4}, 2),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{2, 2, 2, 2, 2, 2}, 3)
        );
    }

    @ParameterizedTest(name = "Jump game for {0} should return {1}")
    @MethodSource("testData")
    void test(int[] nums, int result) {
        assertEquals(result, solution.jump(nums));
    }

}