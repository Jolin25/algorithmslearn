package top.algorithms.learn.search;

import java.math.BigDecimal;

/**
 * 二分查找
 *
 * @author jrl
 * @date 2021/4/13
 */
public class BSearch {
    public static void main(String[] args) {
        int target = 7;
        int[] resource = {1, 1, 3, 3, 4, 5, 7, 7};
//        boolean hasTarget = bSearch(target, resource, 0, resource.length - 1);
//        System.out.println(hasTarget);
//        int firstEqualValueIndex = getFirstEqualValueIndex(resource, target, 0, resource.length - 1);
//        System.out.println(firstEqualValueIndex);
        int lastValueIndex = getLastValueIndex(resource, resource.length - 1, 7);
        System.out.println(lastValueIndex);
    }

    /**
     * 最简单的版本：
     * 没有重复的数值
     *
     * @param
     * @return
     * @date 2021/4/19
     */
    private static boolean bSearch(int target, int[] resource, int left, int right) {
        if (right - left < 0) {
            return false;
        }
        // (right + left) / 2 不可取，因为right+left可能会溢出
        int middle = left + ((right - left) >> 1);
        if (target == resource[middle]) {
            return true;
        }
        if (target < resource[middle]) {
            return bSearch(target, resource, left, middle - 1);
        } else {
            return bSearch(target, resource, middle + 1, right);
        }
    }

    /**
     * 【我的初版答案】
     * 【假设给定的数组从小到大排列】
     * 查找第一个值等于给定值的元素
     *
     * @param
     * @return int 值所在的下标
     * @date 2021/4/19
     */
    private static int getFirstEqualValueIndex(int[] resource, int target, int left, int right) {
        if (right < left) {
            return -1;
        }
        int middle = left + ((right - left) >> 1);
        int middleValue = resource[middle];
        if (middleValue == target) {
            /*
             * 因为要找的是第一个，所以值要么为当前的位置，要么为当前位置的左边。
             * 因为会有重复元素，所以可能重复多少是不一定的，理论上来讲应该根据实际问题的重复可能性的情况来进行操作。
             * 所以以下的操作是建立在，我认为的可以进行“优化”的操作上的，即可以根据实际情况来减少一些不必要的优化。
             * 1.查看该元素A的左边那个元素B等不等于目标值，如果等于，那么查找左边该元素B和最左边元素LEFT的中间值M，查看是否等于目标值
             * 2.如果等于则重复1步骤，如果不等于，那么值应该在该中间值M和B之间，则进行二分法来查找，直到某一次通过二分法找到的值是边界值
             * */
            int B = middle - 1;
            if (B >= 0 && resource[B] == target) {
                return getFirstEqualValueIndex(resource, target, left, B);
            } else {
                return middle;
            }
        }
        if (middleValue > target) {
            // 值在左边
            return getFirstEqualValueIndex(resource, target, left, middle - 1);
        }
        if (middleValue < target) {
            // 值在右边
            return getFirstEqualValueIndex(resource, target, middle + 1, right);
        }
        return -1;
    }

    /**
     * 【简洁版答案】
     * 找到第一个值等于给定值的下标
     *
     * @param
     * @return
     * @date 2021/4/19
     */
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low < n && a[low] == value) return low;
        else return -1;
    }

    /**
     * [作者答案]
     * 找到第一个值等于给定值的下标
     *
     * @param
     * @return
     * @date 2021/4/19
     */
    public int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 【我的答案】
     * 获取最后一个值等于给定值的元素
     *
     * @param
     * @return
     * @date 2021/4/19
     */
    private static int getLastValueIndex(int[] resource, int n, int target) {
        int right = n - 1;
        int left = 0;
        // 练习用while取代显示递归
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            int middleValue = resource[middle];
            if (middleValue > target) {
                right--;
            } else if (middleValue <= target) {
                left++;
            }
        }
        // 跳出循环后，left此时应该是在最后一个值的右边一位或者没有找到值
        if (left == n || right < 0) {
            return -1;
        } else {
            return left - 1;
        }
    }
    /**
     * 求一个数的平方根，精确到小数点后6位
     *
     * @param
     * @return
     * @date 2021/4/13
     */
//    private BigDecimal SquareRoot(BigDecimal num) {
//        int compareTo = num.compareTo(new BigDecimal("1");
//        if (0 == compareTo) {
//            return new BigDecimal("1");
//            // (x>1)y的位数在x的位数/2至x的位数/2+1的区间
//        } else if (compareTo == 1) {
//
//            // (x<1)y在x至1之间
//        } else if (compareTo == -1) {
//            BigDecimal result = getResult(num, new BigDecimal("1"), num, "smaller");
//        }
//    }
//
//    private BigDecimal getResult(BigDecimal begin, BigDecimal end, BigDecimal x, String witchType) {
//        String bigger = "bigger";
//        String smaller = "smaller";
//        if (bigger.equals(witchType)) {
//
//        } else if (smaller.equals(witchType)) {
//            BigDecimal guess = begin + ((end - begin) / 2);
//
//            if (guess * guess == x) {
//                return guess;
//            } else if (guess * guess < x) {
//                return getResult(guess, end, x, witchType);
//            } else if (guess * guess > x) {
//                return getResult(begin, guess, x, witchType);
//            }
//        }
//        return null;
//    }
}
