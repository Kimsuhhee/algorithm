import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1956 {
    static int[] box,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        box = new int[n];
        d = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            box[i] = Integer.parseInt(stk.nextToken());
        }

        int answer = 0;
        d[0] = 1;
        for(int i=1;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(box[i]>box[j]){
                    max = Math.max(max,d[j]);
                }
                d[i] = max+1;
                answer = Math.max(d[i],answer);
            }
        }
        System.out.println(answer);

    }
}
