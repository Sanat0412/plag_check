/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 22-Oct-22
 *   Time: 10:17 PM
 *   File: Main.java
 */

import javax.swing.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName1 = JOptionPane.showInputDialog("Enter the name of the first file");
        String fileName2 = JOptionPane.showInputDialog("Enter the name of the second file");

        Read read1 = new Read(fileName1);
        Read read2 = new Read(fileName2);
        DistinguishWord d1 = solve(read1);
        DistinguishWord d2 = solve(read2);
        findSimilarity(d1, d2);


    }

    private static void findSimilarity(DistinguishWord d1, DistinguishWord d2) {
        Set<String> set = new HashSet<>();
        for (Map.Entry<String, Integer> i : d1.getWordCount().entrySet()) {
            set.add(i.getKey());
        }
        for (Map.Entry<String, Integer> i : d2.getWordCount().entrySet()) {
            set.add(i.getKey());
        }
        int match = 0;
        int totalWordCount = 0;
        for (String s : set) {
            if (d1.getWordCount().containsKey(s) && d2.getWordCount().containsKey(s)) {
                match += Math.min(d1.getWordCount().get(s), d2.getWordCount().get(s));
            }
            if (d1.getWordCount().containsKey(s) && d2.getWordCount().containsKey(s)) {
                totalWordCount += Math.max(d1.getWordCount().get(s), d2.getWordCount().get(s));
            }
        }
        double similarity = ((double) match / totalWordCount) * 100;
        // format the value upto 2 decimal places
        similarity = Double.parseDouble(String.format("%.2f", similarity));
        JOptionPane.showMessageDialog(null, "Similarity is " + similarity + "%");

    }

    private static DistinguishWord solve(Read read) throws IOException {
        read.readCodeFromFile();
        read.removeComments();
        RemoveKeywordAndOperator removeKeywordAndOperator = new RemoveKeywordAndOperator(read.getCode());
        removeKeywordAndOperator.removeAllKeywordsAndOperator();
        DistinguishWord distinguishWord = new DistinguishWord(removeKeywordAndOperator.getCode());
        distinguishWord.countWord();
        return distinguishWord;
    }
}
