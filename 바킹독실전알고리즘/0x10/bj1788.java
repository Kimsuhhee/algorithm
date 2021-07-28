import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1788 {
    static int n;
    static int[] d = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d[1] = 1; d[2] = 1;
        for(int i=3;i<=1000000;i++){
            d[i] = (d[i-1] + d[i-2]) % 1000000000;
        }

        if(n<0){
            n = Math.abs(n);
            if(n%2 == 0) System.out.println(-1);
            else if(n%2 == 1) System.out.println(1);
            else System.out.println(0);
        }else if(n>0) System.out.println(1);
        else System.out.println(0);

        System.out.println(d[n]);

    }
}
