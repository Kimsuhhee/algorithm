import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11727 {
    static int n;
    static int[] d = new int[1005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp();
    }

    private static void dp() {
        d[1] = 1;
        d[2] = 3;
        for(int i=3;i<=n;i++){
            d[i] = (d[i-2]*2 + d[i-1]) % 10007;
        }
        System.out.println(d[n]);
    }
}
