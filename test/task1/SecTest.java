package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class SecTest {
    private final double delta = 0.000001;

    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI / 6, Math.PI / 4, Math.PI / 3, 1,
            -Math.PI / 6, -Math.PI / 4, -Math.PI / 3, -1, Double.NaN})
    void secTailor(double x) {
        Assertions.assertEquals(1 / Math.cos(x), Sec.sec(x), delta);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 2, 3 * Math.PI / 2, 7 * Math.PI / 2,
            -Math.PI / 2, -3 * Math.PI / 2, -7 * Math.PI / 2})
    void secTailorNotDefined(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Sec.sec(x));
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    void secTailorInfinity(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Sec.sec(x));
    }


    @Test
    void factorialTest() {
        Assertions.assertEquals(1, Sec.factorial(1));
        Assertions.assertEquals(1, Sec.factorial(0));
        Assertions.assertEquals(6, Sec.factorial(3));
    }

}