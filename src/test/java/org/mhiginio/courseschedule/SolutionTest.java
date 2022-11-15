package org.mhiginio.courseschedule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution = new Solution();

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, new int[][]{{1, 0}}, true),
                Arguments.of(2, new int[][]{{1, 0}, {0, 1}}, false),
                Arguments.of(4, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 1}}, false),
                Arguments.of(1000, new int[][]{}, true),
                Arguments.of(4, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}}, true)
        );
    }

    @ParameterizedTest(name = "numSources={0}, prerequisites={1}, expectedResult={2}")
    @MethodSource("testData")
    void test_can_finish_courses(int numSources, int[][] prerequisites, boolean result) {
        assertEquals(result, solution.canFinish(numSources, prerequisites));
    }

}