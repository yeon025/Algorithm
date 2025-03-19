import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // 1) 입력할 단어 개수 N 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        // 2) N개의 단어 입력
        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            wordSet.add(br.readLine());
        }


        // 3) set을 배열로 변환
        String[] tmp = wordSet.toArray(new String[0]);
        String[][] wordArray = new String[tmp.length][2];
        for (int i = 0; i < tmp.length; i++) {
            wordArray[i][0] = tmp[i];
        }


        // 4) 단어의 길이를 구함
        int len = 0;
        for (int i = 0; i < wordArray.length; i++) {
            len = wordArray[i][0].length();
            wordArray[i][1] = Integer.toString(len);
        }


        // 5)오름차순 정렬
        Arrays.sort(wordArray, (o1, o2) -> {
            return o1[0].compareTo(o2[0]);
        });

        Arrays.sort(wordArray, (o1, o2) -> {
            return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
        });


        // 6) 출력
        for (int i = 0; i < wordArray.length; i++) {
            System.out.println(wordArray[i][0]);
        }

    }
}