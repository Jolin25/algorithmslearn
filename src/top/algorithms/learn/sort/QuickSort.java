package top.algorithms.learn.sort;

/**
 * 快速排序:(以下代码实现是错误的，只是实现了其基本思想，然而没有实现其重要的精髓：原地排序)
 * 采用分治思想
 * 随机选取数组中的一个数作为pivot，小于pivot的放在左边，大于等于的放在右边。在左右两边又分别再选取各自的pivot，以此类推。
 * 1.不稳定
 * 2.时间复杂度(递归的时候，想树，最外面那层就是树的深度，每增加一个深度就是最外面那一层所做的操作)
 * 平均、最好：O(nlogn)
 * 最差：O(n^2)
 * 3.空间复杂度
 * O(1)  （但是下面的这个实现不是，下面这个实现是n）
 *
 * @author jrl
 * @date Create in 09:44 2021-3-23
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {5, 8, 9, 4, 2};
        int[] ints = quickSort(a);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ",");
        }
    }

    public static int[] quickSort(int[] a) {
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
        int[] leftResult = quickSort(realLeftA);
        int[] rightResult = quickSort(realRightA);
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
