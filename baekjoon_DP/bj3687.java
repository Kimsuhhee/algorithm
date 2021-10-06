import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj3687 {
    static int T,n;
    static long[]min = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp();
        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            String max = "";
            if(n%2==0){
                for(int i=0;i<n/2;i++)max+="1";
            }else{
                max+="7";
                for(int i=0;i<n/2-1;i++)max+="1";
            }
            sb.append(min[n]+" "+max).append("\n");
        }

        System.out.println(sb);
    }

    private static void dp() {
        Arrays.fill(min,Long.MAX_VALUE);
        min[2] = 1; min[3] = 7; min[4] = 4;
        min[5] = 2; min[6] = 6; min[7] = 8;
        min[8] = 10; min[9] = 18; min[10] = 22;

        String[]cnt = {"1","7","4","2","0","8"};
        for(int i=11;i<=100;i++){
            for(int j=2;j<=7;j++){
                String tmp = min[i-j]+cnt[j-2];
                min[i] = Math.min(min[i],Long.parseLong(tmp));
            }
        }

    }
}
