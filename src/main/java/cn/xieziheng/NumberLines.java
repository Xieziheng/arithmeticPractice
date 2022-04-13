package cn.xieziheng;

/**
 * @author binglang
 * @date 2022-04-13 18:39
 */
public class NumberLines {

    public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        if (s == null || s.length() == 0) {
            return result;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        int current = 0;
        int level = 1;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            int ans = widths[25 - ('z' - c)];
            if (ans + current > 100) {
                level++;
                current = 0;
            }
            current += ans;
        }
        result[0] = level;
        result[1] = current;
        return result;
    }
}
