import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // 듣도 보도 못한 사람의 수를 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);


        // 듣도 못한 사람을 입력
        HashSet<String> neverHeard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            neverHeard.add(br.readLine());
        }


        // 보도 못한 사람을 입력
        HashSet<String> neverSeen = new HashSet<>();
        for (int i = 0; i < M; i++) {
            neverSeen.add(br.readLine());
        }


        // 듣지도 보지도 못한 사람의 교집합을 구함
        neverHeard.retainAll(neverSeen);


        // 오름차순 정렬
        List<String> neverList = new ArrayList<>(neverHeard);
        Collections.sort(neverList);


        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(neverList.size() + "\n");
        for(String person : neverList) {
            bw.write(person + "\n");
        }
        bw.flush();
        bw.close();
    }
}