import java.util.*;

public class Main {
    public static void main(String[] args) {
        int wordCount = 0;
        List<String> wordList = new ArrayList<>();

        // 1) 문장 입력
        Scanner scanner = new Scanner(System.in);
        String[] tmp = scanner.nextLine().split(" ");

        int i = 0;
        while(i < tmp.length) {
            wordList.add(tmp[i]);
            i++;
        }

        // 2) 문장 앞의 공백 제거
        if (wordList.isEmpty()) {

        } else if (wordList.get(0).isEmpty()) {
            wordList.remove(0);
        }

        // 3) wordList의 사이즈를 구함
        wordCount = wordList.size();

        // 4) 결과 출력
        System.out.println(wordCount);
    }
}