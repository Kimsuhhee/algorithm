import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2748 {
    static int n;
    static long[] d = new long [91];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp();
        System.out.println(d[n]);
    }

    private static void dp() {
        d[0] = 0; d[1] = 1;
        for(int i=2;i<91;i++){
            d[i] = d[i-1] + d[i-2];
        }
    }
}
