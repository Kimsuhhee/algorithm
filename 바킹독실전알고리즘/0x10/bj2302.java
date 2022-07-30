import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2302 {
    static int N,M;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        M = Integer.parseInt(br.readLine());

        d = new int[40+1];
        d[0] = 1; d[1] = 1;
        for(int i = 2 ; i <= 40 ; i++){
            d[i] = d[i-1] + d[i-2];
        }

        int pre = 0;
        int answer = 1;
        for(int i = 0 ; i < M ; i++){
            int vip = Integer.parseInt(br.readLine());
            answer *= d[vip - pre - 1];
            pre = vip;
        }
        answer *= d[N - pre];
        System.out.println(answer);

    }
}
