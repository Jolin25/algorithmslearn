package top.algorithms.learn.code;

/**
 * IP地址解析：
 * 给定一个字符串表示的IP地址，比如“123.92.2.34”，判断其是否合法。合法IP地址的规则如下：
 * 1. 除了空格、数字和.之外，不得包含其他字符
 * 2. IP地址由四个数字构成，由.分隔，每个隔开的数字大小在0~255之间
 * 3. 数字前后可以有空格，但中间不能有空格。比如“123 . 92 .1. 2”合法，“1 23.2.1.1”非法
 * <p>
 * 合法：
 * 123.234. 255 .0
 * 不合法：
 * 256.1 23.abc
 * null
 * “ ”
 *
 * @author jrl
 * @date Create in 18:58 2022/5/1
 */
public class LegalIP {
    public static void main(String[] args) {
        boolean check = new LegalIP().check("123.234. 255 .0");
        System.out.println(check);
    }

    public boolean check(String ip) {
        // 判断IP是否为null
        if (ip == null) {
            return false;
        }
        // 拆为小部分，并判断是否为4部分
        // DONE_Joly:正则表达式 关于反斜杠和.--->普通程序中，即使是正则中，斜杠也就是斜杠。
        // 但是java中，由于string的设计，导致斜杠，是特殊的转义字符，所以，在正则中，如果想要写普通的，正则的转义，比如'\d'表示数字，则要写成'\\d'才可以。
        // 所就变成了：其他程序中，正常的写单个的斜杠的，java中(字符串里面表示斜杠需要两个斜杠如“\\”)，都要变成双斜杠。
        String[] ipSegements = ip.split("\\.");
        System.out.println(ipSegements.length);
        if (ipSegements.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            boolean valid = this.checkSegment(ipSegements[i]);
            if (!valid) {
                return false;
            }
        }
        return true;

    }

    private boolean checkSegment(String ipSegement) {
        int i = 0;
        int n = ipSegement.length();
        int num = 0;
        //找到第一个不为空的字符
        if (i < n && ipSegement.charAt(i) == ' ') {
            i++;
        }
        // 为空(字符串全为空格)
        if (i == n) {
            return false;
        }
        int digit = 0;
        while (i < n && ipSegement.charAt(i) != ' ') {
            // 对每个小部分判断是否为纯数字
            if (ipSegement.charAt(i) > '9' || ipSegement.charAt(i) < '0') {
                return false;
            }
            // 判断是否在0~255 牛掰了
            digit = digit * 10 + ipSegement.charAt(i) - '0';
            i++;
        }
        if (digit > 255) {
            return false;
        }
        // 处理后置空格 "123 ","123   ","1 23"
        while (i < n) {
            if (ipSegement.charAt(i) != ' ') {
                return false;
            }
            i++;
        }

        try {
            int i1 = Integer.parseInt(ipSegement);
            System.out.println(i1);
        } catch (Exception e) {

        }

        return true;
    }
}
