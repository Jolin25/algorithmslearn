package top.algorithms.learn.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class 分析Java自带的排序函数的实现 {
    public static void main(String[] args) {
        /*数组排序*/
        int[] arr = {2,1,3};
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(
                a->
                    System.out.println(String.valueOf(a))
        );
        int a = 0;
        while(++a<Integer.MAX_VALUE);
        System.out.printf(String.valueOf(a));
        /*链表排序*/
        ArrayList<Integer> list = new ArrayList<>();
    }
}
