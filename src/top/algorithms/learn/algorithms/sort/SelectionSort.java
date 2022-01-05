package top.algorithms.learn.algorithms.sort;

/**
 * 选择排序：
 * （升序）分为已经排好的和未排好的，每次从未排好的元素里选择最小的那个放在已经排好的元素的末尾
 * 1.时间复杂度
 * 最好、最差、平均：O（n^2）
 * 2.空间复杂度
 * O(1)
 * 3.不稳定（因为是跨越式交换）
 * 4.比较、交换
 * 5.优化
 *  希尔排序：先做选择排序的预备准备，比较交换相隔较远的不同组的两个数，然后再整体选择排序
 *
 * @author jrl
 * @date Create in 09:52 2021-3-19
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {5, 8, 4, 9, 2};
        int n = 5;
        for (int i = 0; i < n; i++) {
            int min = a[i];
            int addr = i;
            for (int j = i; j < n; j++) {
                if (a[j] < min) {
                    min = a[j];
                    addr = j;
                }
            }
            int temp = a[i];
            a[i] = min;
            a[addr] = temp;

        }
        for (int i = 0; i < n; i++) {
            System.out.println(
                    a[i]
            );
        }
    }


}
