/*   Created by IntelliJ IDEA.
 *   Author: Sanat Kumar Dubey (sanat04)
 *   Date: 22-02-2023
 *   Time: 23:56
 *   File: RemoveKeywordAndOperator.java
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class RemoveKeywordAndOperator {
    private StringBuilder code;
    private ArrayList<String> keywords;
    private ArrayList<String> operators;

    RemoveKeywordAndOperator(StringBuilder code) {
        this.code = code;
        String[] keywordString = new String[]{"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};
        String[] operatorString = new String[]{"++", "--", "==", "!=", ">", "<", ">=", "<=", "&&", "||", "!", "&", "|", "^", "~", "<<", ">>", ">>>", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=", "<<=", ">>=", ">>>=","+", "-", "*", "/", "%"};
        keywords = new ArrayList<>(Arrays.asList(keywordString));
        operators = new ArrayList<>(Arrays.asList(operatorString));
    }

    public void removeAllKeywordsAndOperator() {

        String s = code.toString();
        for (String keyword : keywords) {
            s = s.replaceAll(keyword, " ");
        }
        for (String operator : operators) {
            if(s.contains(operator)){
                s = s.replaceAll("\\b" + operator + "\\b", " ");
            }
        }
        code = new StringBuilder(s);
    }

    public StringBuilder getCode() {
        return code;
    }

    public void setCode(StringBuilder code) {
        this.code = code;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public ArrayList<String> getOperators() {
        return operators;
    }

    public void setOperators(ArrayList<String> operators) {
        this.operators = operators;
    }
}

