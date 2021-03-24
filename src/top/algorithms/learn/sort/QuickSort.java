package top.algorithms.learn.sort;

/**
 * 快速排序:(以下代码quickSortOld实现是错误的，只是实现了其基本思想，然而没有实现其重要的精髓：原地排序(quickSort方法实现了))
 * 采用分治思想
 * 随机选取数组中的一个数作为pivot，小于pivot的放在左边，大于等于的放在右边。在左右两边又分别再选取各自的pivot，以此类推。
 * 1.不稳定
 * 2.时间复杂度(递归的时候，想树，最外面那层就是树的深度，每增加一个深度就是最外面那一层所做的操作)
 * 平均、最好：O(nlogn)
 * 最差：O(n^2)
 * 3.空间复杂度（快排的精髓）
 * O(1)
 *
 * @author jrl
 * @date Create in 09:44 2021-3-23
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {5, 8, 9, 4, 2};
//        int[] ints = quickSortOld(a);
        int[] ints = quickSort(a, 0, a.length - 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ",");
        }
    }

    public static int[] quickSort(int[] a, int begin, int end) {
        // 把pivot放在合适的位置，并且分离出pivot左右两边。

        partition(a, begin, end);
        return a;
    }

    /**
     * 升序
     * 划分pivot左右两边,[begin,end]
     *
     * @param
     * @return pivot划分后最后确定的位置
     * @date 2021-3-24
     */
    public static void partition(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }
        //划分pivot左右两边
        // 选取数组最后一个数作为pivot（选哪个都行）
        int pivotIndex = end;
        int pivot = a[pivotIndex];
        int j = begin;
        // i 用来遍历，j用来划分小于pivot和大于pivot的部分，a[0]至a[j-1]为小于pivot的部分.
        for (int i = begin; i < end; i++) {
            // 如果a[i]小于pivot，那么a[i]就和a[j]交换位置，即把a[i]放到小于pivot的最后一位上
            if (a[i] < pivot) {
                int temp = a[i];
                a[i++] = a[j];
                a[j++] = temp;
            }
        }
        //交换a[j] 和 a[pivotIndex] ，那么这个时候pivot就到了合适的位置，并且左右两边分别小于和大于它
        int temp = a[j];
        a[j] = a[pivotIndex];
        a[pivotIndex] = temp;
        // 此时的pivotIndex其实就是j这个数
        pivotIndex = j;
        //再分别处理左右两边，找到左右两边的pivot，并且划分好pivot左右两边
        partition(a, begin, pivotIndex - 1);
        partition(a, pivotIndex + 1, end);
    }

    @Deprecated
    public static int[] quickSortOld(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int pivotValue = a[(a.length + 1) / 2 - 1];
        int[] leftA = new int[a.length];
        int[] rightA = new int[a.length];
        //左
        int l = 0;
        //右
        int r = 0;
        for (int i = 0; i < a.length; i++) {
            if (i != (a.length + 1) / 2 - 1) {
                if (a[i] > pivotValue) {
                    rightA[r++] = a[i];
                } else {
                    leftA[l++] = a[i];
                }
            }
        }
        int[] realLeftA = new int[l];
        for (int i = 0; i < l; i++) {
            realLeftA[i] = leftA[i];
        }
        int[] realRightA = new int[r];
        for (int i = 0; i < r; i++) {
            realRightA[i] = rightA[i];
        }
        int[] leftResult = quickSortOld(realLeftA);
        int[] rightResult = quickSortOld(realRightA);
        int m = 0;
        int n = 0;
        for (int i = 0; i < a.length; i++) {
            if (m < l && leftResult.length > 0) {
                a[i] = leftResult[m++];
            } else if (m >= l) {
                if (i == m) {
                    a[i] = pivotValue;
                } else if (rightResult.length > 0) {
                    a[i] = rightResult[n++];
                }
            }
        }
        return a;
    }
}
