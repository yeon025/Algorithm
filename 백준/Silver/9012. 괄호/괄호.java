import java.io.*;
import java.util.*;


public class Main {

    public static String checkParentheses(String parentheses) {
        ArrayList<String> stack = new ArrayList<>();
        String[] splited = parentheses.split("");
        String isCorrect = "YES";

        for (String tmp : splited) {
            if (Objects.equals(tmp, "(")) {
                stack.add("(");
            } else {
                if (!stack.isEmpty()) { stack.remove(stack.size() - 1); }
                else { isCorrect = "NO"; }
            }
        }

        if (!stack.isEmpty()) { isCorrect = "NO"; }

        return isCorrect;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 T 입력
        int T = Integer.parseInt(br.readLine());

        // 괄호 입력
        ArrayList<String> parenthesesList = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            parenthesesList.add(input);
        }

        // 괄호가 올바른지 확인
        for (String parentheses : parenthesesList) {
            String isCorrect = checkParentheses(parentheses);
            System.out.println(isCorrect);
        }
    }
}