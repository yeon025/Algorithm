import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // 1) 도감에 등록된 포켓몬의 번호 N과 맞춰야 하는 문제의 개수 M을 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);



        // 2) N번까지의 포켓몬 입력
        HashMap<Integer, String> pokedexMap = new HashMap<>();
        String[] pokedexList = new String[N];
        for (int i = 0; i < N; i++) {
            String poke = br.readLine();
            pokedexMap.put(i + 1, poke);
            pokedexList[i] = poke;
        }

        List<Integer> listKeySet = new ArrayList<>(pokedexMap.keySet());



        // 3) 맞춰야 할 포켓몬의 이름이나 번호를 입력
        String[] question = new String[M];
        for (int i = 0; i < M; i++) {
            question[i] = br.readLine();
        }



        // 4) 오름차순 정렬
        Collections.sort(listKeySet, Comparator.comparing(pokedexMap::get));
        // System.out.println("listKeySet : " + listKeySet);


        // 5) 변환
        String[] result = new String[M];

        for (int i = 0; i < M; i++) {
            if (question[i].charAt(0) > 47 && question[i].charAt(0) < 58) {

                // 6) 포켓몬의 번호를 받았다면 도감 번호와 매핑시키고 해당 포켓몬의 이름을 저장
                int pokeNo = Integer.parseInt(question[i]);
                result[i] = pokedexList[pokeNo - 1];
            } else {

                // 7) 이름을 받았다면 번호로 저장
                int low = 0;
                int high = N - 1;
                int mid = (low + high) / 2;

                while (low <= high) {
                    int keyMid = listKeySet.get(mid);

                    if (question[i].compareTo(pokedexMap.get(keyMid)) == 0) {
                        result[i] = String.valueOf(keyMid);
                        break;
                    } else if (question[i].compareTo(pokedexMap.get(keyMid)) < 0) {
                        high = mid - 1;
                        mid = (low + high) / 2;
                    } else {
                        low = mid + 1;
                        mid = (low + high) / 2;
                    }
                }
            }
        }



        // 8) 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < M; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}