package top.algorithms.learn.pattern;

/**
 * 从扑克牌中随机抽取5张，判断是不是一个顺子。
 * A为1，J为10，Q为11，K为12，大小王为0或任意数字。
 * A不能看做14.
 *
 * @author jrl
 * @date Create in 9:54 2022/5/16
 */
public class Poker {
    public static void main(String[] args) {
        Poker poker = new Poker();
        int[] pokers = {2, 3, 4, 0, 0};
        // Boolean b = poker.ifSequence(pokers);
        Boolean b = poker.isStraight(pokers);
        System.out.println(b);
    }

    /**
     * 老师的答案
     *
     * @param
     * @return
     * @date 2022/5/17
     */
    private Boolean isStraight(int[] pokers) {
        int max = pokers[0];
        int min = pokers[0];
        boolean[] dup = new boolean[14];
        for (int i = 0; i < pokers.length; i++) {
            if (pokers[i] != 0) {
                if (dup[pokers[i]]) {
                    return false;
                } else {
                    dup[pokers[i]] = true;
                }
                if (pokers[i] > max) {
                    max = pokers[i];
                }
                if (pokers[i] < min) {
                    min = pokers[i];
                }
            }
        }
        return (max - min) < 5;
    }

    /**
     * 【卒】我的答案
     *
     * @param
     * @return
     * @date 2022/5/16
     */
    private boolean ifSequence(int[] pokers) {
        boolean[] used = new boolean[pokers.length];
        int[] noBigger = new int[pokers.length];
        boolean hasZero = false;
        int noBiggerNum = 0;
        for (int i = 0; i < pokers.length; i++) {
            int p = pokers[i];
            if (p == 0) {
                hasZero = true;
            }
            boolean hasBigger = false;
            for (int j = 0; j < pokers.length; j++) {
                if (p + 1 == pokers[j] && !used[j]) { // 有比自己大一的数
                    used[j] = true;// 该数已经比某个数大一了
                    hasBigger = true;
                    break;
                }
            }
            if (!hasBigger) {
                noBigger[noBiggerNum++] = p;
            }
        }
        if (hasZero && noBiggerNum > 3 || !hasZero && noBiggerNum > 1) {
            return false;
        }

        if (!hasZero) {
            return true;
        }
        if (hasZero) {
            if (noBiggerNum == 1) {
                return true;
            }

            if (noBiggerNum == 3) {
                int[] bigger2 = new int[pokers.length];
                int num = 0;
                boolean zeroNoBigger = false;
                for (int i = 0; i < noBiggerNum; i++) {
                    int i1 = noBigger[i];
                    if (i1 == 0) {
                        zeroNoBigger = true;
                    }
                    if (i1 != 0) {
                        bigger2[num++] = i1;
                    }
                }
                if (!zeroNoBigger) { // 如果这三个数里没有0，就绝对凑不出来顺子
                    return false;
                }
                if (Math.abs(bigger2[0] - bigger2[1]) == 3) {
                    return true;
                }
                return false;
            }
            if (noBiggerNum == 2) {
                int[] bigger2 = new int[2];
                int num = 0;
                boolean zeroNoBigger = false;
                for (int i = 0; i < noBiggerNum; i++) {
                    int i1 = noBigger[i];
                    if (i1 == 0) {
                        zeroNoBigger = true;
                    }
                    if (i1 != 0) {
                        bigger2[num++] = i1;
                    }
                }
                if (!zeroNoBigger) { // 如果这两个数里没有0
                    if (Math.abs(bigger2[0] - bigger2[1]) == 3) {
                        return true;
                    }
                } else {
                    return true;
                }

                return false;
            }
        }
        return false;
    }
}
