import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 0;
        while (true) {
            // 입력
            String input = br.readLine();

            if (input != null) bw.write(input + "\n");

            idx++;
            if (idx == 100) break;
        }
        // 출력
        bw.flush();
    }
}