package cn.xieziheng;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorse {

    /**
     * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
     *
     * 'a' maps to ".-",
     * 'b' maps to "-...",
     * 'c' maps to "-.-.", and so on.
     * For convenience, the full table for the 26 letters of the English alphabet is given below:
     *
     * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
     * Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.
     *
     * For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
     * Return the number of different transformations among all words we have.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-morse-code-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String[] MORSE = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> result = new HashSet<>();
        for (String str : words) {
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            for (char c : chars) {
                String m = MORSE[25 - ('z' - c)];
                sb.append(m);
            }
            result.add(sb.toString());
        }
        return result.size();
    }
}
