import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // 1) 출입 횟수 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        // 2) 누가 출입했는지 입력
        // 3) 들어온 사람과 나간 사람을 리스트에 저장
        List<String> enteredList = new ArrayList<>();
        List<String> leavedList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");

            if (tmp[1].equals("enter")) {
                enteredList.add(tmp[0]);
            } else {
                leavedList.add(tmp[0]);
            }
        }


        // 4) 이진 탐색을 하기 위해 enteredList를 오름차순 정렬
        Collections.sort(enteredList);


        // 5) 이진 탐색으로 enteredList에서 요소 삭제
        for (int i = 0; i< leavedList.size(); i++) {
            int low = 0;
            int high = enteredList.size() - 1;
            int mid = (low + high) / 2;

            while (low <= high) {
                if (enteredList.get(mid).compareTo(leavedList.get(i)) == 0) {
                    enteredList.remove(mid);
                    break;
                } else if (enteredList.get(mid).compareTo(leavedList.get(i)) > 0) {
                    high = mid - 1;
                    mid = (low + high) / 2;
                } else {
                    low = mid + 1;
                    mid = (low + high) / 2;
                }
            }
        }



        // 6) 리스트를 역순으로 배열
        enteredList.sort(Collections.reverseOrder());


        // 7) 회사에 남아있는 사람을 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (String entered : enteredList) {
            bw.write(entered + "\n");
        }
        bw.flush();
        bw.close();
    }
}