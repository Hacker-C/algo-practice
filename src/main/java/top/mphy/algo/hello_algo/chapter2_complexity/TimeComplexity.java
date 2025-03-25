package top.mphy.algo.hello_algo.chapter2_complexity;

public class TimeComplexity {
    /**
     * 冒泡排序 O(n^2)
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        boolean swapped = false;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // 第一轮就没有发生交换，说明本身就是有序的
        }
    }

    /**
     * 细胞分裂n轮后的总分裂次数
     * @param n
     * @return
     */
    public static long totalDivisions(int n) {
        int res  = 0, addition = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < addition; j++) {
                res++;
            }
            addition *= 2;
        }
        return res;
    }

    /**
     * 细胞分裂n轮后的总分裂次数：递归版本
     * @param n
     * @return
     */
    public static long totalDivisionsRecur(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return totalDivisions(n - 1) + totalDivisions(n - 1) + 1;
    }

    /**
     * 阶乘
     * @param n
     * @return
     */
    public static long factorialRecur(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorialRecur(n - 1);
    }
}
