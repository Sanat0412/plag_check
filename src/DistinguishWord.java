/*   Created by IntelliJ IDEA.
 *   Author: Sanat Kumar Dubey (sanat04)
 *   Date: 22-02-2023
 *   Time: 23:56
 *   File: DistinguishWord.java
 */
import java.util.HashMap;

public class DistinguishWord {
    private HashMap<String, Integer> wordCount;
    private StringBuilder code;

    public DistinguishWord(StringBuilder code) {
        this.wordCount = new HashMap<>();
        this.code = code;
    }

    public void countWord() {
        // remove all space that greater than 1
        code = removeExtraSpace();
        // remove all types of brackets
        code = removeBrackets();
        // split the code into words
        String[] words = code.toString().split(" ");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
    }

    private StringBuilder removeBrackets() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '(' || code.charAt(i) == ')' || code.charAt(i) == '{' || code.charAt(i) == '}' || code.charAt(i) == '[' || code.charAt(i) == ']') {
                s.append(" ");
            } else {
                s.append(code.charAt(i));
            }
        }
        return s;
    }

    private StringBuilder removeExtraSpace() {
        String s = code.toString();
        s = s.replaceAll("\\s+", " ");
        return new StringBuilder(s);
    }

    public HashMap<String, Integer> getWordCount() {
        return wordCount;
    }

    public void setWordCount(HashMap<String, Integer> wordCount) {
        this.wordCount = wordCount;
    }

    public StringBuilder getCode() {
        return code;
    }

    public void setCode(StringBuilder code) {
        this.code = code;
    }

    public void displayAllWordWithCount() {
        for (String word : wordCount.keySet()) {
            System.out.println(word + " " + wordCount.get(word));
        }
    }
}


