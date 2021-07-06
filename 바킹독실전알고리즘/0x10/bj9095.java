import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9095 {
    static int T,n;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            d = new int[20];
            dp();
        }

    }

    private static void dp() {
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for(int i=4;i<=n;i++){
            d[i] = d[i-1]+d[i-2]+d[i-3];
        }
        System.out.println(d[n]);
    }
}
