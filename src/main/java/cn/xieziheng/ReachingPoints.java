package cn.xieziheng;

public class ReachingPoints {

    /**
     * Given four integers sx, sy, tx, and ty, return true if it is possible to convert the point (sx, sy) to the point (tx, ty) through some operations, or false otherwise.
     *
     * The allowed operation on some point (x, y) is to convert it to either (x, x + y) or (x + y, y).
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reaching-points
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param sx
     * @param sy
     * @param tx
     * @param ty
     * @return
     */
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (tx == ty) {
            if (tx != sx || ty != sy) {
                return false;
            } else {
                return true;
            }
        }
        while (tx != ty && tx > sx && ty > sy) {
            //将自减动作合并，用取余
            if (ty > tx) {
                ty %= tx;
            } else {
                tx %= ty;
            }
            if (tx == sx && ty == sy) {
                return true;
            }
        }
        if (sx > tx || sy > ty) {
            return false;
        }
        return sx == tx ? (ty - sy) % tx == 0 : (tx - sx) % ty == 0;
    }


}
