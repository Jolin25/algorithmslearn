package top.algorithms.learn.algorithms.sort;

/**
 * 归并排序:
 * 利用了分治思想，采用递归实现
 * 每次把左右两边的数排好，再把结果传给上一层
 * 1.时间复杂度
 * O(nlogn)
 * 2.空间复杂度
 * O(n)  主要用在了合并那一步存合好的数组
 * 3.稳定
 * 4.递归、比较
 *
 * @author jrl
 * @date Create in 10:29 2021-3-22
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {5, 8, 9, 4, 2};
        int n = a.length;
        int begin = 0;
        int end = n - 1;
        int[] result = mergeSort(a, n, begin, end);
        for (int i = 0; i < result.length - 1; i++) {
            System.out.print(result[i] + ",");
        }
    }

    public static int[] mergeSort(int[] a, int n, int begin, int end) {
        if (begin >= end) {
            int[] aa = new int[n + 1];
            aa[n] = Integer.MAX_VALUE;
            aa[0] = a[0];
            return aa;
        }
        // 左边排序
        int leftN = n / 2;
        int leftBegin = 0;
        int leftEnd = n / 2 - 1;
        int[] leftA = new int[leftN];
        for (int i = 0; i < leftN; i++) {
            leftA[i] = a[i];
        }
        int[] mergedLeft = mergeSort(leftA, leftN, 0, leftN - 1);
        // 右边排序
        int rightN = n - leftN;
        int rightBegin = leftEnd + 1;
        int rightEnd = end;
        int[] rightA = new int[rightN];
        for (int i = 0; i < rightN; i++) {
            rightA[i] = a[i + rightBegin];
        }
        int[] mergedRight = mergeSort(rightA, rightN, 0, rightN - 1);
        //将各自排好序的左右两边合并
        //最后一个位置留给哨兵
        int[] mergedA = new int[n + 1];
        int result = 0;
        // 左边数组
        int i = 0;
        // 右边数组
        int j = 0;
        // 使用哨兵
        mergedLeft[mergedLeft.length - 1] = Integer.MAX_VALUE;
        mergedRight[mergedRight.length - 1] = Integer.MAX_VALUE;
        while (result < mergedA.length - 1) {
            if (mergedLeft[i] > mergedRight[j]) {
                mergedA[result++] = mergedRight[j++];
            } else {
                mergedA[result++] = mergedLeft[i++];
            }
        }
//        if (j == rightEnd && result < n) {
//            for (int k = i; k < mergedLeft.length; k++) {
//                mergedA[result++] = mergedLeft[i++];
//            }
//        } else if (i == leftN && result < n) {
//            for (int k = j; k < mergedRight.length; k++) {
//                mergedA[result++] = mergedRight[j++];
//            }
//        }
        return mergedA;
    }
}
