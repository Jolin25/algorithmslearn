package top.algorithms.learn.others;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author jrl
 * @date Create in 11:13 2022-1-6
 * @Description string 转为保留两位小数点的形式
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "0102";
        int scale = 2;
        s = new StringTest().changeScale(scale, s);
        System.out.println(s);
        if (!s.contains("10")){
            System.out.println("0");
        }

    }

    private String changeScale(int scale, String s) {
        String tmp = s;
        try {
            BigDecimal bigDecimal = new BigDecimal(tmp).setScale(scale, RoundingMode.HALF_UP);
            s = bigDecimal.toString();
        } catch (NumberFormatException e) {
            System.out.println("该项不是数字");
        }
        System.out.println(s);
        return s;
    }
}
