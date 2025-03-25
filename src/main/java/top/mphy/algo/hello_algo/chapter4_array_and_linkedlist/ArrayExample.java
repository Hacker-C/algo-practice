package top.mphy.algo.hello_algo.chapter4_array_and_linkedlist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayExample {

    public static void main(String[] args) {
        arrayInit();
    }

    public static void arrayInit() {
        // 1
        int[] arr1 = {1, 2, 3};
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};
        char[] arr3 = {'a', 'b', 'c'};

        // 2
        String[] strs = new String[] {"a", "b"};
        char[] chrs = new char[] {'1', '2', '3'};

        // 3
        Integer[] nums = new Integer[3]; // [0,0,0]
        char[] chars1 = new char[3]; // [,,]
        boolean[] booleans = new boolean[3]; // [false,false,false]

        // 4
        int[] arrs = new int[10];
        Arrays.fill(arrs, 3);

        // 6
        int[] nums1 = IntStream.range(0, 10).toArray();
        System.out.println(Arrays.toString(nums1));

        // 7、int... 转 int[]
        int[] a = genArray(1,2,3,4);
        System.out.println(Arrays.toString(a));

        // 8、List 转 Array
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // new Integer[0] 只是为了提供类型信息，JVM 会自动创建正确大小的数组
        Integer[] array = list.toArray(new Integer[0]);

        // 10、Array 转 List
        String[] strs0 = {"a", "b", "c"};
        List<String> strList = Arrays.stream(strs0).toList();

        // 11、Integer[] 转 int[]
        Integer[] integers = new Integer[] {1,2,3};
        int[] ints = Arrays.stream(integers).mapToInt(Integer::intValue).toArray();

        // 12、int[] 转 Integer[]
        int[] ints1 = {1,2,3};
        Integer[] integers1 = Arrays.stream(ints1).boxed().toArray(Integer[]::new);
    }

    public static int[] genArray(int... nums) {
        return nums.clone();
    }
}
