package top.algorithms.learn.pattern;

/**
 * 现有x瓶啤酒，每3个空瓶子换一瓶啤酒，每7个瓶盖子也可以换一瓶啤酒，
 * 问最后可以喝多少瓶啤酒？
 *
 * @author jrl
 * @date Create in 10:08 2022/5/5
 */
public class Beer {
    public static void main(String[] args) {
        int num = 7;
        int sum = exchangeBeer(num);
        System.out.println(sum);
    }

    private static int exchangeBeer(int num) {
        int sum = num;
        int numBottle = num;
        int numCap = num;
        while (numBottle / 3 > 0 || numCap / 7 > 0) {
            int addBottle = numBottle / 3;
            int addCap = numCap / 7;
            sum = sum + addBottle + addCap;
            numBottle = addBottle + addCap + numBottle % 3;
            numCap = addCap + addBottle + numCap % 7;
        }
        return sum;
    }

}
