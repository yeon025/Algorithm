import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] subject=new String[21];
        double[] credit=new double[21];
        String[] grade=new String[21];
        StringTokenizer st;

        for (int i=0; i <20; i++) {
            st=new StringTokenizer(br.readLine(), " ");
            subject[i]=st.nextToken();
            credit[i]=Double.parseDouble(st.nextToken());
            grade[i]=st.nextToken();
        }

        double sub_sum=0.0;
        double credit_sum=0.0;
        double except_credit=0.0;
        for (int i=0; i<20; i++){
            credit_sum+=credit[i];
            switch (grade[i]) {
                case "A+":
                    sub_sum+=credit[i]*4.5;
                    break;
                case "A0":
                    sub_sum+=credit[i]*4.0;
                    break;
                case "B+":
                    sub_sum+=credit[i]*3.5;
                    break;
                case "B0":
                    sub_sum+=credit[i]*3.0;
                    break;
                case "C+":
                    sub_sum+=credit[i]*2.5;
                    break;
                case "C0":
                    sub_sum+=credit[i]*2.0;
                    break;
                case "D+":
                    sub_sum+=credit[i]*1.5;
                    break;
                case "D0":
                    sub_sum+=credit[i]*1.0;
                    break;
                case "P":
                    except_credit+=credit[i];
                    break;
                default:
                    break;
            }
        }

        System.out.println(sub_sum/(credit_sum-except_credit));
    }
}