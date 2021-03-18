package top.algorithms.learn.sort;

/**
 * @author jrl
 * @date Create in 10:11 2021-3-18
 */
public class BubbleSortLearn {

    /**
     * 冒泡排序，a表示数组，n表示数组大小
     * 1.比较、交换
     * 2.原地排序
     * 3.稳定
     * 4.优化:
     * 利用flag来标志此次循环中有没有交换两个元素的位置，如果没有，那么说明这个数组已经是完全有序的了，以此来跳出循环，减少循环次数
     * 5.时间复杂度（优化后）：
     * 最好时间复杂度：O(n)
     * 最差时间复杂度：O(n^2)
     * 平均时间复杂度：O(n^2)
     *
     * @param
     * @return
     * @date 2021-3-18
     */
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                // 比较
                if (a[j] > a[j + 1]) {
                    //交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag) {
                break;
            }
        }
    }
}
