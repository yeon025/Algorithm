import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 채팅방의 기록 수 N 입력
        Integer N = Integer.parseInt(br.readLine());

        // N번 채팅 입력
        ArrayList<String> chats = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            chats.add(br.readLine());
        }

        // ENTER 이후에 중복되지 않는 닉네임을 셈
        int count = 0;
        Set<String> nicknames = new HashSet<>();
        for (String chat : chats) {
            if (Objects.equals(chat, "ENTER")) {
                count = count + nicknames.size();
                nicknames = new HashSet<>();
            } else {
                nicknames.add(chat);
            }
        }
        count = count + nicknames.size();

        // 출력
        bw.write(count + "\n");
        bw.flush();
    }
}