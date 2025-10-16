import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<String> stack;
    static int size;


    public static boolean checkCloseParentheses(String closeParentheses) {
        boolean isCorrect = true;

        if (stack.isEmpty()) {
            isCorrect = false;
        } else if (Objects.equals(closeParentheses, ")")) {
            String removed = stack.remove(size - 1);
            size = stack.size();

            if (Objects.equals(removed, "[")) isCorrect = false;
        } else {
            String removed = stack.remove(size - 1);
            size = stack.size();

            if (Objects.equals(removed, "(")) isCorrect = false;
        }

        return isCorrect;
    }

    public static boolean checkParentheses(String parentheses) {
        stack = new ArrayList<>();
        size = 0;
        boolean isCorrect = true;

        // 괄호들을 하나씩 분해
        String[] splited = parentheses.split("");

        for (String tmp : splited) {
            // . 이면 종료
            if (Objects.equals(tmp, ".") || !isCorrect) break;

            // 여는 괄호는 스택에 넣음
            if (Objects.equals(tmp, "(") || Objects.equals(tmp, "[")) {
                stack.add(tmp);
                size = stack.size();
            } else {
                // 닫는 괄호는 여는 괄호와 동일한지 확인
                isCorrect = checkCloseParentheses(tmp);
            }
        }

        // 스택에 괄호가 남아 있으면 짝지어지는 닫는 괄호가 없는거임
        if (!stack.isEmpty()) isCorrect = false;

        return isCorrect;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문자열 입력
        ArrayList<String> sentences = new ArrayList<>();
        while (true) {
            String sentence = br.readLine();
            if (Objects.equals(sentence, ".")) break;
            sentences.add(sentence);
        }

        // 알파벳과 공백 제거
        ArrayList<String> changedList = new ArrayList<>();
        for (String sentence : sentences) {
            String changed = sentence.replaceAll("[a-zA-Z]", "");
            changed = changed.replaceAll(" ", "");
            changedList.add(changed);
        }

        // 괄호 확인
        ArrayList<String> results = new ArrayList<>();
        for (String parentheses : changedList) {
            boolean isCorrect = checkParentheses(parentheses);

            if (isCorrect) results.add("yes");
            else results.add("no");
        }

        // 출력
        for (String result : results) {
            bw.write(result + "\n");
        }
        bw.flush();
    }
}