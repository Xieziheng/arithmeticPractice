package cn.xieziheng;

import java.util.*;

/**
 * @author binglang
 * @date 2022-04-18 17:04
 */
public class ParagraphBanned {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bet = new HashSet<>(Arrays.asList(banned));
        paragraph = paragraph.toLowerCase();
        String[] points = {"!","?",";","\'",",","."};
        for (String point : points) {
            paragraph = paragraph.replace(point, " ");
        }
        String[] strs = paragraph.split(" ");
        String most = "";
        Integer count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            if (!bet.contains(str) && str.length() > 0) {
                Integer i = map.get(str);
                if (i == null) {
                    i = 1;
                    map.put(str, i);
                } else {
                    i++;
                    map.put(str, i + 1);
                }
                if (i > count) {
                    most = str;
                    count = i;
                }
            }
        }
        return most;
    }
}
