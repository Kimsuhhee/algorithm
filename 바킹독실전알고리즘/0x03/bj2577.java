import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String mul = String.valueOf(A*B*C);
        String[] mularr= mul.split("");

        int[] numCnt = new int[10];

        for(int i=0;i<mularr.length;i++){
            numCnt[Integer.parseInt(mularr[i])]++;
        }


        for(int i=0;i<10;i++){
            System.out.println(numCnt[i]);
        }

    }
}
