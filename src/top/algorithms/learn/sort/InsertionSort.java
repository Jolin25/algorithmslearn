package top.algorithms.learn.sort;

/**
 * 插入排序
 * 分为已经排好的和未排好的，每次从未排好的元素里拿第一个插入到已经排好的元素里的正确位置
 * 1.原地排序
 * 2.比较、移动
 * 3.时间复杂度
 * 最好时间复杂度：O(n)
 * 最差时间复杂度：O(n^2)
 * 平均时间复杂度：O(n^2)
 * 4.稳定
 *
 * @author jrl
 * @date Create in 10:40 2021-3-18
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[][] a = new int[100000][2000];
        a = initArray(a);
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < a.length; i++) {
            insertionSort(a[i], 2000);
        }
        System.out.println(System.currentTimeMillis());
    }

    private static int[][] initArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            int[] b = new int[2000];
            for (int j = 0; j < 2000; j++) {
                b[j] = (int) Math.random();
            }
            a[i] = b;
        }
        return a;
    }

    /**
     * 升序
     *
     * @param
     * @return
     * @date 2021-3-18
     */
    public static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            // 比较 --->个人优化的结果，如果当前数比有序数组中的最后一个数大，那么这个数不动，该数组就是有序的
            if (a[i] < a[i - 1]) {
                int val = a[i];
                // 插入
                for (int j = i - 1; j >= 0; j--) {
                    //比较
                    if (val >= a[j]) {
                        a[j + 1] = val;
                        break;
                    }
                    a[j + 1] = a[j];
                }
            }
        }
//        for (int aa : a
//        ) {
//            System.out.println(aa);
//        }
    }
}
