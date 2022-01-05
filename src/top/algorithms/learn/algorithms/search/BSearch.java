package top.algorithms.learn.algorithms.search;

/**
 * 二分查找
 * 时间复杂度：log（n）
 * 算法重点：终止条件、区间上下界更新方法、返回值选择
 * 算法适用：求“值等于给定值”的二分查找确实不怎么会被用到，二分查找更适合用在“近似”查找问题，在这类问题上，二分查找的优势更加明显
 *
 * @author jrl
 * @date 2021/4/13
 */
public class BSearch {
    public static void main(String[] args) {
        int target = 0;
        int[] resource = { 1,3,5};
//        boolean hasTarget = bSearch(target, resource, 0, resource.length - 1);
//        System.out.println(hasTarget);
//        int firstEqualValueIndex = getFirstEqualValueIndex(resource, target, 0, resource.length - 1);
//        System.out.println(firstEqualValueIndex);
//        int lastValueIndex = getLastValueIndex(resource, resource.length, target);
//        System.out.println(lastValueIndex);

//        int firstBiggerOrEqualValueIndex = getFirstBiggerOrEqualValueIndex(resource, resource.length, target);

//        System.out.println(firstBiggerOrEqualValueIndex);
//        int lastLessOrEqualValueIndex = getLastLessOrEqualValueIndex(resource, resource.length, target);
//        System.out.println(lastLessOrEqualValueIndex);
        int search = search(resource, target);
        System.out.println(search);

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
    /*二分查找算法的变形问题
     *1、查找第一个等于给定数值的元素
     *2、查找最后一个等于给定数值的元素
     *3、查找第一个大于等于给定数值的元素
     *4、查找第一个小于等于给定数值的元素
     * */

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
        if ((left == n && resource[n - 1] != target) || right < 0) {
            return -1;
        } else {
            return left - 1;
        }
    }

    /**
     * 【作者答案】
     * 获取最后一个值等于给定值的元素
     *
     * @param
     * @return
     * @date 2021/4/19
     */
    public int getLastValueIndex2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 【我的答案】
     * 查找第一个大于等于给定值的元素
     *
     * @param
     * @return
     * @date 2021-4-20
     */
    private static int getFirstBiggerOrEqualValueIndex(int[] resource, int n, int target) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            int middleValue = resource[middle];
            if (middleValue < target) {
                // 值在右边
                left++;
            } else if (middleValue >= target) {
                // 值在左边
                right--;
            }
        }
        // right在最终值的左边一位或者没有找到值
        if (left == n) {
            return -1;
        } else {
            return right + 1;
        }
    }

    /**
     * 【作者答案】
     * 查找第一个大于等于给定值的元素
     *
     * @param
     * @return
     * @date 2021-4-20
     */
    public int getFirstBiggerOrEqualValueIndex2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 【我的答案】
     * 查找最后一个小于等于给定值的数
     *
     * @param
     * @return
     * @date 2021-4-20
     */
    private static int getLastLessOrEqualValueIndex(int[] resource, int n, int target) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            int middleValue = resource[middle];
            if (middleValue <= target) {
                // 值在右边
                if (middle == n - 1 || resource[middle + 1] > target) {
                    return middle;
                }
                left++;
            } else if (middleValue > target) {
                // 值在左边
                right--;
            }
        }
        return -1;
    }

    /**
     * [作者答案]
     * 查找最后一个小于等于给定值的数
     *
     * @param
     * @return
     * @date 2021-4-20
     */
    public int getLastLessOrEqualValueIndex2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * [我的答案] todo 就是对应leetcode33哈
     * 如果有序数组是一个循环有序数组，比如 4，5，6，1，2，3。针对这种情况，如何实现一个求“值等于给定值”的二分查找算法呢？
     *
     * @param resource 循环有序数组
     * @param n        循环有序数组的长度
     * @param target   目标值
     * @return int[] 目标值所在下标位置
     * @date 2021-4-20
     */
    private static int[] getEqualValueIndex(int[] resource, int n, int target) {
        /*
         * 没有办法知道单个循环的界限
         * */
        return null;
    }

    /**
     * 搜索旋转排序数组
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * todo 优化 leetcode 33
     * @param
     * @return
     * @date 2021-4-21
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        /*
         * 二分查找旋转点，即查找第一个小于等于nums[0]的下标，顺便比较一下等不等于目标值，等于的话就直接返回
         * */
        int leftMostValue = nums[0];
        int left = 0;
        int right = nums.length - 1;
        int rotate = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int midValue = nums[mid];
            if (midValue == target) {
                return mid;
            } else {
                if (midValue <= leftMostValue) {
                    if (mid == 0 || nums[mid - 1] > leftMostValue) {
                        if (mid + 1 != nums.length && nums[mid + 1] < nums[mid]) {
                            rotate = mid + 1;
                        } else {
                            rotate = mid;
                        }
                        break;
                    }
                    right = mid - 1;

                } else {
                    left = mid + 1;
                }
            }
        }
        if (rotate == -1){
            rotate = 0;
        }
        /*
         * 根据下标0和旋转点的值，以及下标n-1的值，找出目标值可能的范围
         * */
        int rotateValue = nums[rotate];
        if (rotate == 0) {
            if (target < rotateValue) {
                return -1;
            } else {
                left = 0;
                right = nums.length - 1;
            }
        } else {
            if (target >= leftMostValue) {
                left = 0;
                right = rotate - 1;
            } else {
                left = rotate;
                right = nums.length - 1;
            }
        }

        /*
         * 二分法找目标值
         * */
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int midValue = nums[mid];
            if (midValue == target) {
                return mid;
            }
            if (target < midValue) {
                right = --mid;
            } else {
                left = ++mid;
            }
        }
        return -1;
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
