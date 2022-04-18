package cn.xieziheng;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binglang
 * @date 2022-04-18 18:58
 */
public class LexicalOrder {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    public void dfs(int target, int n, List<Integer> result) {
        if (target <= n) {
            result.add(target);
            int next = target * 10;
            for (int i = 0; i < 10; i++) {
                dfs(next + i, n, result);
            }
        }
    }
}
