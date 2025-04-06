import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // 가지고 있는 숫자카드의 개수 N 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        // 가지고 있는 숫자카드 입력
        String[] haveCard = br.readLine().split(" ");
        Set<Integer> haveCardSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            haveCardSet.add(Integer.parseInt(haveCard[i]));
        }


        // 몇 장 가지고 있는지 알아볼 숫자카드 개수 입력
        int M = Integer.parseInt(br.readLine());


        // 몇 장 가지고 있는지 알아볼 숫자카드 입력
        String[] findCard = br.readLine().split(" ");
        HashSet<Integer> findCardSet = new HashSet<>();
        for (int i = 0; i < M; i++) {
            findCardSet.add(Integer.parseInt(findCard[i]));
        }


        // hashMap으로 '카드 숫자 종류' : '카드 개수'로 저장
        HashMap<Integer, Integer> haveCardMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(haveCard[i]);
            Optional<Integer> opt = Optional.ofNullable(haveCardMap.get(card));

            if (opt.isEmpty()) {
                haveCardMap.put(card, 1);
            } else {
                haveCardMap.put(card, haveCardMap.get(card) + 1);
            }
        }



        // 교집합
        findCardSet.retainAll(haveCardSet);
        // System.out.println("intersection : " + findCardSet);



        // 탐색
        int[] result = new int[M];

        for (int i = 0; i < M; i++) {
            int findCardToInt = Integer.parseInt(findCard[i]);
            if (!findCardSet.contains(findCardToInt)) {
                result[i] = 0;
                continue;
            }

            result[i] = haveCardMap.get(findCardToInt);
        }


        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int cardCount : result) {
           bw.write(cardCount + " ");
        }
        bw.flush();
        bw.close();
    }
}