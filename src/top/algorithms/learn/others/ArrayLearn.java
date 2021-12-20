package top.algorithms.learn.others;

import java.util.ArrayList;

/**
 * @Author:jrl
 * @Date:Create in 15:33 2021-2-24
 * @Description:验证数组下标越界问题 结论：java是会在运行时判断是否越界的，并不会和C一样只能根据数据basic地址找到对应的数据就展示出来
 * 如果越界会排除ArrayIndexOutOfBoundsException
 */
public class ArrayLearn {
    public static void main(String[] args) {
        new ArrayLearn().learnArrayList();
//        int[] array = {0, 1, 2};
//        int i = 0;
//        for (int j = 0; j < array.length + 1; j++) {
//            if (j < 3) {
//                System.out.println("没有越界"+array[j]);
//            } else {
//                System.out.println("越界了"+array[j]);
//            }
//        }
    }
    void learnArrayList(){
        /**
         * knowledge point:
         *     ???疑问贼多，看了JVM以后过来解答一下，这个执行顺序有点迷啊
         * */

        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < 11 ; i++) {
            System.out.println(i);
            a.add(i);
        }
        /**
         * knowledge point:
         * 最好事先确定好数组大小，不然动态扩容还是比较费时的，因为涉及到内存申请和数据搬移
         */

        ArrayList<Integer> b = new ArrayList<>(100);
    }
}
