package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class QuickSortTest {

    @ParameterizedTest
    @MethodSource("provideBlackBoxTestArguments")
    void quickSortBlackBoxTest(Integer[] unsorted, Integer[] sorted) {
        Assertions.assertArrayEquals(sorted, QuickSort.sort(unsorted));
    }


    private static Stream<Arguments> provideBlackBoxTestArguments() {
        return Stream.of(
                Arguments.of(new Integer[]{12, 4, 8, 23, 6, 34, 868, 45, 8, 4}, new Integer[]{4, 4, 6, 8, 8, 12, 23, 34, 45, 868}),
                Arguments.of(new Integer[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, new Integer[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}),
                Arguments.of(new Integer[]{}, new Integer[]{}),
                Arguments.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
        );
    }

    @ParameterizedTest
    @MethodSource("provideGreyBoxTestArguments")
    void quickSortGreyBoxTest(Integer[] unsorted, int sw1, int sw2, Integer[] swapped1,
                              int sw3, int sw4, Integer[] swapped2,
                              int part1, int part2, Integer[] partitioned,
                              Integer[] sorted) {
        Integer[] arraySwapped1 = unsorted.clone();
        QuickSort.swap(arraySwapped1, sw1, sw2);
        Assertions.assertArrayEquals(swapped1, arraySwapped1);

        Integer[] arraySwapped2 = unsorted.clone();
        QuickSort.swap(arraySwapped2, sw3, sw4);
        Assertions.assertArrayEquals(swapped2, arraySwapped2);

        Integer[] arrayPartitioned = unsorted.clone();
        QuickSort.partition(arrayPartitioned, part1, part2);
        Assertions.assertArrayEquals(partitioned, arrayPartitioned);

        Integer[] arraySorted1 = unsorted.clone();
        QuickSort.quickSort(arraySorted1, 0, arraySorted1.length - 1);
        Assertions.assertArrayEquals(sorted, arraySorted1);

        Integer[] arraySorted2 = unsorted.clone();
        Assertions.assertArrayEquals(sorted, QuickSort.sort(arraySorted2));
    }


    private static Stream<Arguments> provideGreyBoxTestArguments() {
        return Stream.of(
                Arguments.of(new Integer[]{12, 4, 8, 23, 6, 34, 868, 45, 8, 4}, 3, 4,
                        new Integer[]{12, 4, 8, 6, 23, 34, 868, 45, 8, 4}, 3, 3, new Integer[]{12, 4, 8, 23, 6, 34, 868, 45, 8, 4},
                        0, 9, new Integer[]{8, 4, 8, 4, 6, 12, 868, 45, 34, 23}, new Integer[]{4, 4, 6, 8, 8, 12, 23, 34, 45, 868}),
                Arguments.of(new Integer[]{4, 4, 4, 4, 4, 4, 4, 4}, 2, 3,
                        new Integer[]{4, 4, 4, 4, 4, 4, 4, 4}, 3, 3, new Integer[]{4, 4, 4, 4, 4, 4, 4, 4},
                        0, 7, new Integer[]{4, 4, 4, 4, 4, 4, 4, 4}, new Integer[]{4, 4, 4, 4, 4, 4, 4, 4}),
                Arguments.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4, 7, new Integer[]{1, 2, 3, 4, 8, 6, 7, 5, 9},
                        3, 3, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0, 8, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                        new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
        );
    }

    @Test
    void quickSortGreyBoxTestTEmptyArray() {
        Integer[] unsorted = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> QuickSort.swap(unsorted, 0, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> QuickSort.swap(unsorted, 3, 5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> QuickSort.partition(unsorted, 0, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> QuickSort.partition(unsorted, 0, 5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> QuickSort.quickSort(unsorted, 0, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> QuickSort.quickSort(unsorted, 2, 4));
        Integer[] sorted = unsorted.clone();
        Assertions.assertArrayEquals(sorted, QuickSort.sort(unsorted));
    }

}