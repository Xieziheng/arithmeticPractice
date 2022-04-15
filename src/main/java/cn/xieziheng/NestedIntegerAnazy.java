package cn.xieziheng;

import cn.xieziheng.nested.NestedInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binglang
 * @date 2022-04-15 23:12
 */
public class NestedIntegerAnazy {

    public NestedInteger deserialize(String s) {
        NestedInteger integer = null;
        if (s.startsWith("[")) {
//            integer = new NestedInteger();
            List<String> strs = spiltStr(s);
            for (String str : strs) {
                NestedInteger child = deserialize(str);
                if (child != null) {
                    integer.add(child);
                }

            }
        } else {
            if (s.length() != 0) {
//                integer = new NestedInteger();
                integer.setInteger(Integer.parseInt(s));
            }
        }
        return integer;
    }
    public static List<String> spiltStr(String s) {
        s = s.substring(1, s.length() - 1);
        List<String> result = new ArrayList();
        char[] chars = s.toCharArray();
        int in = 0;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '[') {
                in++;
            }
            if (c == ']') {
                in--;
            }
            if (c == ',' && in == 0) {
                result.add(s.substring(start, i));
                start = i + 1;
            }
        }
        result.add(s.substring(start, s.length()));
        return result;
    }
}
