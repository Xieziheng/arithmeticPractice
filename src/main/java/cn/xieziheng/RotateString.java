package cn.xieziheng;

public class RotateString {

    /**
     * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
     *
     * A shift on s consists of moving the leftmost character of s to the rightmost position.
     *
     * For example, if s = "abcde", then it will be "bcdea" after one shift.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        if (s.equals(goal)) {
            return true;
        }
        int len = s.length();
        if (len != goal.length()) {
            return false;
        }
        for (int i = len - 1; i > 0; i--) {
            String left = s.substring(0, i);
            if (goal.endsWith(left)) {
                int index = goal.indexOf(left);
                String right = goal.substring(0, index);
                if (s.endsWith(right)) {
                    return true;
                }
            }
        }
        return false;
    }
}
