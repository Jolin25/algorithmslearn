package top.algorithms.learn.code;

/**
 * IP地址无效化：
 * 已知入参是有效的IPV4的IP地址，把.转化为[.]则为无效化
 *
 * @author jrl
 * @date Create in 15:37 2022/5/2
 */
public class IPInvalid {
    public static void main(String[] args) {
        String newIP = getInvalidIP("13.22.111.111");
        System.out.println(newIP);
        String s = defangIPaddr("123.1.2.12");
        System.out.println(s);
        String s1 = defangIPaddr2("12.2.5.126");
        System.out.println(s1);
    }

    /**
     * 我的答案
     *
     * @param
     * @return
     * @date 2022/5/2
     */
    private static String getInvalidIP(String oldIP) {
        StringBuilder newIP = new StringBuilder(oldIP);
        newIP.setLength(oldIP.length() + 3 * 2);
        for (int i = 0, j = 0; i < oldIP.length(); i++, j++) {
            if (oldIP.charAt(i) == '.') {
                newIP.setCharAt(j, '[');
                newIP.setCharAt(++j, '.');
                newIP.setCharAt(++j, ']');
            } else {
                newIP.setCharAt(j, oldIP.charAt(i));
            }
        }
        return newIP.toString();
    }

    /**
     * 老师的答案：char[]
     *
     * @param
     * @return
     * @date 2022/5/2
     */
    private static String defangIPaddr(String address) {
        // 为了处理方便直接转成数组
        char[] origin = address.toCharArray();
        int n = origin.length;
        int newN = n + 2 * 3;
        char[] newString = new char[newN];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (origin[i] == '.') {
                newString[k++] = '[';
                newString[k++] = '.';
                newString[k++] = ']';
            } else {
                newString[k++] = origin[i];
            }
        }
        return new String(newString);
    }

    /**
     * 老师的方法：StringBuilder
     *
     * @param
     * @return
     * @date 2022/5/2
     */
    public static String defangIPaddr2(String address) {
        // 动态可扩容的字符数组
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                sb.append("[.]");
            } else {
                sb.append(address.charAt(i));
            }
        }
        return new String(sb);
    }
}
