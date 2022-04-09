package cn.xieziheng;

import cn.xieziheng.node.Node;

import java.util.*;
import java.util.stream.Collectors;

public class TreeLevelOrder {

    /**
     * Given an n-ary tree, return the level order traversal of its nodes' values.
     *
     * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<List<Node>> queue = new LinkedList<>();
        List<Node> levelOne = new ArrayList();
        levelOne.add(root);
        queue.add(levelOne);
        while (!queue.isEmpty()) {
            List<Node> nodes = queue.poll();
            result.add(nodes.stream().map(s->s.val).collect(Collectors.toList()));
            List<Node> children = new ArrayList<>();
            for (Node node : nodes) {
                for (Node child : node.children) {
                    children.add(child);
                }
            }
            if (children.size() > 0) {
                queue.add(children);
            }
        }
        return result;
    }
}
