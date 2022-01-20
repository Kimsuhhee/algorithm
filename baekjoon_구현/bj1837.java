import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1837 {
    static String p;
    static int k;
    static boolean[] isNotPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        p = stk.nextToken();
        k = Integer.parseInt(stk.nextToken());

        isNotPrime = new boolean[1000001];
        for(int i=2;i<=100000;i++){
            for(int j=i+i;j<=100000;j+=i){
                isNotPrime[j] = true;
            }
        }

        for(int i=2;i<k;i++){
            if(!isNotPrime[i]){
                if(cal(i)) {
                    System.out.println("BAD "+i);
                    System.exit(0);
                }
            }
        }

        System.out.println("GOOD");

    }

    private static boolean cal(int x) {
        int tens = 0;
        for(int i=0;i<p.length();i++){
            tens = (tens * 10 + (p.charAt(i)-'0')) % x;
        }
        if(tens==0)return true;
        else return false;
    }
}
