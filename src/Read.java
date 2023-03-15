/*   Created by IntelliJ IDEA.
 *   Author: Sanat Kumar Dubey (sanat04)
 *   Date: 22-02-2023
 *   Time: 23:56
 *   File: Read.java
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class Read {
    private StringBuilder code;
    private String fileName;

    Read(String fileName) {
        code = new StringBuilder();
        this.fileName=fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public StringBuilder getCode() {
        return code;
    }

    public void setCode(StringBuilder code) {
        this.code = code;
    }

    public void readCodeFromFile() throws IOException {
        // read code from file
        File file = new File("C:\\Users\\Prashant Dubey\\IdeaProjects\\plag_check\\src\\" + fileName);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            code.append(st);
            code.append("\n");
        }
    }

    public void removeComments() {
        String s = code.toString();
        s = s.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", " ");
        code = new StringBuilder(s);
    }
}

