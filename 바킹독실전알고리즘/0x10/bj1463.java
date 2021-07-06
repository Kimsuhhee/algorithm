import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1463 {
    static int n;
    static int[] d = new int[10000000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp();
    }

    private static void dp() {
        d[1] = 0;
        for(int i=2;i<=n;i++){
            d[i] = d[i-1]+1;
            if(i%2==0)
                d[i] = Math.min(d[i],d[i/2]+1);
            if(i%3==0)
                d[i] = Math.min(d[i],d[i/3]+1);
        }
        System.out.println(d[n]);
    }

}
