package top.mphy.algo.hello_algo.chapter2_complexity;

public class IterationAnRecursion {
    public static int fib(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static int tailRecur(int n, int res) {
        if (n == 1 || n == 0) {
            return res + n;
        }
        return tailRecur(n - 1, res + n);
    }
}
