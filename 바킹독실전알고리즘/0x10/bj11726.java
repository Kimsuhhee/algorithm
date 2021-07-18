import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11726 {
    static int n;
    static int[]d = new int[10000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp();
    }

    private static void dp() {
        d[1] = 1;
        d[2] = 2;
        d[3] = 3;
        d[4] = 5;
        for(int i=5;i<=n;i++){
            d[i] = (d[i-1]+d[i-2]) %10007;
        }
        System.out.println(d[n]);
    }
}
