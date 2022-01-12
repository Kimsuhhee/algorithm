import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2992 {
    static String X;
    static int x,min;
    static int[] cnt = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = br.readLine();
       
        //카운팅 정렬
        for(int i=0;i<X.length();i++){
            cnt[X.charAt(i)-'0']++;
        }

        x = Integer.parseInt(X);
        min = Integer.MAX_VALUE;

        permutation(0,X.length(),"");

        if(min==Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }

    private static void permutation(int n, int N, String s) {
        if(n==N){
            int res = Integer.parseInt(s);
            if(res>x){
                min = Math.min(min,res);
            }
            return;
        }
        for(int i=0;i<10;i++){
            //0은 첫번째 위치로 올 수 없음
            if(n==0 && i==0)continue;
            if(cnt[i]>0){
                cnt[i]--;
                permutation(n+1, N, s+i);
                cnt[i]++;
            }
        }
    }
}
