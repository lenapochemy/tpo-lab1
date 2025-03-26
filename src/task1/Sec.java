package task1;

public class Sec {


    public static double sec(double x) {
        if (Math.abs(x / (Math.PI / 2)) % 2 == 1)
            throw new IllegalArgumentException("Function sec(x) is not defined at the point " + x);
        if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY)
            throw new IllegalArgumentException("Function sec(x) is not defined at the infinity");

        double sum = 0;
        double tmp = 1;
        int n = 0;
        while (Math.abs(tmp) > 0.000001) {
            tmp = Math.pow(-1, n) * Math.pow(x, 2 * n) / factorial(2 * n);
            sum += tmp;
            n++;
        }
        return 1 / sum;
    }

    public static int factorial(int n) {
        int acc = 1;
        for (int i = 1; i <= n; i++) {
            acc *= i;
        }
        return acc;
    }


}
