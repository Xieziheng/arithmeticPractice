package cn.xieziheng;

import java.util.*;

/**
 * @author binglang
 * @date 2022-04-13 19:10
 */
public class RandomizedSet {
    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    private Map<Integer, Integer> set;

    private List<Integer> array;

    public RandomizedSet() {
        set = new HashMap<>();
        array = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!contains(val)) {
            set.put(set.size(), val);
            array.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (contains(val)) {
            int index = array.indexOf(val);
            array.remove(index);
            set.remove(index);
            int size = set.size();
            for (int i = index; i <= size; i++) {
                if (i < size) {
                    //next val
                    int v = set.get(i + 1);
                    array.set(i, v);
                    set.put(i, v);
                } else {
                    set.remove(i);
                }
            }
            return true;
        }
        return false;
    }

    private boolean contains(int val) {
        return set.containsValue(val);
    }

    public int getRandom() {
        int size = set.size();
        int r = new Random().nextInt(size);
        return set.get(r);
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(1);
        set.remove(2);
        set.insert(2);
        int a = set.getRandom();
        System.out.println(a);
        set.remove(1);
        set.insert(2);
        a = set.getRandom();
        System.out.println(a);
    }
}
