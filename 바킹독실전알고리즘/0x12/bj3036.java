import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3036 {
    static int[] rings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        rings = new int[N];
        for(int i=0;i<N;i++){
            rings[i] = Integer.parseInt(stk.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int first = rings[0];
        for(int i=1;i<N;i++){
            int A = first;
            int B = rings[i];
            int g = gcd(A,B);
            if(g!=1) {
                A /= g;
                B /= g;
            }
            sb.append(A+"/"+B+"\n");
        }
        System.out.print(sb);
    }

    private static int gcd(int a, int b) {
        if(b==0)return a;
        return gcd(b,a%b);
    }
}
