import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // 집합 A와 B의 원소의 개수를 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);


        // 집합 A의 원소 입력
        HashSet<Integer> unionA = new HashSet<>();
        tmp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            unionA.add(Integer.parseInt(tmp[i]));
        }


        // 집합 B의 원소 입력
        HashSet<Integer> unionB = new HashSet<>();
        tmp = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            unionB.add(Integer.parseInt(tmp[i]));
        }


        // 두 집합의 차집합을 구함
        HashSet<Integer> differenceUnionA = new HashSet<>(unionA);
        HashSet<Integer> differenceUnionB = new HashSet<>(unionB);
        differenceUnionA.removeAll(unionB);
        differenceUnionB.removeAll(unionA);

        // System.out.println("A : " + differenceUnionA);
        // System.out.println("B : " + differenceUnionB);


        // 개수 출력
        System.out.println(differenceUnionA.size() + differenceUnionB.size());
    }
}